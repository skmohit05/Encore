package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumUserStatusTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumUserStatusTypeDAO extends BaseDAO<EnumUserStatusTypeDTO, Integer> {
   
   List<EnumUserStatusTypeDTO> findAll(boolean applyActiveFilter);

   EnumUserStatusTypeDTO findByName(String userStatusTypeName);
}
