package com.healthcare.encore.webservice.commons;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author ckumar
 *
 */
public class ResetPasswordRequest {
   /**
    * 
    */
   @NotNull(message = "userId cannot be null")
   private final Integer userId;

   /**
    *
    */
   @NotNull(message = "email cannot be null")
   private final String email;

   /**
    *
    */
   @NotNull(message = "password cannot be null")
   private final String password;

   /**
    * 
    * @param email
    * @param otp
    * @param password
    */
   @JsonCreator
   public ResetPasswordRequest(
            @JsonProperty("userId") final Integer userId,
            @JsonProperty("email") final String email,
            @JsonProperty("password") final String password) {
      this.userId = userId;
      this.email = email;
      this.password = password;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPassword() {
      return this.password;
   }

   public Integer getUserId() {
      return this.userId;
   }
}
