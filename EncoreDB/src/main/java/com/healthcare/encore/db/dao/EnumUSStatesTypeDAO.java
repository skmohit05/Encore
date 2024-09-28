package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumUSStatesTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumUSStatesTypeDAO extends BaseDAO<EnumUSStatesTypeDTO, Integer> {
   
   List<EnumUSStatesTypeDTO> findAll(boolean applyActiveFilter);

   EnumUSStatesTypeDTO findByName(String usStatesTypeName);
}
