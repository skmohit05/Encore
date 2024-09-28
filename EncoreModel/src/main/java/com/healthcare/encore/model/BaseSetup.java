/**
 *
 */
package com.healthcare.encore.model;

/**
 * 
 * @author ckumar
 *
 */
public class BaseSetup {

   /**
    *
    */
   private AuditInfo auditInfo;

   /**
    * @return the auditInfo
    */
   //   @JsonIgnore
   public AuditInfo getAuditInfo() {
      return this.auditInfo;
   }

   /**
    * @param auditInfo the auditInfo to set
    */
   public void setAuditInfo(final AuditInfo auditInfo) {
      this.auditInfo = auditInfo;
   }
}
