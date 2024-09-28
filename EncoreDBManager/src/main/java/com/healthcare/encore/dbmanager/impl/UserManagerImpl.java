/**
 *
 */
package com.healthcare.encore.dbmanager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.dbmanager.handler.UserHandler;
import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserDetails;
import com.healthcare.encore.security.SecurityManager;

/**
 * 
 * @author ckumar
 *
 */
@Service
public class UserManagerImpl implements UserManager {

   /**
    *
    */
   @Autowired
   private UserHandler userHandler;

   /**
    * SecurityManager reference
    */
   @Autowired
   private SecurityManager securityManager;

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public List<User> getAllUsers(final boolean applyActiveFilter) {
      return this.userHandler.getAllUsers(applyActiveFilter);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public User getUser() {
      String emailId = this.securityManager.getAuthenticatedUser().getEmailId();
      return this.userHandler.getUser(emailId);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public User getUser(final Integer userId) {
      return this.userHandler.getUser(userId);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public User getUser(final String emailId) {
      return this.userHandler.getUser(emailId);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public void saveOrUpdateUser(final User user) {
      this.userHandler.saveOrUpdate(user);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void changePassword(final Integer userId, final String existingUserPassword, final String newUserPassword) {
      this.userHandler.changePassword(userId, existingUserPassword, newUserPassword);
   }
   
   /**
    * 
    */
   @Override
   public User createVerifiedUser(final String emailId, final String otp) {
      return this.userHandler.createVerifiedUser(emailId, otp);
   }
   
   /**
    * 
    */
   @Override
   public User getVerifiedUser(final String emailId, final String otp) {
      return this.userHandler.getVerifiedUser(emailId, otp);
   }
   
   /**
    * 
    */
   @Override
   public User updateUser(final UserDetails userDetails) {
      return this.userHandler.updateUser(userDetails);
   }

   @Override
   public void updateUserLastSignIn(final Integer userId) {
      this.userHandler.updateUserLastSignIn(userId);
   }

   @Override
   public void resetPassword(final Integer userId, final String email, final String password) {
      this.userHandler.resetPassword(userId, email, password);
   }
}
