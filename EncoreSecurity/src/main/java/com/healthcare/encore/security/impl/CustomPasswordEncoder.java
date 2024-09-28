package com.healthcare.encore.security.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Implements PasswordEncoder using bcrypt, if empty or null return empty or null, else bcrypt
 *
 * @author ckumar
 *
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {
   /**
    *
    */
   @Autowired
   private BCryptPasswordEncoder bcryptPasswordEncoder;

   /**
    *
    */
   @Override
   public String encode(final CharSequence rawPassword) {
      return StringUtils.isBlank(rawPassword) ? StringUtils.EMPTY : this.bcryptPasswordEncoder.encode(rawPassword);
   }

   /**
    *
    */
   @Override
   public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
      if (StringUtils.isBlank(encodedPassword) && StringUtils.isBlank(rawPassword)) {
         return true;
      }
      if (StringUtils.isBlank(encodedPassword) || StringUtils.isBlank(rawPassword)) {
         return false;
      }
      return this.bcryptPasswordEncoder.matches(rawPassword, encodedPassword);
   }
}
