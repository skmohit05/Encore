package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumJobPostingStatusTypeDTO;

/**
 *
 * @author mmeena
 *
 */
public interface EnumJobPostingStatusTypeDAO extends BaseDAO<EnumJobPostingStatusTypeDTO, Integer> {
   
   List<EnumJobPostingStatusTypeDTO> findAll(boolean applyActiveFilter);

   EnumJobPostingStatusTypeDTO findByName(String jobPostingStatusTypeName);
}
