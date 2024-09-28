package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumCompensationTypeDAO;
import com.healthcare.encore.db.dto.EnumCompensationTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumCompensationTypeDAOImpl extends BaseDAOImpl<EnumCompensationTypeDTO, Integer>
         implements EnumCompensationTypeDAO {
   /**
    *
    */
   public EnumCompensationTypeDAOImpl() {
      super(EnumCompensationTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumCompensationTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumCompensationTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumCompensationTypeDTO findByName(final String compensationTypeName) {
      return super.findUnique("EnumCompensationTypeDTO.findByName", new String[] { "name" }, compensationTypeName.toUpperCase());
   }
}
