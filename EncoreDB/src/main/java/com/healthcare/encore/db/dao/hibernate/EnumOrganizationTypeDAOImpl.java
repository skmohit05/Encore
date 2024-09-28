package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumOrganizationTypeDAO;
import com.healthcare.encore.db.dto.EnumOrganizationTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumOrganizationTypeDAOImpl extends BaseDAOImpl<EnumOrganizationTypeDTO, Integer>
         implements EnumOrganizationTypeDAO {
   /**
    *
    */
   public EnumOrganizationTypeDAOImpl() {
      super(EnumOrganizationTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumOrganizationTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumOrganizationTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumOrganizationTypeDTO findByName(final String organizationTypeName) {
      return super.findUnique("EnumOrganizationTypeDTO.findByName", new String[] { "name" }, organizationTypeName.toUpperCase());
   }
}
