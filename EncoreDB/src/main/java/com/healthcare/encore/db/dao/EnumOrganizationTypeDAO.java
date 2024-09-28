package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumOrganizationTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumOrganizationTypeDAO extends BaseDAO<EnumOrganizationTypeDTO, Integer> {
   
   List<EnumOrganizationTypeDTO> findAll(boolean applyActiveFilter);

   EnumOrganizationTypeDTO findByName(String organizationTypeName);
}
