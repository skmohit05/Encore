package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumFacilitySubTypeDAO;
import com.healthcare.encore.db.dto.EnumFacilitySubTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumFacilitySubTypeDAOImpl extends BaseDAOImpl<EnumFacilitySubTypeDTO, Integer>
         implements EnumFacilitySubTypeDAO {
   /**
    *
    */
   public EnumFacilitySubTypeDAOImpl() {
      super(EnumFacilitySubTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumFacilitySubTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumFacilitySubTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumFacilitySubTypeDTO findByName(final String facilitySubTypeName) {
      return super.findUnique("EnumFacilitySubTypeDTO.findByName", new String[] { "name" }, facilitySubTypeName.toUpperCase());
   }
}
