package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumCommunicationChannelTypeDAO;
import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumCommunicationChannelTypeDAOImpl extends BaseDAOImpl<EnumCommunicationChannelTypeDTO, Integer>
         implements EnumCommunicationChannelTypeDAO {
   /**
    *
    */
   public EnumCommunicationChannelTypeDAOImpl() {
      super(EnumCommunicationChannelTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumCommunicationChannelTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumCommunicationChannelTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumCommunicationChannelTypeDTO findByName(final String communicationChannelTypeName) {
      return super.findUnique("EnumCommunicationChannelTypeDTO.findByName", new String[] { "name" },
               communicationChannelTypeName.toUpperCase());
   }
}
