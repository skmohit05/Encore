/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.UserCommunicationPrefDAO;
import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;
import com.healthcare.encore.db.dto.UserCommunicationPrefDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.CommunicationChannelTypeEnum;
import com.healthcare.encore.model.UserCommunicationPref;

/**
 * @author mmeena
 *
 */
@Component
public class UserCommunicationPrefMapper extends AbstractMapper<UserCommunicationPrefDTO, UserCommunicationPref> {

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private UserCommunicationPrefDAO userCommPrefDAO;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   /**
    * {@inheritDoc}
    */
   @Override
   public UserCommunicationPref getModel(final UserCommunicationPrefDTO userCommPrefDTO) {
      UserCommunicationPref userCommPref = new UserCommunicationPref();
      userCommPref.setCandidateSubscription(userCommPrefDTO.isCandidateSubscription());
      userCommPref.setJobSubscription(userCommPrefDTO.isJobSubscription());
      userCommPref.setMarketingSubscription(userCommPrefDTO.isMarketingSubscription());
      userCommPref.setSiteFeatureSubscription(userCommPrefDTO.isSiteFeatureSubscription());
      return userCommPref;
   }

   public UserCommunicationPrefDTO getDTO(final int userId, final CommunicationChannelTypeEnum channelType,
            final UserCommunicationPref userCommPref) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(userId, true);
      EnumCommunicationChannelTypeDTO channelTypeDTO = this.enumMapperUtil.getDTO(channelType);
      UserCommunicationPrefDTO userCommuPrefDTO = new UserCommunicationPrefDTO();
      userCommuPrefDTO.setId(this.getId(userDTO, channelTypeDTO));
      userCommuPrefDTO.setUserDTO(userDTO);
      userCommuPrefDTO.setCommunicationChannelTypeDTO(channelTypeDTO);
      userCommuPrefDTO.setCandidateSubscription(userCommPref.isCandidateSubscription());
      userCommuPrefDTO.setJobSubscription(userCommPref.isJobSubscription());
      userCommuPrefDTO.setMarketingSubscription(userCommPref.isMarketingSubscription());
      userCommuPrefDTO.setSiteFeatureSubscription(userCommPref.isSiteFeatureSubscription());
      userCommuPrefDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      return userCommuPrefDTO;
   }

   public Map<CommunicationChannelTypeEnum, UserCommunicationPref> getModels(
            final List<UserCommunicationPrefDTO> userCommPrefDTOs) {
      Map<CommunicationChannelTypeEnum, UserCommunicationPref> prefs = new HashMap<>();
      for (UserCommunicationPrefDTO dto : userCommPrefDTOs) {
         UserCommunicationPref pref = this.getModel(dto);
         CommunicationChannelTypeEnum channelType = this.enumMapperUtil.getModel(dto.getCommunicationChannelTypeDTO());
         if (channelType != null && pref != null) {
            prefs.put(channelType, pref);
         }
      }

      return prefs;
   }

   private Integer getId(final UserDTO userDTO, final EnumCommunicationChannelTypeDTO channelTypeDTO) {
      UserCommunicationPrefDTO userCommPrefDTO = this.userCommPrefDAO.findByChannelType(userDTO, channelTypeDTO);
      return userCommPrefDTO == null ? null : userCommPrefDTO.getId();
   }
}
