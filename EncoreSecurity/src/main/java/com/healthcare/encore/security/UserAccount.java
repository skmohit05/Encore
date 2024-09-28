/**
 *
 */
package com.healthcare.encore.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Extends the Spring UserDetails objects to provide database
 * user id and database login id information
 *
 * @author ckumar
 *
 */
public interface UserAccount extends UserDetails {

   /**
    *
    * @return id of the authenticated user
    */
   Integer getId();

   /**
    * @return loginId of the authenticated in user
    *
    */
   String getEmailId();

   /**
    * 
    * @return
    */
   String getFirstName();

   /**
    * 
    * @return
    */
   String getLastName();

}
