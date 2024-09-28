/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.UserStatusTypeEnum;
import com.healthcare.encore.model.User;

/**
 * @author ckumar
 *
 */
@Component
public class UserMapper extends AbstractMapper<UserDTO, User> {

   /**
    * 
    */
   @Autowired
   private EnumMapperUtil enumMapperUtil;

  /**
   * 
   */
   @Autowired
   private OrganizationMapper organizationMapper;

  /**
   * 
   */
   @Autowired
   private SetupMapperUtil setupMapperUtil;

   /**
    * 
    */
   @Autowired
   private DBManagerUtil dbManagerUtil;

   /**
    * {@inheritDoc}
    */
   @Override
   public User getModel(final UserDTO userDTO) {
      User user = new User();
      this.setupMapperUtil.mapSetupDTOToModel(userDTO, user);
      user.setUserId(userDTO.getId());
      user.setFirstName(userDTO.getFirstName());
      user.setLastName(userDTO.getLastName());
      user.setEmail(userDTO.getEmail());
      user.setPassword(null);
      user.setStatus(this.enumMapperUtil.getModel(userDTO.getStatusTypeDTO()));
      user.setFieldType(this.enumMapperUtil.getModel(userDTO.getFieldTypeDTO()));
      user.setUserType(this.enumMapperUtil.getModel(userDTO.getUserTypeDTO()));
      user.setRegistrationDate(userDTO.getRegistrationDate());
      user.setRemoveRequestedDate(userDTO.getRemoveRequestedDate());
      userDTO.setAuditInfoDTO(this.dbManagerUtil.getForcedAuditInfo());
      if (userDTO.getOrganizationDTO() != null) {
         user.setOrganization(this.organizationMapper.getModel(userDTO.getOrganizationDTO()));
      }
      return user;
   }

   /**
    * @param user
    * @return UserDTO
    *
    */
   public UserDTO getDTO(final User user) {
      UserDTO userDTO = new UserDTO();
      Integer userId = user.getUserId();
      if (userId != null && user.getStatus().equals(UserStatusTypeEnum.Active)) {
         UserDTO currentUserDTO = this.setupMapperUtil.getUserDTO(userId, true);
         userDTO.setPassword(currentUserDTO.getPassword());
      }
      userDTO.setFirstName(user.getFirstName());
      userDTO.setLastName(user.getLastName());
      userDTO.setEmail(user.getEmail());
      userDTO.setStatusTypeDTO(this.enumMapperUtil.getDTO(user.getStatus()));
      userDTO.setFieldTypeDTO(this.enumMapperUtil.getDTO(user.getFieldType()));
      userDTO.setUserTypeDTO(this.enumMapperUtil.getDTO(user.getUserType()));
      userDTO.setRegistrationDate(user.getRegistrationDate());
      userDTO.setRemoveRequestedDate(user.getRemoveRequestedDate());
      if (user.getOrganization() != null) {
         userDTO.setOrganizationDTO(this.organizationMapper.getDTO(user.getOrganization()));
      }
      return userDTO;
   }
}
