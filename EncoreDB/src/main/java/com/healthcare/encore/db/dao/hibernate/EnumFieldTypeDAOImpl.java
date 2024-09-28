package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumFieldTypeDAO;
import com.healthcare.encore.db.dto.EnumFieldTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumFieldTypeDAOImpl extends BaseDAOImpl<EnumFieldTypeDTO, Integer>
         implements EnumFieldTypeDAO {
   /**
    *
    */
   public EnumFieldTypeDAOImpl() {
      super(EnumFieldTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumFieldTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumFieldTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumFieldTypeDTO findByName(final String fieldTypeName) {
      return super.findUnique("EnumFieldTypeDTO.findByName", new String[] { "name" }, fieldTypeName.toUpperCase());
   }
}
