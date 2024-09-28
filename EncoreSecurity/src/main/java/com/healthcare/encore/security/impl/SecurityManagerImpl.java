/**
 *
 */
package com.healthcare.encore.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.healthcare.encore.security.SecurityManager;
import com.healthcare.encore.security.UserAccount;

/**
 * @author ckumar
 *
 */
@Service
public class SecurityManagerImpl implements SecurityManager {
   /**
    *
    */
   @Autowired
   private AuthenticationManager authenticationManager;

   /**
    *
    */
   @Autowired
   private UserAccountDetailService userDetailService;

   /**
    *
    */
   @Autowired
   private CustomPasswordEncoder encoder;

   /**
    *
    */
   public SecurityManagerImpl() {
      SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
   }

   /**
    *
    */
   @Override
   public void authenticateUser(final String loginId, final String password) {
      UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginId, password);
      Authentication auth = this.authenticationManager.authenticate(authRequest);
      SecurityContextHolder.getContext().setAuthentication(auth);
   }

   /**
    *
    */
   @Override
   public boolean validateUserCredentials(final String loginId, final String password) {
      UserDetails userDetails = this.userDetailService.loadUserByUsername(loginId);
      return this.encoder.matches(password, userDetails.getPassword());
   }

   /**
    *
    */
   @Override
   public UserAccount getAuthenticatedUser() {
      UserAccount authenticatedUser = null;
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication != null) {
         Object principal = authentication.getPrincipal();
         if (principal instanceof UserAccount) {
            authenticatedUser = (UserAccount) principal;
         }
      }
      return authenticatedUser;
   }

   /**
    *
    */
   @Override
   public Integer getAuditUserId() {
      UserAccount authenticatedUser = this.getAuthenticatedUser();
      return authenticatedUser == null ? null : authenticatedUser.getId();
   }

}
