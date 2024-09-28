package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumSpecialityTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumSpecialityTypeDAO extends BaseDAO<EnumSpecialityTypeDTO, Integer> {
   
   List<EnumSpecialityTypeDTO> findAll(boolean applyActiveFilter);

   EnumSpecialityTypeDTO findByName(String specialityTypeName);
}
