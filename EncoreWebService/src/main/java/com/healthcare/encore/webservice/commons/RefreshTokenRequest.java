package com.healthcare.encore.webservice.commons;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {
   @NotBlank
   private String refreshToken;

   public String getRefreshToken() {
      return this.refreshToken;
   }

   public void setRefreshToken(final String refreshToken) {
      this.refreshToken = refreshToken;
   }
}
