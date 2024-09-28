package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.UserDAO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author ckumar
 *
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO, Integer> implements UserDAO {

   /**
    *
    */
   public UserDAOImpl() {
      super(UserDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<UserDTO> findAll(final boolean applyActiveFilter) {
      return super.list("UserDTO.findAll", new String[] { "applyActiveFilter" }, applyActiveFilter);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public UserDTO findByEmailId(final String emailId) {
      return super.findUnique("UserDTO.findByEmailId", new String[] { "emailId" }, emailId.toUpperCase());
   }

}
