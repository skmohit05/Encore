package com.healthcare.encore.db.dao;

import com.healthcare.encore.db.dto.UserAuthenticationDTO;

/**
 *
 * @author ckumar
 *
 */
public interface UserAuthenticationDAO extends BaseDAO<UserAuthenticationDTO, Integer> {   
   /**
    * 
    * @param userId
    * @return
    */
   UserAuthenticationDTO findByUserId(Integer userId);
}
