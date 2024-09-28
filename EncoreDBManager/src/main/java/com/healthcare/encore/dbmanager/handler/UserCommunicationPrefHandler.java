/**
 *
 */
package com.healthcare.encore.dbmanager.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.encore.db.dao.UserCommunicationPrefDAO;
import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;
import com.healthcare.encore.db.dto.UserCommunicationPrefDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.dbmanager.mapper.UserCommunicationPrefMapper;
import com.healthcare.encore.model.CommunicationChannelTypeEnum;
import com.healthcare.encore.model.UserCommunicationPref;

/**
 * 
 * @author mmeena
 *
 */
@Component
@Transactional
public class UserCommunicationPrefHandler {

   @Autowired
   private UserCommunicationPrefDAO userCommPrefDAO;
   
   @Autowired
   private UserCommunicationPrefMapper userCommPrefMapper;
   
   @Autowired
   private EnumMapperUtil enumMapperUtil;
   
   @Autowired
   private SetupMapperUtil setupMapperUtil;

   public Map<CommunicationChannelTypeEnum, UserCommunicationPref> getAllUserCommunicationPrefs(final int userId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(userId, true);
      List<UserCommunicationPrefDTO> userCommPrefDTOs = this.userCommPrefDAO.findAll(userDTO);      
      return this.userCommPrefMapper.getModels(userCommPrefDTOs);
   }

   public UserCommunicationPref getUserCommunicationPref(final int userId, final CommunicationChannelTypeEnum channelType) {
      UserCommunicationPrefDTO userCommPrefDTO = this.getCommPrefDTO(userId, channelType);    
      return userCommPrefDTO == null ? null : this.userCommPrefMapper.getModel(userCommPrefDTO);
   }

   public void saveOrUpdate(final int userId, final CommunicationChannelTypeEnum channelType, final UserCommunicationPref userCommPref) {
      UserCommunicationPrefDTO userCommPrefDTO = this.userCommPrefMapper.getDTO(userId, channelType, userCommPref);
      this.userCommPrefDAO.makePersistent(userCommPrefDTO);
   }
   
   private UserCommunicationPrefDTO getCommPrefDTO(final int userId, final CommunicationChannelTypeEnum channelType) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(userId, true);
      EnumCommunicationChannelTypeDTO channelTypeDTO = this.enumMapperUtil.getDTO(channelType);
      return this.userCommPrefDAO.findByChannelType(userDTO, channelTypeDTO);
   }
   
}
