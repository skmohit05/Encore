package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumFacilitySubTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumFacilitySubTypeDAO extends BaseDAO<EnumFacilitySubTypeDTO, Integer> {
   
   List<EnumFacilitySubTypeDTO> findAll(boolean applyActiveFilter);

   EnumFacilitySubTypeDTO findByName(String facilitySubTypeName);
}
