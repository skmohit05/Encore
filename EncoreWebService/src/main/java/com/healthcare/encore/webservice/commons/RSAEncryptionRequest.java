package com.healthcare.encore.webservice.commons;

/**
 * 
 * @author ckumar
 *
 */
public class RSAEncryptionRequest {
   
   /**
    * 
    */
   private String plainText;
   
   /**
    * 
    * @return
    */
   public String getPlainText() {
      return this.plainText;
   }
   
   /**
    * 
    * @param plainText
    */
   public void setPlainText(final String plainText) {
      this.plainText = plainText;
   }
}
