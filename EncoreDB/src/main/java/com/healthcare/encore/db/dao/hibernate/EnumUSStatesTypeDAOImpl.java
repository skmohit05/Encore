package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.EnumUSStatesTypeDAO;
import com.healthcare.encore.db.dto.EnumUSStatesTypeDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class EnumUSStatesTypeDAOImpl extends BaseDAOImpl<EnumUSStatesTypeDTO, Integer>
         implements EnumUSStatesTypeDAO {
   /**
    *
    */
   public EnumUSStatesTypeDAOImpl() {
      super(EnumUSStatesTypeDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<EnumUSStatesTypeDTO> findAll(final boolean applyActiveFilter) {
      return super.list("EnumUSStatesTypeDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public EnumUSStatesTypeDTO findByName(final String usStatesTypeName) {
      return super.findUnique("EnumUSStatesTypeDTO.findByName", new String[] { "name" }, usStatesTypeName);
   }
}
