package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumMFATypeDAO;
import com.healthcare.encore.db.dto.EnumMFATypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumMFATypeDAOImpl extends BaseDAOImpl<EnumMFATypeDTO, Integer>
         implements EnumMFATypeDAO {
   /**
    *
    */
   public EnumMFATypeDAOImpl() {
      super(EnumMFATypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumMFATypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumMFATypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumMFATypeDTO findByName(final String mfaTypeName) {
      return super.findUnique("EnumMFATypeDTO.findByName", new String[] { "name" }, mfaTypeName.toUpperCase());
   }
}
