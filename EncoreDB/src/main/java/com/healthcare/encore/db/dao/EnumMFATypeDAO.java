package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumMFATypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumMFATypeDAO extends BaseDAO<EnumMFATypeDTO, Integer> {
   
   List<EnumMFATypeDTO> findAll(boolean applyActiveFilter);

   EnumMFATypeDTO findByName(String mfaTypeName);
}
