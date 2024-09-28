package com.healthcare.encore.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Implements Spring AuthenticationProvider
 *
 * @author ckumar
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

   /**
   *
   */
   @Autowired
   private DaoAuthenticationProvider daoAuthProvider;

   /**
   *
   */
   @Override
   public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
      Authentication auth = null;
      AuthenticationException dbAuthenticationException = null;
      String password = authentication.getCredentials().toString();
      Authentication dbAuthentication = new UsernamePasswordAuthenticationToken(authentication.getName(), password);
      try {
         auth = this.daoAuthProvider.authenticate(dbAuthentication);
      } catch (AuthenticationException e) {
         dbAuthenticationException = e;
      }
      if (dbAuthenticationException != null) {
         throw dbAuthenticationException;
      }
      return auth;
   }

   /**
   *
   */
   @Override
   public boolean supports(final Class<?> authentication) {
      return authentication.equals(UsernamePasswordAuthenticationToken.class);
   }
}
