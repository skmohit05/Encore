package com.healthcare.encore.webservice.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.healthcare.encore.model.SpecialityTypeEnum;
import com.healthcare.encore.model.UserTypeEnum;

/**
 *
 * @author ckumar
 *
 */
public class LoginResponse {
   /**
    *
    */
   private final String accessToken;

   /**
    *
    */
   private final String refreshToken;

   /**
    *
    */
   private final Integer userId;

   /**
    *
    */
   private final String userName;

   /**
    *
    */
   private final UserTypeEnum userType;

   /**
    *
    */
   private final String title;

   /**
    *
    */
   private final SpecialityTypeEnum specialityType;

   /**
    *
    */
   private final String state;

   /**
    *
    * @param token
    */
   @JsonCreator
   public LoginResponse(
            @JsonProperty("accessToken")final String accessToken,
            @JsonProperty("refreshToken")final String refreshToken,
            @JsonProperty("userId") final Integer userId,
            @JsonProperty("userName") final String userName,
            @JsonProperty("userType") final UserTypeEnum userType,
            @JsonProperty("title") final String title,
            @JsonProperty("specialityType") final SpecialityTypeEnum specialityType,
            @JsonProperty("state") final String state) {
      this.accessToken = accessToken;
      this.refreshToken = refreshToken;
      this.userId = userId;
      this.userName = userName;
      this.userType = userType;
      this.title = title;
      this.specialityType = specialityType;
      this.state = state;
   }

   /**
    *
    * @return accessToken
    */
   public String getAccessToken() {
      return this.accessToken;
   }

   /**
   *
   * @return accessToken
   */
   public String getRefreshToken() {
      return this.refreshToken;
   }

   /**
    *
    * @return userId
    */
   public Integer getUserId() {
      return this.userId;
   }

   /**
    *
    * @return userType
    */
   public UserTypeEnum getUserType() {
      return this.userType;
   }

   /**
    *
    * @return title
    */
   public String getTitle() {
      return this.title;
   }

   /**
    *
    * @return specialityType
    */
   public SpecialityTypeEnum getSpecialityType() {
      return this.specialityType;
   }

   /**
    *
    * @return state
    */
   public String getState() {
      return this.state;
   }

   public String getUserName() {
      return this.userName;
   }
}
