package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.OrganizationDTO;

/**
 *
 * @author mmeena
 *
 */
public interface OrganizationDAO extends BaseDAO<OrganizationDTO, Integer> {

   List<OrganizationDTO> findAll(boolean applyActiveFilter);
   
   OrganizationDTO findByName(String name);
}
