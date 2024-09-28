/**
 *
 */
package com.healthcare.encore.dbmanager.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.UserDAO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 * User mapper methods
 * 
 * @author ckumar
 *
 */
@Component
public class UserMapperUtil {

   /**
    *
    */
   @Autowired
   private UserDAO userDAO;

   /**
    *
    * @param dto
    * @return login id
    */
   public String getUserLoginId(final UserDTO dto) {
      return dto != null ? dto.getFirstName() : null;
   }

   /**
    *
    * @param loginId
    * @return User
    */
   public UserDTO getUserDTO(final String emailId) {
      return emailId == null ? null : this.userDAO.findByEmailId(emailId);
   }

   /**
    * 
    * @param userId
    * @return
    */
   public UserDTO getUserDTO(final Integer userId) {
      return userId == null ? null : this.userDAO.findById(userId);
   }
}
