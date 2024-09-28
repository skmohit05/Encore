package com.healthcare.encore.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.healthcare.encore.dbmanager.OTPManager;
import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.OTPRequestTypeEnum;
import com.healthcare.encore.model.User;
import com.healthcare.encore.security.SecurityManager;
import com.healthcare.encore.security.UserAccount;
import com.healthcare.encore.webservice.commons.RegisteredUserResponse;
import com.healthcare.encore.webservice.commons.OtpRequest;
import com.healthcare.encore.webservice.commons.ValidateOtpRequest;
import com.healthcare.encore.webservice.jwt.JWTTokenHandler;

/**
 *
 * @author ckumar
 *
 */
@RestController
@RequestMapping(value = "api/mfa", produces = MediaType.APPLICATION_JSON_VALUE)
public class OTPController {

   /**
    *
    */
   @Autowired
   private OTPManager otpManager;

   /**
    * UserManager reference
    */
   @Autowired
   private UserManager userManager;

   /**
    *
    */
   @Autowired
   private JWTTokenHandler jwtTokenHandler;

   /**
    *
    */
   @Autowired
   private SecurityManager securityManager;

   /**
    *
    * @param emailId
    */
   @RequestMapping(value = "/otp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> generateOTP(@RequestBody final OtpRequest request) {
      if (request != null) {
         this.otpManager.generateOTP(request.getEmailId(), request.getRequestType());
         return new ResponseEntity<>(HttpStatus.OK);
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide emailId");
   }

   /**
    *
    * @param request
    * @return
    */
   @RequestMapping(value = "/otp/verify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   public RegisteredUserResponse validateUserOTP(@RequestBody final ValidateOtpRequest request) {
      if(OTPRequestTypeEnum.PasswordReset.equals(request.getRequestType())) {
         User user = this.userManager.getVerifiedUser(request.getEmailId(), request.getOtp());
         if (user != null) {
            return new RegisteredUserResponse(user.getUserId(), null);
         } else {
            throw new IllegalArgumentException(
                     "User verification failed for emailId [" + request.getEmailId() + "] and otp [" + request.getOtp() + "]");
         }
      } else {
         User user = this.userManager.createVerifiedUser(request.getEmailId(), request.getOtp());
         if (user != null) {
            this.securityManager.authenticateUser(request.getEmailId(), request.getOtp());
            UserAccount userAccount = this.securityManager.getAuthenticatedUser();
            String token = this.jwtTokenHandler.createAccessTokenForUser(userAccount);
            return new RegisteredUserResponse(user.getUserId(), token);
         } else {
            throw new IllegalArgumentException(
                     "User verification failed for emailId [" + request.getEmailId() + "] and otp [" + request.getOtp() + "]");
         }
      }
   }
}
