package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumUserTypeDAO;
import com.healthcare.encore.db.dto.EnumUserTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumUserTypeDAOImpl extends BaseDAOImpl<EnumUserTypeDTO, Integer>
         implements EnumUserTypeDAO {
   /**
    *
    */
   public EnumUserTypeDAOImpl() {
      super(EnumUserTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumUserTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumUserTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumUserTypeDTO findByName(final String userTypeName) {
      return super.findUnique("EnumUserTypeDTO.findByName", new String[] { "name" }, userTypeName.toUpperCase());
   }
}
