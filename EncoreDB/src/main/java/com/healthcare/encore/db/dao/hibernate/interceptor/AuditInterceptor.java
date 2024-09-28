/**
 *
 */
package com.healthcare.encore.db.dao.hibernate.interceptor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.healthcare.encore.db.audit.AuditInfoAnnotationProcessor;
import com.healthcare.encore.db.audit.AuditInfoProvider;
import com.healthcare.encore.db.dao.UserDAO;
import com.healthcare.encore.db.dto.AuditInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 * @author ckumar
 *
 */
public class AuditInterceptor extends EmptyInterceptor {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   /**
    *
    */
   @Autowired
   private transient AuditInfoAnnotationProcessor processor;

   /**
    *
    */
   @Autowired
   private transient UserDAO userDAO;

   /**
    *
    */
   @Autowired
   @Lazy
   private transient AuditInfoProvider auditInfoProvider;

   /**
    *
    */
   private final Instant forcedAuditInstant = LocalDateTime.of(1900, 1, 1, 0, 0, 0).toInstant(ZoneOffset.UTC);



   /**
    *
    */
   private final Instant retainAuditLubInstant = LocalDateTime.of(1900, 1, 1, 1, 0, 0).toInstant(ZoneOffset.UTC);

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public int[] findDirty(final Object entity, final Serializable id, final Object[] currentState, final Object[] previousState,
            final String[] propertyNames, final Type[] types) {
      if (this.processor.isAuditInfoLoggable(entity)) {
         this.checkAndResetAuditInfo(currentState, previousState, propertyNames);
      }
      return super.findDirty(entity, id, currentState, previousState, propertyNames, types);
   }

   /**
    * Populates the database audit info available in previous state to current state, to
    * avoid change identification flagging dirty due to audit fields
    *
    * If special instant dates are passed then this population is not done
    */
   private void checkAndResetAuditInfo(final Object[] currentState, final Object[] previousState, final String[] propertyNames) {
      for (int i = 0; i < propertyNames.length; i++) {
         if (propertyNames[i].equals("auditInfoDTO")) {
            AuditInfoDTO auditInfoDTO = (AuditInfoDTO) currentState[i];
            //auditInfo.getLud not in (forcedAuditInstant, retainAuditInstant)
            if (auditInfoDTO == null || !(this.forcedAuditInstant.equals(auditInfoDTO.getLud())
                     || this.retainAuditLubInstant.equals(auditInfoDTO.getLud()))) {
               currentState[i] = previousState[i];
            }
         }
      }
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public boolean onSave(final Object entity, final Serializable id, final Object[] state, final String[] propertyNames,
            final Type[] types) {
      return this.updateAuditInfo(entity, state, propertyNames);
   }

   /**
    *
    * {@inheritDoc}
    */
   @Override
   public boolean onFlushDirty(final Object entity, final Serializable id, final Object[] currentState,
            final Object[] previousState, final String[] propertyNames, final Type[] types)
      throws CallbackException {
      boolean updated = false;
      if (this.processor.isAuditInfoLoggable(entity)) {
         for (int i = 0; i < propertyNames.length; i++) {
            if (propertyNames[i].equals("auditInfoDTO")) {
               AuditInfoDTO currentAuditInfoDTO =  (AuditInfoDTO) currentState[i];
               if(currentAuditInfoDTO != null && currentAuditInfoDTO.getLud().equals(this.retainAuditLubInstant)) {
                  currentState[i] = previousState[i];
               } else {
                  AuditInfoDTO auditInfoDTO = new AuditInfoDTO();
                  auditInfoDTO.setLud(Instant.now());
                  auditInfoDTO.setLubDTO(this.getUserDTO());
                  currentState[i] = auditInfoDTO;
               }
               updated = true;
            }
         }
      }
      return updated;
      //return this.updateAuditInfo(entity, currentState, propertyNames);
   }

   /**
    *
    * @param entity
    * @return true, if data is updated in the state
    */
   private boolean updateAuditInfo(final Object entity, final Object[] state, final String[] propertyNames) {
      boolean updated = false;
      if (this.processor.isAuditInfoLoggable(entity)) {
         for (int i = 0; i < propertyNames.length; i++) {
            if (propertyNames[i].equals("auditInfoDTO")) {
               AuditInfoDTO auditInfoDTO = new AuditInfoDTO();
               auditInfoDTO.setLud(Instant.now());
               auditInfoDTO.setLubDTO(this.getUserDTO());
               state[i] = auditInfoDTO;
            }
         }
         updated = true;
      }
      return updated;
   }

   /**
    *
    * @return
    */
   private UserDTO getUserDTO() {
      UserDTO userDTO = null;
      if (this.auditInfoProvider.getAuditUserId() != null) {
         userDTO = this.userDAO.findById(this.auditInfoProvider.getAuditUserId());
      }
      return userDTO;
   }
}
