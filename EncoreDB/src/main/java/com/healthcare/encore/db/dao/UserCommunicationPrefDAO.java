package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;
import com.healthcare.encore.db.dto.UserCommunicationPrefDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface UserCommunicationPrefDAO extends BaseDAO<UserCommunicationPrefDTO, Integer> {

   List<UserCommunicationPrefDTO> findAll(UserDTO userDTO);
   
   UserCommunicationPrefDTO findByChannelType(UserDTO userDTO, EnumCommunicationChannelTypeDTO channelTypeDTO);
}
