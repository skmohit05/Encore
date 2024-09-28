package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author ckumar
 *
 */
public interface UserDAO extends BaseDAO<UserDTO, Integer> {
   /**
    * @param applyActiveFilter
    *
    * @return user
    */
   List<UserDTO> findAll(boolean applyActiveFilter);
   
   /**
    * 
    * @param emailId
    * @return
    */
   UserDTO findByEmailId(String emailId);
}
