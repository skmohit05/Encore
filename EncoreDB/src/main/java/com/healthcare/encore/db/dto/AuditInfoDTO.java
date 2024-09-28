/**
 *
 */
package com.healthcare.encore.db.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * @author ckumar
 *
 */
@Embeddable
public class AuditInfoDTO implements Serializable {
   /**
    *
    */
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

   /**
    *
    */
   private Instant lud;

   /**
    *
    */
   private UserDTO lubDTO;


   /**
    * @return the lud
    */
   @Column(name = "Lud")
   public Instant getLud() {
      return this.lud;
   }

   /**
    * @param lud the lud to set
    */
   public void setLud(final Instant lud) {
      this.lud = lud;
   }

   /**
    * @return the lubDTO
    */
   @ManyToOne(fetch=FetchType.LAZY)
   @NotFound(action=NotFoundAction.IGNORE)
   @JoinColumn(name = "Lub")
   public UserDTO getLubDTO() {
      return this.lubDTO;
   }

   /**
    * @param lubDTO the lubDTO to set
    */
   public void setLubDTO(final UserDTO lubDTO) {
      this.lubDTO = lubDTO;
   }
}
