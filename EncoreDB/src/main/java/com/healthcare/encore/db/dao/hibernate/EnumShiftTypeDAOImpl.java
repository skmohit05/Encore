package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumShiftTypeDAO;
import com.healthcare.encore.db.dto.EnumShiftTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumShiftTypeDAOImpl extends BaseDAOImpl<EnumShiftTypeDTO, Integer>
         implements EnumShiftTypeDAO {
   /**
    *
    */
   public EnumShiftTypeDAOImpl() {
      super(EnumShiftTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumShiftTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumShiftTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumShiftTypeDTO findByName(final String shiftTypeName) {
      return super.findUnique("EnumShiftTypeDTO.findByName", new String[] { "name" }, shiftTypeName.toUpperCase());
   }
}
