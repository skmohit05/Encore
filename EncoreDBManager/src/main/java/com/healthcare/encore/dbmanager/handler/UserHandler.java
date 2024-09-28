/**
 *
 */
package com.healthcare.encore.dbmanager.handler;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.encore.commons.mailservice.JavaMailContent;
import com.healthcare.encore.commons.mailservice.JavaMailService;
import com.healthcare.encore.commons.rsa.RSAUtil;
import com.healthcare.encore.db.dao.OrganizationDAO;
import com.healthcare.encore.db.dao.UserAuthenticationDAO;
import com.healthcare.encore.db.dao.UserDAO;
import com.healthcare.encore.db.dto.OrganizationDTO;
import com.healthcare.encore.db.dto.UserAuthenticationDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.RecordNotFoundException;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.UserMapperUtil;
import com.healthcare.encore.dbmanager.mapper.OrganizationMapper;
import com.healthcare.encore.dbmanager.mapper.UserMapper;
import com.healthcare.encore.model.MFATypeEnum;
import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserDetails;
import com.healthcare.encore.model.UserStatusTypeEnum;
import com.healthcare.encore.model.UserTypeEnum;
import com.healthcare.encore.security.SecurityManager;

/**
 *
 * @author ckumar
 *
 */
@Component
@Transactional
public class UserHandler {

   /**
    *
    */
   private static final String OTP_MAILER_SUBJECT = "Registration Successful!";

   /**
    * UserDAO reference
    */
   @Autowired
   private UserDAO userDAO;

   /**
    * UserMapper reference
    */
   @Autowired
   private UserMapper userMapper;

   /**
    * SecurityManager reference
    */
   @Autowired
   private SecurityManager securityManager;

   /**
    * UserMapperUtil reference
    */
   @Autowired
   private UserMapperUtil userMapperUtil;

   /**
    * BCryptPasswordEncoder reference
    */
   @Autowired
   private BCryptPasswordEncoder pwdEncoder;

   /**
    *
    */
   @Autowired
   private OTPHandler otpHandler;

   /**
    *
    */
   @Autowired
   private EnumMapperUtil enumMapperUtil;

   /**
    *
    */
   @Autowired
   private DBManagerUtil dbManagerUtil;

   /**
    *
    */
   @Autowired
   private UserAuthenticationDAO userAuthDAO;

   /**
    *
    */
   @Autowired
   private OrganizationMapper organizationMapper;

   /**
    *
    */
   @Autowired
   private OrganizationDAO organizationDAO;

   /**
    *
    * @param applyActiveFilter
    * @return
    */
   public List<User> getAllUsers(final boolean applyActiveFilter) {
      List<UserDTO> userDTOs = this.userDAO.findAll(applyActiveFilter);
      return this.userMapper.getModel(userDTOs);
   }

   /**
    *
    * @param user
    */
   public void saveOrUpdate(final User user) {
      UserDTO userDTO = this.userDAO.findById(user.getUserId());
      if (user.getOrganization() != null) {
         OrganizationDTO orgDTO = this.organizationMapper.getDTO(user.getOrganization());
         orgDTO = this.organizationDAO.makePersistent(orgDTO);
         userDTO.setOrganizationDTO(orgDTO);
      }
      this.userDAO.makePersistent(userDTO);
   }

   /**
    *
    * @param emailId
    * @return
    */
   public User getUser(final String emailId) {
      UserDTO userDTO = this.userDAO.findByEmailId(emailId);
      return userDTO == null ? null : this.userMapper.getModel(userDTO);
   }

   /**
    *
    * @param userId
    * @return
    */
   public User getUser(final Integer userId) {
      UserDTO userDTO = this.userDAO.findById(userId);
      return userDTO == null ? null : this.userMapper.getModel(userDTO);
   }

   /**
    *
    * @param loginId
    * @param existingPassword
    * @param newPassword
    */
   public void changePassword(final Integer userId, final String existingPassword, final String newPassword) {
      User user = this.getUser(userId);
      boolean userValidated = user == null ? false
               : this.securityManager.validateUserCredentials(user.getEmail(), RSAUtil.decrypt(existingPassword));
      UserDTO userDTO = this.userMapperUtil.getUserDTO(userId);
      if (userValidated) {
         userDTO.setPassword(this.pwdEncoder.encode(RSAUtil.decrypt(newPassword)));
         this.userDAO.makePersistent(userDTO);
      } else {
         throw new AccessDeniedException("Invalid credentials");
      }
   }

