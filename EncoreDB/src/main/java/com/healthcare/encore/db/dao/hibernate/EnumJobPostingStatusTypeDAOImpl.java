package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumJobPostingStatusTypeDAO;
import com.healthcare.encore.db.dto.EnumJobPostingStatusTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumJobPostingStatusTypeDAOImpl extends BaseDAOImpl<EnumJobPostingStatusTypeDTO, Integer>
         implements EnumJobPostingStatusTypeDAO {
   /**
    *
    */
   public EnumJobPostingStatusTypeDAOImpl() {
      super(EnumJobPostingStatusTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumJobPostingStatusTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumJobPostingStatusTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumJobPostingStatusTypeDTO findByName(final String jobPostingStatusTypeName) {
      return super.findUnique("EnumJobPostingStatusTypeDTO.findByName", new String[] { "name" }, jobPostingStatusTypeName.toUpperCase());
   }
}
