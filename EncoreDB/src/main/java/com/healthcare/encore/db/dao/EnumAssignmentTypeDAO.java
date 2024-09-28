package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumAssignmentTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumAssignmentTypeDAO extends BaseDAO<EnumAssignmentTypeDTO, Integer> {
   
   List<EnumAssignmentTypeDTO> findAll(boolean applyActiveFilter);

   EnumAssignmentTypeDTO findByName(String assignmentTypeName);
}
