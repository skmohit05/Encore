package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumJobTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumJobTypeDAO extends BaseDAO<EnumJobTypeDTO, Integer> {
   
   List<EnumJobTypeDTO> findAll(boolean applyActiveFilter);

   EnumJobTypeDTO findByName(String jobTypeName);
}
