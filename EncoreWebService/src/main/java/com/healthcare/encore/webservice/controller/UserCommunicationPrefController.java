/**
 *
 */
package com.healthcare.encore.webservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.encore.dbmanager.UserCommunicationPrefManager;
import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.CommunicationChannelTypeEnum;
import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserCommunicationPref;
import com.healthcare.encore.security.SecurityManager;
import com.healthcare.encore.webservice.exception.ResourceNotFoundException;

/**
 * 
 * @author mmeena
 *
 */
@RestController
@RequestMapping(value = "api/users/{userId}/communications", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserCommunicationPrefController {

   @Autowired
   private UserCommunicationPrefManager userCommPrefManager;
   
   @Autowired
   private SecurityManager securityManager;
   
   @Autowired
   private UserManager userManager;

   /**
    * Fetches all available user communication preferences for the user id passed
    *
    * @param userId
    * @return map of user communication channel types and preferences
    */
   @RequestMapping(method = RequestMethod.GET)
   public Map<CommunicationChannelTypeEnum, UserCommunicationPref> getAllUserCommunicationPrefs(
            @PathVariable final Integer userId) {
      this.checkAccess(userId);
      return this.userCommPrefManager.getAllUserCommunicationPrefs(userId);
   }

   /**
    * Fetches user communication preference for specific user and channel type passed
    *
    * @param userId
    * @param channelType
    * @return user communication preference
    */
   @RequestMapping(value = "{channelType}", method = RequestMethod.GET)
   public UserCommunicationPref getUserCommunicationPref(@PathVariable final Integer userId,
            @PathVariable final CommunicationChannelTypeEnum channelType) {
      this.checkAccess(userId);
      UserCommunicationPref userCommPref = this.userCommPrefManager.getUserCommunicationPref(userId, channelType);
      if (userCommPref == null) {
         throw new ResourceNotFoundException(
                  "User Communication Preference not found [userId=" + userId + ", channelType" + channelType + "]");
      }
      return userCommPref;
   }

   /**
    * Save or Update user communication preferences passed
    * @param userId
    * @param userCommPrefs
    * @return Updated user communication preference entities
    */
   @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateUserCommunicationPrefs(@PathVariable final Integer userId,
            @RequestBody final Map<CommunicationChannelTypeEnum, UserCommunicationPref> userCommPrefs) {
      this.checkAccess(userId);
      for (Map.Entry<CommunicationChannelTypeEnum, UserCommunicationPref> pref : userCommPrefs.entrySet()) {
         this.userCommPrefManager.saveOrUpdateUserCommunicationPref(userId, pref.getKey(), pref.getValue());
      }
      return new ResponseEntity<Object>(userCommPrefs, HttpStatus.OK);
   }

   /**
    * Save or Update user communication preference for specific user and channel type passed
    * @param userId
    * @param channelType
    * @param user
    * @return Updated user communication preference entity
    */
   @RequestMapping(value = "{channelType}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateUserCommunicationPref(@PathVariable final Integer userId,
            @PathVariable final CommunicationChannelTypeEnum channelType, @RequestBody final UserCommunicationPref userCommPref) {
      this.checkAccess(userId);
      this.userCommPrefManager.saveOrUpdateUserCommunicationPref(userId, channelType, userCommPref);
      return new ResponseEntity<Object>(userCommPref, HttpStatus.OK);
   }

   private void checkAccess(final Integer userId) {
      Integer loggedInUserId = this.securityManager.getAuditUserId();
      User user = this.userManager.getUser(loggedInUserId);
      if (userId != null && !loggedInUserId.equals(userId)) {
         throw new AccessDeniedException("User " + user.getFirstName() + " does not have permission to access this resource.");
      }
   }

}
