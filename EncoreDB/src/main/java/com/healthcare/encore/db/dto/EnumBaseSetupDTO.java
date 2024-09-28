package com.healthcare.encore.db.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

/**
 * 
 * @author mmeena
 *
 */
@MappedSuperclass
public class EnumBaseSetupDTO {

   /**
   *
   */
   private Integer id;

   /**
   *
   */
   private String name;

   /**
   *
   */
   private String desc;

   /**
   *
   */
   private boolean active;

   //  /**
   //   *
   //   */
   //  private AuditInfoDTO auditInfoDTO;

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
   * @return the name
   */
   @NaturalId(mutable = true)
   @Column(name = "Name", length = 128, nullable = false)
   public String getName() {
      return this.name;
   }

   /**
   * @param name the name to set
   */
   public void setName(final String name) {
      this.name = name;
   }

   /**
   * @return the desc
   */
   @Column(name = "Desc", length = 512)
   public String getDesc() {
      return this.desc;
   }

   /**
   * @param desc the desc to set
   */
   public void setDesc(final String desc) {
      this.desc = desc;
   }

   /**
   * @return the active
   */
   @Column(name = "IsActive", nullable = false)
   public boolean isActive() {
      return this.active;
   }

   /**
   * @param active the active to set
   */
   public void setActive(final boolean active) {
      this.active = active;
   }

   //  /**
   //   * @return the auditInfoDTO
   //   */
   //  @Embedded
   //  public AuditInfoDTO getAuditInfoDTO() {
   //     return this.auditInfoDTO;
   //  }
   //
   //  /**
   //   * @param auditInfoDTO the auditInfoDTO to set
   //   */
   //  public void setAuditInfoDTO(final AuditInfoDTO auditInfoDTO) {
   //     this.auditInfoDTO = auditInfoDTO;
   //  }

   /**
   * {@inheritDoc}
   */
   @Override
   public boolean equals(final Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if (!(Hibernate.getClass(this).equals(Hibernate.getClass(obj)))) {
         return false;
      }
      EnumBaseSetupDTO rhs = (EnumBaseSetupDTO) obj;
      return new EqualsBuilder().append(this.getName().toUpperCase(), rhs.getName().toUpperCase()).isEquals();
   }

   /**
   * {@inheritDoc}
   */
   @Override
   public int hashCode() {
      return new HashCodeBuilder(37, 47).append(this.getName().toUpperCase()).toHashCode();
   }
}
