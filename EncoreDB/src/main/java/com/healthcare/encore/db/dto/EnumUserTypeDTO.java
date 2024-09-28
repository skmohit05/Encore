package com.healthcare.encore.db.dto;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;


/**
 * The persistent class for the EnumUserType database table.
 *
 * @author mmeena
 *
 */
//@formatter:off
//@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "EnumUserTypeDTO.findAll",
            query = "SELECT e"
                     + " FROM EnumUserTypeDTO e"
                     + " WHERE (:applyActiveFilter=false OR e.active=true)",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
            name = "EnumUserTypeDTO.findByName",
            query = "SELECT e FROM EnumUserTypeDTO e WHERE e.name=:name",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "EnumUserType")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "UserTypeId", nullable = false)),
   @AttributeOverride(name = "name", column = @Column(name = "UserTypeName", length = 128, nullable = false)),
   @AttributeOverride(name = "desc", column = @Column(name = "UserTypeDesc", length = 512)) })
@NaturalIdCache
//@formatter:on
public class EnumUserTypeDTO extends EnumBaseSetupDTO implements Serializable {
   /**
    *
    */
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   /**
    * 
    */
   private String role;
   
   /**
    * 
    * @return
    */
   @Column(name = "UserRole", length = 64, nullable = false)
   public String getRole() {
      return this.role;
   }
   
   /**
    * 
    * @param role
    */
   public void setRole(final String role) {
      this.role = role;
   }

}
