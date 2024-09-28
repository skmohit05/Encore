/**
 *
 */
package com.healthcare.encore.dbmanager.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dto.AuditInfoDTO;
import com.healthcare.encore.model.AuditInfo;

/**
 * 
 * @author ckumar
 *
 */
@Component
public class MapperUtil {

   /**
    *
    */
   @Autowired
   private UserMapperUtil userMapperUtil;

   /**
    *
    * @param auditInfoDTO
    * @return AuditInfo
    */
   public AuditInfo getModel(final AuditInfoDTO auditInfoDTO) {
      return auditInfoDTO == null ? null
               : new AuditInfo(auditInfoDTO.getLud(), this.userMapperUtil.getUserLoginId(auditInfoDTO.getLubDTO()));
   }
}
