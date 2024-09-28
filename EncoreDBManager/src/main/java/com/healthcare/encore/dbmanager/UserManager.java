/**
 *
 */
package com.healthcare.encore.dbmanager;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserDetails;

/**
 * 
 * @author ckumar
 *
 */
//@formatter:off
@Validated
public interface UserManager {

   /**
    * 
    * @param applyActiveFilter
    * @return
    */
   List<User> getAllUsers(boolean applyActiveFilter);

   /**
    * 
    * @return
    */
   User getUser();

   /**
    * 
    * @param userId
    * @return
    */
   User getUser(
            @NotNull(message = "userId cannot be null")
            @Valid
            Integer userId);

   /**
    * 
    * @param emailId
    * @return
    */
   User getUser(
            @NotBlank(message = "loginId cannot be blank or null")
            String emailId);

   /**
    * Updates the user to the database
    *
    * @param user user
    */
   void saveOrUpdateUser(
            @NotNull(message = "user cannot be null")
            @Valid
            User user);

   /**
    * 
    * @param userId
    * @param existingUserPasssword
    * @param newPassword
    */
   void changePassword(
            @NotNull(message = "userId cannot be null")
            @Valid
            Integer userId,
            @NotBlank(message = "existingUserPasssword cannot be blank or null")
            String existingUserPasssword,
            @NotBlank(message = "newPassword cannot be blank or null")
            String newPassword);

   /**
    * 
    * @param userId
    * @param email
    * @param otp
    * @param password
    */
   void resetPassword(
            @NotNull(message = "userId cannot be null")
            @Valid
            Integer userId,
            @NotBlank(message = "email cannot be blank or null")
            String email,
            @NotBlank(message = "password cannot be blank or null")
            String password);
   
   /**
    * 
    * @param emailId
    * @param otp
    * @return
    */
   User createVerifiedUser(
            @NotBlank(message = "emailId cannot be blank or null")
            String emailId,
            @NotBlank(message = "otp cannot be blank or null")
            String otp);
   
   /**
    * 
    * @param emailId
    * @param otp
    * @return
    */
   User getVerifiedUser(
            @NotBlank(message = "emailId cannot be blank or null")
            String emailId,
            @NotBlank(message = "otp cannot be blank or null")
            String otp);
   
   /**
    * 
    * @param userDetails
    * @return
    */
   User updateUser(
            @NotNull(message = "userDetails cannot be null")
            @Valid
            UserDetails userDetails);
   
   void updateUserLastSignIn(
            @NotNull(message = "userId cannot be null")
            @Valid
            Integer userId);
}
//@formatter:on
