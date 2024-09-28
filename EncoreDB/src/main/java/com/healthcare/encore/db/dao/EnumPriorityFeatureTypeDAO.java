package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumPriorityFeatureTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumPriorityFeatureTypeDAO extends BaseDAO<EnumPriorityFeatureTypeDTO, Integer> {
   
   List<EnumPriorityFeatureTypeDTO> findAll(boolean applyActiveFilter);

   EnumPriorityFeatureTypeDTO findByName(String priorityFeatureTypeName);
}
