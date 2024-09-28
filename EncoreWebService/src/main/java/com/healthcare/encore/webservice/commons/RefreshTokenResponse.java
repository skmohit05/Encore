package com.healthcare.encore.webservice.commons;

public class RefreshTokenResponse {
   private String accessToken;
   private String refreshToken;

   public RefreshTokenResponse(final String accessToken, final String refreshToken) {
      this.accessToken = accessToken;
      this.refreshToken = refreshToken;
   }

   public String getAccessToken() {
      return this.accessToken;
   }

   public void setAccessToken(final String accessToken) {
      this.accessToken = accessToken;
   }

   public String getRefreshToken() {
      return this.refreshToken;
   }

   public void setRefreshToken(final String refreshToken) {
      this.refreshToken = refreshToken;
   }
}
