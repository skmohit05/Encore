package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumUserTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumUserTypeDAO extends BaseDAO<EnumUserTypeDTO, Integer> {
   
   List<EnumUserTypeDTO> findAll(boolean applyActiveFilter);

   EnumUserTypeDTO findByName(String userTypeName);
}
