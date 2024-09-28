package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumCompensationTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumCompensationTypeDAO extends BaseDAO<EnumCompensationTypeDTO, Integer> {
   
   List<EnumCompensationTypeDTO> findAll(boolean applyActiveFilter);

   EnumCompensationTypeDTO findByName(String compensationTypeName);
}
