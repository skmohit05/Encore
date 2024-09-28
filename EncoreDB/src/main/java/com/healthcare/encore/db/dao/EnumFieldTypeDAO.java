package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumFieldTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumFieldTypeDAO extends BaseDAO<EnumFieldTypeDTO, Integer> {
   
   List<EnumFieldTypeDTO> findAll(boolean applyActiveFilter);

   EnumFieldTypeDTO findByName(String fieldTypeName);
}
