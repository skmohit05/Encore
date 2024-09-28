package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumCommunicationChannelTypeDAO extends BaseDAO<EnumCommunicationChannelTypeDTO, Integer> {
   
   List<EnumCommunicationChannelTypeDTO> findAll(boolean applyActiveFilter);

   EnumCommunicationChannelTypeDTO findByName(String communicationChannelTypeName);
}
