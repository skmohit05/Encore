package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.UserCommunicationPrefDAO;
import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;
import com.healthcare.encore.db.dto.UserCommunicationPrefDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class UserCommunicationPrefDAOImpl extends BaseDAOImpl<UserCommunicationPrefDTO, Integer> implements UserCommunicationPrefDAO {

   /**
    *
    */
   public UserCommunicationPrefDAOImpl() {
      super(UserCommunicationPrefDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<UserCommunicationPrefDTO> findAll(final UserDTO userDTO) {
      return super.list("UserCommunicationPrefDTO.findAll", new String[] { "userId" }, userDTO.getId());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public UserCommunicationPrefDTO findByChannelType(final UserDTO userDTO, final EnumCommunicationChannelTypeDTO channelTypeDTO) {
      return super.findUnique("UserCommunicationPrefDTO.findByChannelType", new String[] { "userId", "channelTypeId" }, userDTO.getId(),
               channelTypeDTO.getId());
   }
   
}
