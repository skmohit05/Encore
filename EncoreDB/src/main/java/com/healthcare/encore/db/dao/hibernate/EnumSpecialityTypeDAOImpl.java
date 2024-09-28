package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumSpecialityTypeDAO;
import com.healthcare.encore.db.dto.EnumSpecialityTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumSpecialityTypeDAOImpl extends BaseDAOImpl<EnumSpecialityTypeDTO, Integer>
         implements EnumSpecialityTypeDAO {
   /**
    *
    */
   public EnumSpecialityTypeDAOImpl() {
      super(EnumSpecialityTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumSpecialityTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumSpecialityTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumSpecialityTypeDTO findByName(final String specialityTypeName) {
      return super.findUnique("EnumSpecialityTypeDTO.findByName", new String[] { "name" }, specialityTypeName.toUpperCase());
   }
}
