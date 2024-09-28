package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumFacilityTypeDAO;
import com.healthcare.encore.db.dto.EnumFacilityTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumFacilityTypeDAOImpl extends BaseDAOImpl<EnumFacilityTypeDTO, Integer>
         implements EnumFacilityTypeDAO {
   /**
    *
    */
   public EnumFacilityTypeDAOImpl() {
      super(EnumFacilityTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumFacilityTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumFacilityTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumFacilityTypeDTO findByName(final String facilityTypeName) {
      return super.findUnique("EnumFacilityTypeDTO.findByName", new String[] { "name" }, facilityTypeName.toUpperCase());
   }
}
