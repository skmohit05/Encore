package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumAssignmentTypeDAO;
import com.healthcare.encore.db.dto.EnumAssignmentTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumAssignmentTypeDAOImpl extends BaseDAOImpl<EnumAssignmentTypeDTO, Integer>
         implements EnumAssignmentTypeDAO {
   /**
    *
    */
   public EnumAssignmentTypeDAOImpl() {
      super(EnumAssignmentTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumAssignmentTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumAssignmentTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumAssignmentTypeDTO findByName(final String assignmentTypeName) {
      return super.findUnique("EnumAssignmentTypeDTO.findByName", new String[] { "name" }, assignmentTypeName.toUpperCase());
   }
}
