/**
 *
 */
package com.healthcare.encore.security.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.healthcare.encore.security.UserAccount;

/**
 * @author ckumar
 *
 */
public final class UserAccountImpl implements UserAccount {

   /**
   *
   */
   private static final long serialVersionUID = 1L;

   /**
   *
   */
   private final Integer id;

   /**
   *
   */
   private final String emailId;

   /**
   *
   */
   private final String password;

   /**
   *
   */
   private final String firstName;

   /**
   *
   */
   private final String lastName;

   /**
   *
   */
   private final boolean enabled;

   /**
   *
   */
   private final List<GrantedAuthority> grantedAuthorities;

   public UserAccountImpl(final Integer id, final String emailId, final String password, final String firstName,
            final String lastName, final boolean enabled, final List<GrantedAuthority> grantedAuthorities) {
      this.id = id;
      this.emailId = emailId;
      this.password = password;
      this.firstName = firstName;
      this.lastName = lastName;
      this.enabled = enabled;
      this.grantedAuthorities = grantedAuthorities;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.grantedAuthorities;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getPassword() {
      return this.password;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getUsername() {
      return this.firstName + " " + this.lastName;
   }

   /**
    *
    * @return
    */
   @Override
   public String getFirstName() {
      return this.firstName;
   }

   /**
    *
    * @return
    */
   @Override
   public String getLastName() {
      return this.lastName;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean isEnabled() {
      return this.enabled;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Integer getId() {
      return this.id;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getEmailId() {
      return this.emailId;
   }
}
