package com.healthcare.encore.webservice.commons;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author ckumar
 *
 */
public class ChangePasswordRequest {

   /**
    *
    */
   @NotNull(message = "existingPassword cannot be null")
   private final String existingPassword;

   /**
    *
    */
   @NotNull(message = "newPassword cannot be null")
   private final String newPassword;

   /**
    * 
    * @param loginId
    * @param existingPassword
    * @param newPassword
    */
   @JsonCreator
   public ChangePasswordRequest(
            @JsonProperty("existingPassword") final String existingPassword,
            @JsonProperty("newPassword") final String newPassword) {
      this.existingPassword = existingPassword;
      this.newPassword = newPassword;
   }

   /**
    *
    * @return existingPassword
    */
   public String getExistingPassword() {
      return this.existingPassword;
   }

   /**
    *
    * @return newPassword
    */
   public String getNewPassword() {
      return this.newPassword;
   }
}
