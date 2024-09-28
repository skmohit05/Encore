/**
 *
 */
package com.healthcare.encore.dbmanager;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.healthcare.encore.model.CommunicationChannelTypeEnum;
import com.healthcare.encore.model.UserCommunicationPref;

/**
 * 
 * @author mmeena
 *
 */
//@formatter:off
@Validated
public interface UserCommunicationPrefManager {

   Map<CommunicationChannelTypeEnum, UserCommunicationPref> getAllUserCommunicationPrefs(
            int userId);

   UserCommunicationPref getUserCommunicationPref(
            int userId, 
            @NotNull(message="channelType cannot be null")
            @Valid
            CommunicationChannelTypeEnum channelType);
   
   void saveOrUpdateUserCommunicationPref(
            int userId,
            @NotNull(message="channelType cannot be null")
            @Valid
            CommunicationChannelTypeEnum channelType,
            @NotNull(message="userCommPref cannot be null")
            @Valid
            UserCommunicationPref userCommPref);
}
//@formatter:on
