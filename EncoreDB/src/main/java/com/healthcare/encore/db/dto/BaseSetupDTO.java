/**
 *
 */
package com.healthcare.encore.db.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author ckumar
 *
 */
@MappedSuperclass
public class BaseSetupDTO {

   private Integer id;

   private AuditInfoDTO auditInfoDTO;

   /**
    * @return the id
    */
   @Id
   @Column(name = "Id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer getId() {
      return this.id;
   }

   /**
    * @param id the id to set
    */
   public void setId(final Integer id) {
      this.id = id;
   }

   /**
    * @return the auditInfoDTO
    */
   @Embedded
   public AuditInfoDTO getAuditInfoDTO() {
      return this.auditInfoDTO;
   }

   /**
    * @param auditInfoDTO the auditInfoDTO to set
    */
   public void setAuditInfoDTO(final AuditInfoDTO auditInfoDTO) {
      this.auditInfoDTO = auditInfoDTO;
   }
}
