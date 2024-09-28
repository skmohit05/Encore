package com.healthcare.encore.webservice.jwt;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.healthcare.encore.security.UserAccount;

/**
 * UserAccountAuthentication - set in SecurityContext when token
 * authentication passes
 * 
 * @author ckumar
 *
 */
public class UserAccountAuthentication implements Authentication {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
    * 
    */
   private final UserAccount userAccount;

   /**
    * 
    */
   private boolean authenticated = true;

   /**
    * 
    * @param userAccount
    */
   public UserAccountAuthentication(final UserAccount userAccount) {
      this.userAccount = userAccount;
   }

   /**
    * 
    */
   @Override
   public String getName() {
      return this.userAccount.getUsername();
   }

   /**
    * 
    */
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.userAccount.getAuthorities();
   }

   /**
    * 
    */
   @Override
   public Object getCredentials() {
      return null;
   }

   /**
    * 
    */
   @Override
   public Object getDetails() {
      return null;
   }

   /**
    * 
    */
   @Override
   public Object getPrincipal() {
      return this.userAccount;
   }

   /**
    * 
    */
   @Override
   public boolean isAuthenticated() {
      return this.authenticated && this.userAccount.isEnabled();
   }

   /**
    * 
    */
   @Override
   public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {
      this.authenticated = isAuthenticated;
   }
}
