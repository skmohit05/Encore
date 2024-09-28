/**
 *
 */
package com.healthcare.encore.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.UserStatusTypeEnum;
import com.healthcare.encore.security.SecurityManager;
import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserDetails;
import com.healthcare.encore.webservice.commons.ChangePasswordRequest;
import com.healthcare.encore.webservice.commons.ResetPasswordRequest;
import com.healthcare.encore.webservice.exception.ResourceNotFoundException;

/**
 * 
 * @author ckumar
 *
 */
@RestController
@RequestMapping(value = "api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

   /**
    * UserManager reference
    */
   @Autowired
   private UserManager userManager;
   
   @Autowired
   private SecurityManager securityManager;

   /**
    * Fetches all available users from DBManager
    *
    * @return list of users
    */
   @RequestMapping(method = RequestMethod.GET)
   public List<User> getAllUsers(
            @RequestParam(value = "applyactivefilter", defaultValue = "false") final boolean applyActiveFilter) {
      return this.userManager.getAllUsers(applyActiveFilter);
   }

   /**
    * 
    * @param userId
    * @return
    */
   @RequestMapping(value = "{userId}", method = RequestMethod.GET)
   public User getUser(@PathVariable final Integer userId) {
      this.checkAccess(userId);
      User user = this.userManager.getUser(userId);
      if (user == null) {
         throw new ResourceNotFoundException("No user found for given userId [" + userId + "]");
      }
      return user;
   }

   /**
    * Save or Update users passed to the database
    * 
    * @param users
    * @return Updated User entity
    */
   @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   public List<User> saveOrUpdateUser(@RequestBody final List<User> users) {
      List<User> usersList = new ArrayList<>();
      for (User user : users) {
         this.userManager.saveOrUpdateUser(user);
      }
      for (User user : users) {
         user.setPassword(null);
         usersList.add(user);
      }
      return usersList;
   }

   /**
    * 
    * @param userId
    * @param user
    * @return
    */
   @RequestMapping(value = "{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
   public User updateUser(@PathVariable final Integer userId, @RequestBody final User user) {
      this.checkAccess(userId);
      if (user.getUserId() != null && !user.getUserId().equals(userId)) {
         throw new IllegalArgumentException("User Id " + userId + "  is different from request body");
      }
      User existingUser = this.userManager.getUser(userId);
      if (existingUser != null) {
         this.userManager.saveOrUpdateUser(user);
      } else {
         throw new IllegalArgumentException("User does not exist for provided userId [" + userId + "]");
      }
      return this.userManager.getUser(userId);
   }
   
   /**
    * 
    * @param userDetails
    * @return
    */
   @RequestMapping(value = "{userId}/register", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
   public User registerUser(@PathVariable final Integer userId, @RequestBody final UserDetails userDetails) {
      this.checkAccess(userId);
      User updatedUser = null;
      User existingUser = this.userManager.getUser(userId);
      if (existingUser != null && existingUser.getStatus() == UserStatusTypeEnum.Verified) {
         updatedUser = this.userManager.updateUser(userDetails);
      } else {
         throw new IllegalArgumentException("User does not exist for given emailId [" + userDetails.getEmail() + "]");
      }
      return updatedUser;
   }

   /**
    *
    * @param request
    */
   //@formatter:off
   @RequestMapping(value = "/{userId}/changepassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   //@formatter:on
   public void changeUserPassword(@PathVariable final Integer userId, @RequestBody final ChangePasswordRequest request) {
      this.checkAccess(userId);
      this.userManager.changePassword(userId, request.getExistingPassword(), request.getNewPassword());
   }

   /**
    *
    * @param request
    */
   //@formatter:off
   @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   //@formatter:on
   public void resetUserPassword(@RequestBody final ResetPasswordRequest request) {
      this.userManager.resetPassword(request.getUserId(), request.getEmail(), request.getPassword());
   }

   private void checkAccess(final Integer userId) {
      Integer loggedInUserId = this.securityManager.getAuditUserId();
      User user = this.userManager.getUser(loggedInUserId);
      if (userId != null && !loggedInUserId.equals(userId)) {
         throw new AccessDeniedException("User " + user.getFirstName() + " does not have permission to access this resource.");
      }
   }
}
