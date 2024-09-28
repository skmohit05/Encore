package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumPriorityFeatureTypeDAO;
import com.healthcare.encore.db.dto.EnumPriorityFeatureTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumPriorityFeatureTypeDAOImpl extends BaseDAOImpl<EnumPriorityFeatureTypeDTO, Integer>
         implements EnumPriorityFeatureTypeDAO {
   /**
    *
    */
   public EnumPriorityFeatureTypeDAOImpl() {
      super(EnumPriorityFeatureTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumPriorityFeatureTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumPriorityFeatureTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumPriorityFeatureTypeDTO findByName(final String priorityFeatureTypeName) {
      return super.findUnique("EnumPriorityFeatureTypeDTO.findByName", new String[] { "name" }, priorityFeatureTypeName.toUpperCase());
   }
}
