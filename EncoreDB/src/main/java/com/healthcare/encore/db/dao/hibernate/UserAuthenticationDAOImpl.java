package com.healthcare.encore.db.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.UserAuthenticationDAO;
import com.healthcare.encore.db.dto.UserAuthenticationDTO;

/**
 *
 * @author ckumar
 *
 */
@Repository
public class UserAuthenticationDAOImpl extends BaseDAOImpl<UserAuthenticationDTO, Integer> implements UserAuthenticationDAO {

   /**
    *
    */
   public UserAuthenticationDAOImpl() {
      super(UserAuthenticationDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public UserAuthenticationDTO findByUserId(final Integer userId) {
      return super.findUnique("UserAuthenticationDTO.findByUserId", new String[] { "userId" }, userId);
   }

}
