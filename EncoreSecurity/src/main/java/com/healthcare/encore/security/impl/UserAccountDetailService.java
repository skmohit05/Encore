/**
 *
 */
package com.healthcare.encore.security.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import com.healthcare.encore.db.dao.UserDAO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.security.UserAccount;

/**
 * Implements Spring UserDetailService, makes use of db layer to validate the
 * user and provide the UserDetail object to Spring
 *
 * @author ckumar
 *
 */
@Service
public class UserAccountDetailService implements UserDetailsService {
   /**
   *
   */
   @Autowired
   private UserDAO userDAO;

   /**
   *
   */
   @Autowired
   private PlatformTransactionManager transactionManager;

   /**
   *
   */
   @Override
   public UserDetails loadUserByUsername(final String emailId) throws UsernameNotFoundException {
      TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionAttribute());
      UserAccount user = null;
      try {
         user = this.getUserAccount(emailId);
      } finally {
         this.transactionManager.commit(status);
      }

      if (user == null) {
         throw new UsernameNotFoundException("User login [" + emailId + "] not found");
      }
      return user;
   }

   /**
    *
    * @param loginId
    * @return Current authenticated user
    */
   private UserAccount getUserAccount(final String emailId) {
      UserAccount user = null;
      UserDTO userDTO = this.userDAO.findByEmailId(emailId);
      if (userDTO != null) {
         boolean enabled = userDTO.getRemoveRequestedDate() == null || userDTO.getRemoveRequestedDate().isAfter(LocalDate.now());
         user = new UserAccountImpl(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getFirstName(),
                  userDTO.getLastName(), enabled, this.getAuthoritiesOfUser(userDTO));
      }
      return user;
   }

   /**
    *
    * @param userDTO
    * @return
    */
   private List<GrantedAuthority> getAuthoritiesOfUser(final UserDTO userDTO) {
      return new ArrayList<>();
   }
}
