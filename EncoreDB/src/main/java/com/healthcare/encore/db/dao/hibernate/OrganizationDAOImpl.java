package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.OrganizationDAO;
import com.healthcare.encore.db.dto.OrganizationDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class OrganizationDAOImpl extends BaseDAOImpl<OrganizationDTO, Integer> implements OrganizationDAO {

   /**
    *
    */
   public OrganizationDAOImpl() {
      super(OrganizationDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<OrganizationDTO> findAll(final boolean applyActiveFilter) {
      return super.list("OrganizationDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public OrganizationDTO findByName(final String name) {
      return super.findUnique("OrganizationDTO.findByName", new String[] { "name" }, name.toUpperCase());
   }

}
