package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumJobTypeDAO;
import com.healthcare.encore.db.dto.EnumJobTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumJobTypeDAOImpl extends BaseDAOImpl<EnumJobTypeDTO, Integer>
         implements EnumJobTypeDAO {
   /**
    *
    */
   public EnumJobTypeDAOImpl() {
      super(EnumJobTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumJobTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumJobTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumJobTypeDTO findByName(final String jobTypeName) {
      return super.findUnique("EnumJobTypeDTO.findByName", new String[] { "name" }, jobTypeName.toUpperCase());
   }
}
