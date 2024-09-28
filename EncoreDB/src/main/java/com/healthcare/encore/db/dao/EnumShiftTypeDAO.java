package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumShiftTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumShiftTypeDAO extends BaseDAO<EnumShiftTypeDTO, Integer> {
   
   List<EnumShiftTypeDTO> findAll(boolean applyActiveFilter);

   EnumShiftTypeDTO findByName(String shiftTypeName);
}
