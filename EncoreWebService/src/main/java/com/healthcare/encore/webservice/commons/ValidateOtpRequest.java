package com.healthcare.encore.webservice.commons;

import com.healthcare.encore.model.OTPRequestTypeEnum;

/**
 * 
 * @author ckumar
 *
 */
public class ValidateOtpRequest {

   /**
    * 
    */
   private String emailId;

   /**
    * 
    */
   private String otp;
   
   private OTPRequestTypeEnum requestType;

   /**
    * 
    * @return
    */
   public String getEmailId() {
      return this.emailId;
   }

   /**
    * 
    * @param emailId
    */
   public void setEmailId(final String emailId) {
      this.emailId = emailId;
   }

   /**
    * 
    * @return
    */
   public String getOtp() {
      return this.otp;
   }

   /**
    * 
    * @param otp
    */
   public void setOtp(final String otp) {
      this.otp = otp;
   }
   
   public OTPRequestTypeEnum getRequestType() {
      return this.requestType;
   }

   public void setRequestType(final OTPRequestTypeEnum requestType) {
      this.requestType = requestType;
   }
}
