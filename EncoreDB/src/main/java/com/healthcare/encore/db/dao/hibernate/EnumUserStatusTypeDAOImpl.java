package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumUserStatusTypeDAO;
import com.healthcare.encore.db.dto.EnumUserStatusTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumUserStatusTypeDAOImpl extends BaseDAOImpl<EnumUserStatusTypeDTO, Integer>
         implements EnumUserStatusTypeDAO {
   /**
    *
    */
   public EnumUserStatusTypeDAOImpl() {
      super(EnumUserStatusTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumUserStatusTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumUserStatusTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumUserStatusTypeDTO findByName(final String userStatusTypeName) {
      return super.findUnique("EnumUserStatusTypeDTO.findByName", new String[] { "name" }, userStatusTypeName.toUpperCase());
   }
}
