package com.healthcare.encore.dbmanager.handler;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.healthcare.encore.commons.mailservice.JavaMailContent;
import com.healthcare.encore.commons.mailservice.JavaMailService;
import com.healthcare.encore.model.UserStatusTypeEnum;
import com.healthcare.encore.model.OTPRequestTypeEnum;
import com.healthcare.encore.model.User;

/**
 * 
 * @author ckumar
 *
 */
@Component
public final class OTPHandler {

   /**
    * 
    */
   private static final Logger LOG = Logger.getLogger(OTPHandler.class);
   
   /**
    * 
    */
   private static final String REGISTRATION_OTP_MAILER_SUBJECT = "OTP for Email Verification";
   
   private static final String RESET_PASSWORD_OTP_MAILER_SUBJECT = "OTP for Reset Password";

   /**
    * 
    */
   private static final Integer EXPIRY_MINS = 5;

   /**
    *
    */
   private LoadingCache<String, String> cache; //NOPMD

   /**
    * 
    */
   @Autowired
   private UserHandler userHandler;

   /**
    * 
    */
   private OTPHandler() {
      this.cache = Caffeine.newBuilder().expireAfterWrite(EXPIRY_MINS, TimeUnit.MINUTES).build(key -> "");
   }

   /**
    * 
    * @param emailId
    */
   public void generateOTP(final String emailId, final OTPRequestTypeEnum requestType) {
      User user = this.userHandler.getUser(emailId);
      // checking if the user is already existing with active status
      if (user != null && OTPRequestTypeEnum.Registration.equals(requestType) && user.getStatus().equals(UserStatusTypeEnum.Active)) {
         throw new IllegalArgumentException(" User with emailId [" + emailId + "] already exists.");
      } else if (user == null && OTPRequestTypeEnum.PasswordReset.equals(requestType)) {
         throw new IllegalArgumentException(" User with emailId [" + emailId + "] does not exists.");
      } else {
         String userOtp = this.cache.get(emailId);
         if (StringUtils.isBlank(userOtp)) {
            String otp = RandomStringUtils.random(6, "0123456789");
            this.cache.put(emailId, otp);
            if (OTPRequestTypeEnum.PasswordReset.equals(requestType)) {
               JavaMailService.sendEmail(emailId, RESET_PASSWORD_OTP_MAILER_SUBJECT,
                        JavaMailContent.getSendPasswordResetOTPMailContent(user.getFirstName(), otp));
            } else {
               JavaMailService.sendEmail(emailId, REGISTRATION_OTP_MAILER_SUBJECT, JavaMailContent.getSendRegistrationOTPMailContent(otp));
            }
            System.out.println("OTP for emailId [" + emailId + "] is [" + otp + "]");
            LOG.info("OTP for emailId [" + emailId + "] is [" + otp + "]");
         } else {
            if (OTPRequestTypeEnum.PasswordReset.equals(requestType)) {
               JavaMailService.sendEmail(emailId, RESET_PASSWORD_OTP_MAILER_SUBJECT,
                        JavaMailContent.getSendPasswordResetOTPMailContent(user.getFirstName(), userOtp));
            } else {
               JavaMailService.sendEmail(emailId, REGISTRATION_OTP_MAILER_SUBJECT,
                        JavaMailContent.getSendRegistrationOTPMailContent(userOtp));
            }
            LOG.info("OTP for emailId [" + emailId + "] is [" + userOtp + "]");
         }
      }
   }

   /**
    * 
    * @param emailId
    * @param otp
    * @return
    */
   public boolean validateOTP(final String emailId, final String otp) {
      String userOtp = this.cache.get(emailId);
      boolean isvalidOtp = StringUtils.isBlank(userOtp) ? false : userOtp.equals(otp);
      if (isvalidOtp) {
         this.cache.invalidate(emailId);
      }
      return isvalidOtp;
   }
}
