package com.healthcare.encore.dbmanager.common;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dto.AuditInfoDTO;

/**
 *
 * @author avinayagam
 *
 */
@Component
public class DBManagerUtil {

   /**
    *
    */
   private final AuditInfoDTO forcedAuditInfoDTO = new AuditInfoDTO();

   /**
    *
    */
   private final AuditInfoDTO retainAuditInfoDTO = new AuditInfoDTO();

   /**
    *
    */
   public DBManagerUtil() {
      this.forcedAuditInfoDTO.setLud(LocalDateTime.of(1900, 1, 1, 0, 0, 0).toInstant(ZoneOffset.UTC));
      this.retainAuditInfoDTO.setLud(LocalDateTime.of(1900, 1, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
   }

   /**
    *
    * @return AuditInfoDTO objects that forces audit to be updated
    * by intercepter irrespective of there is a change or not
    */
   public AuditInfoDTO getForcedAuditInfo() {
      return this.forcedAuditInfoDTO;
   }

   /**
    *
    * @return AuditInfoDTO objects that retain old audit
    */
   public AuditInfoDTO getRetainedAuditInfo() {
      return this.retainAuditInfoDTO;
   }
}
