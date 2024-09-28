package com.healthcare.encore.webservice.commons;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author ckumar
 *
 */
public class RegisteredUserResponse {
   
   /**
    * 
    */
   private final Integer userId;
   
   /**
    * 
    */
   private final String token;
   
   /**
    * 
    * @param userId
    * @param token
    */
   @JsonCreator
   public RegisteredUserResponse(final Integer userId, final String token) {
      this.userId = userId;
      this.token = token;
   }
   
   /**
    * 
    * @return
    */
   public Integer getUserId() {
      return this.userId;
   }
   

   public String getToken() {
      return this.token;
   }

}