   /**
    *
    * @param userId
    * @param email
    * @param otp
    * @param password
    */
   public void resetPassword(final Integer userId, final String email, final String password) {
      UserDTO userDTO = this.userDAO.findByEmailId(email);
      if (userDTO == null) {
         throw new RecordNotFoundException("User record not found [" + "EmailId=" + email + "]");
      }

      userDTO.setPassword(this.pwdEncoder.encode(RSAUtil.decrypt(password)));
      this.userDAO.makePersistent(userDTO);
   }

   /**
    *
    * @param emailId
    * @param otp
    * @return
    */
   public User createVerifiedUser(final String emailId, final String otp) {
      boolean isValidOtp = this.otpHandler.validateOTP(emailId, otp);
      return isValidOtp ? this.createUserWithVerifiedStatus(emailId, otp) : null;
   }

   /**
    *
    * @param emailId
    * @param otp
    * @return
    */
   public User getVerifiedUser(final String emailId, final String otp) {
      boolean isValidOtp = this.otpHandler.validateOTP(emailId, otp);
      return isValidOtp ? this.getUser(emailId) : null;
   }

   /**
    *
    * @param userDetails
    * @return
    */
   public User updateUser(final UserDetails userDetails) {
      UserDTO userDTO = this.userDAO.findByEmailId(userDetails.getEmail());
      if (userDTO != null) {
         userDTO.setFirstName(userDetails.getFirstName());
         userDTO.setLastName(userDetails.getLastName());
         userDTO.setPassword(this.pwdEncoder.encode(RSAUtil.decrypt(userDetails.getPassword())));
         userDTO.setStatusTypeDTO(this.enumMapperUtil.getDTO(UserStatusTypeEnum.Active));
         userDTO.setAuditInfoDTO(this.dbManagerUtil.getForcedAuditInfo());
         if (userDetails.getUserType() != null) {
            userDTO.setUserTypeDTO(this.enumMapperUtil.getDTO(userDetails.getUserType()));
         }
         UserDTO updatedUser = this.userDAO.makePersistent(userDTO);
         this.saveUserAuthenticationInfo(userDTO);
         String emailContent = UserTypeEnum.Employer.equals(userDetails.getUserType())
                  ? JavaMailContent.getEmployerSendWelcomeAccountCreationMailContent(userDetails.getFirstName())
                  : JavaMailContent.getJobseekerSendWelcomeAccountCreationMailContent(userDetails.getFirstName());
         JavaMailService.sendEmail(userDetails.getEmail(), OTP_MAILER_SUBJECT, emailContent);
         return this.userMapper.getModel(updatedUser);
      } else {
         return null;
      }
   }

   private void saveUserAuthenticationInfo(final UserDTO userDTO) {
      UserAuthenticationDTO userAuthDTO = new UserAuthenticationDTO();
      Calendar cal = Calendar.getInstance();
      LocalDate now = Instant.ofEpochMilli(cal.getTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
      userAuthDTO.setMfaPassed(true);
      userAuthDTO.setLastSigninDate(now);
      userAuthDTO.setUserDTO(userDTO);
      userAuthDTO.setMfaTypeDTO(this.enumMapperUtil.getDTO(MFATypeEnum.EMAIL));
      this.userAuthDAO.makePersistent(userAuthDTO);
   }

   /**
    *
    * @param userId
    */
   public void updateUserLastSignIn(final Integer userId) {
      UserAuthenticationDTO dto = this.userAuthDAO.findByUserId(userId);
      Calendar cal = Calendar.getInstance();
      LocalDate now = Instant.ofEpochMilli(cal.getTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
      dto.setLastSigninDate(now);
      this.userAuthDAO.makePersistent(dto);
   }

   /**
    *
    * @param emailId
    * @return
    */
   private User createUserWithVerifiedStatus(final String emailId, final String otp) {
      User user = this.getUser(emailId);
      UserDTO userDTO = null;
      if (user != null && user.getStatus() == UserStatusTypeEnum.Verified) {
         userDTO = this.userDAO.findByEmailId(emailId);
         userDTO.setPassword(this.pwdEncoder.encode(otp));
      } else {
         userDTO = new UserDTO();
         userDTO.setEmail(emailId);
         userDTO.setPassword(this.pwdEncoder.encode(otp));
         userDTO.setStatusTypeDTO(this.enumMapperUtil.getDTO(UserStatusTypeEnum.Verified));
         userDTO.setAuditInfoDTO(this.dbManagerUtil.getForcedAuditInfo());
      }
      userDTO = this.userDAO.makePersistent(userDTO);
      return this.userMapper.getModel(userDTO);
   }
}
