package com.healthcare.encore.model;

/**
 * 
 * @author ckumar
 *
 */
public class UserDetails extends User{
   
   /**
    * 
    */
   private String password;
   
   /**
    * 
    * @return
    */
   public String getPassword() {
      return this.password;
   }
   
   /**
    * 
    * @param password
    */
   public void setPassword(final String password) {
      this.password = password;
   }

}
