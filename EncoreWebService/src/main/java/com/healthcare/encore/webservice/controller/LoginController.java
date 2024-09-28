package com.healthcare.encore.webservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.encore.dbmanager.MedicalEmployerManager;
import com.healthcare.encore.dbmanager.MedicalJobSeekerManager;
import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.MedicalEmployerExtendedInfo;
import com.healthcare.encore.model.MedicalJobSeekerExtendedInfo;
import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserTypeEnum;
import com.healthcare.encore.security.SecurityManager;
import com.healthcare.encore.security.UserAccount;
import com.healthcare.encore.webservice.commons.LoginResponse;
import com.healthcare.encore.webservice.commons.RefreshTokenRequest;
import com.healthcare.encore.webservice.jwt.JWTTokenHandler;

/**
 *
 * @author ckumar
 *
 */
@RestController
@RequestMapping(value = "api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
   /**
   *
   */
   @Autowired
   private SecurityManager securityManager;

   /**
    *
    */
   @Autowired
   private JWTTokenHandler jwtTokenHandler;

   @Autowired
   private UserManager userManager;

   @Autowired
   private MedicalJobSeekerManager jsManager;

   @Autowired
   private MedicalEmployerManager empManager;

   /**
    *
    * @return currently login in users UserAccount object
    */
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public LoginResponse authenticate() {
      UserAccount userAccount = this.securityManager.getAuthenticatedUser();
      return this.getLoginResponse(userAccount);
   }

   @RequestMapping(value = "/refreshtoken", method = RequestMethod.POST)
   public LoginResponse refresh(@Valid @RequestBody final RefreshTokenRequest request) {
      String requestRefreshToken = request.getRefreshToken();
      boolean active = this.jwtTokenHandler.isRefreshTokenActive(requestRefreshToken);
      if (!active) {
         throw new AccessDeniedException("Invalid token");
      }

      UserAccount userAccount = this.jwtTokenHandler.parseUserFromRefreshToken(requestRefreshToken);
      if (!userAccount.isEnabled()) {
         throw new AccessDeniedException("Invalid token");
      }

      return this.getLoginResponse(userAccount);
   }

   private LoginResponse getLoginResponse(final UserAccount userAccount) {
      String accessToken = this.jwtTokenHandler.createAccessTokenForUser(userAccount);
      String refreshToken = this.jwtTokenHandler.createRefreshTokenForUser(userAccount);

      Integer userId = userAccount.getId();
      this.userManager.updateUserLastSignIn(userId);
      User user = this.userManager.getUser(userId);
      if (UserTypeEnum.JobSeeker.equals(user.getUserType()) && this.jsManager.getMedicalJobSeekerExtendedInfo(userId) != null) {
         MedicalJobSeekerExtendedInfo jsInfo = this.jsManager.getMedicalJobSeekerExtendedInfo(userId);
         return new LoginResponse(accessToken, refreshToken, userId, user.getFirstName(), user.getUserType(), jsInfo.getTitle(),
            jsInfo.getSpecialityType(), jsInfo.getState());
      } else if (UserTypeEnum.Employer.equals(user.getUserType()) && this.empManager.getMedicalEmployerExtendedInfo(userId) != null) {
         MedicalEmployerExtendedInfo empInfo = this.empManager.getMedicalEmployerExtendedInfo(userId);
         return new LoginResponse(accessToken, refreshToken, userId, user.getFirstName(), user.getUserType(), null, null,
            empInfo.getState());
      } else {
         return new LoginResponse(accessToken, refreshToken, userId, user.getFirstName(), user.getUserType(), null, null, null);
      }
   }

   @RequestMapping(value = "/logout", method = RequestMethod.POST)
   public void logout(@Valid @RequestBody final RefreshTokenRequest request) {
      // Implementation to be updated when database is used
      // and refresh tokens needs to be invalidated
   }
}
