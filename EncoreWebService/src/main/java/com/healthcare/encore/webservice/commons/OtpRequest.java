package com.healthcare.encore.webservice.commons;

import com.healthcare.encore.model.OTPRequestTypeEnum;

/**
 * 
 * @author ckumar
 *
 */
public class OtpRequest {
   
   /**
    * 
    */
   private String emailId;
   
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
   
   public OTPRequestTypeEnum getRequestType() {
      return this.requestType;
   }

   public void setRequestType(final OTPRequestTypeEnum requestType) {
      this.requestType = requestType;
   }

}
