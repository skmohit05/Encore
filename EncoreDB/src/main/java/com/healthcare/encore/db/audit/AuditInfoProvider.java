/**
 *
 */
package com.healthcare.encore.db.audit;

/**
 * @author ckumar
 *
 */
public interface AuditInfoProvider {
   /**
    *
    * @return Current user id from User table, to be logged in Lub field
    */
   Integer getAuditUserId();
}
