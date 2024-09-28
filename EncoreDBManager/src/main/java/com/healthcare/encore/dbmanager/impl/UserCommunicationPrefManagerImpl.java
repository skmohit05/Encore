/**
 *
 */
package com.healthcare.encore.dbmanager.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.encore.dbmanager.UserCommunicationPrefManager;
import com.healthcare.encore.dbmanager.handler.UserCommunicationPrefHandler;
import com.healthcare.encore.model.CommunicationChannelTypeEnum;
import com.healthcare.encore.model.UserCommunicationPref;

/**
 * 
 * @author mmeena
 *
 */
@Service
public class UserCommunicationPrefManagerImpl implements UserCommunicationPrefManager {

   @Autowired
   private UserCommunicationPrefHandler userCommPrefHandler;

   @Override
   public Map<CommunicationChannelTypeEnum, UserCommunicationPref> getAllUserCommunicationPrefs(final int userId) {
      return this.userCommPrefHandler.getAllUserCommunicationPrefs(userId);
   }

   @Override
   public void saveOrUpdateUserCommunicationPref(final int userId, final CommunicationChannelTypeEnum channelType,
            final UserCommunicationPref userCommPref) {
      this.userCommPrefHandler.saveOrUpdate(userId, channelType, userCommPref);
   }

   @Override
   public UserCommunicationPref getUserCommunicationPref(final int userId, final CommunicationChannelTypeEnum channelType) {
      return this.userCommPrefHandler.getUserCommunicationPref(userId, channelType);
   }
}
