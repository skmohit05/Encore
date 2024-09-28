package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum OTPRequestTypeEnum {

   Registration("Registration", "Registration"),
   PasswordReset("PasswordReset", "Password Reset");

   private final String name;

   private final String desc;

   private OTPRequestTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static OTPRequestTypeEnum fromName(final String name) {
      for (OTPRequestTypeEnum value : OTPRequestTypeEnum.values()) {
         if (value.name.equalsIgnoreCase(name)) {
            return value;
         }
      }
      return null;
   }

   public String getName() {
      return this.name();
   }

   public String getDesc() {
      return this.desc;
   }
}
