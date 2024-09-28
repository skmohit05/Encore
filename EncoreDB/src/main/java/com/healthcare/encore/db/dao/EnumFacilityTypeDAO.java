package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumFacilityTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumFacilityTypeDAO extends BaseDAO<EnumFacilityTypeDTO, Integer> {
   
   List<EnumFacilityTypeDTO> findAll(boolean applyActiveFilter);

   EnumFacilityTypeDTO findByName(String facilityTypeName);
}
