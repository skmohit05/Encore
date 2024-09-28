package com.healthcare.encore.db.dto;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;

import com.healthcare.encore.db.audit.LogAuditInfo;
import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * The persistent class for the Organization database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "OrganizationDTO.findAll",
            query = "SELECT o"
                     + " FROM OrganizationDTO o"
                     + " WHERE (:applyActiveFilter=false)",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
           name = "OrganizationDTO.findByName",
           query = "SELECT o FROM OrganizationDTO o WHERE o.organizationName=:name",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Table(name = "Organization")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "OrganizationId", nullable = false))})
//@formatter:on
public class OrganizationDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private String organizationName;
   
   private EnumOrganizationTypeDTO organizationTypeDTO;

   private String speciality;
   
   private EnumFacilityTypeDTO facilityTypeDTO;
   
   private EnumFacilitySubTypeDTO facilitySubTypeDTO;

   private boolean government;

   @Column(name = "OrganizationName", nullable = false)
   public String getOrganizationName() {
      return this.organizationName;
   }

   public void setOrganizationName(final String organizationName) {
      this.organizationName = organizationName;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "OrganizationTypeId")
   public EnumOrganizationTypeDTO getOrganizationTypeDTO() {
      return this.organizationTypeDTO;
   }

   public void setOrganizationTypeDTO(final EnumOrganizationTypeDTO organizationTypeDTO) {
      this.organizationTypeDTO = organizationTypeDTO;
   }

   @Column(name = "Speciality")
   public String getSpeciality() {
      return this.speciality;
   }

   public void setSpeciality(final String speciality) {
      this.speciality = speciality;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FacilityTypeId", nullable = false)
   public EnumFacilityTypeDTO getFacilityTypeDTO() {
      return this.facilityTypeDTO;
   }

   public void setFacilityTypeDTO(final EnumFacilityTypeDTO facilityTypeDTO) {
      this.facilityTypeDTO = facilityTypeDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FacilitySubTypeId", nullable = false)
   public EnumFacilitySubTypeDTO getFacilitySubTypeDTO() {
      return this.facilitySubTypeDTO;
   }

   public void setFacilitySubTypeDTO(final EnumFacilitySubTypeDTO facilitySubType) {
      this.facilitySubTypeDTO = facilitySubType;
   }

   @Column(name = "Government")
   public boolean isGovernment() {
      return this.government;
   }

   public void setGovernment(final boolean government) {
      this.government = government;
   }

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
      OrganizationDTO rhs = (OrganizationDTO) obj;
      return new EqualsBuilder()
               .append(this.getOrganizationName().toUpperCase(),
                        rhs.getOrganizationName().toUpperCase())
               .isEquals();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public int hashCode() {
      return new HashCodeBuilder(23, 47)
               .append(this.getOrganizationName().toUpperCase())
               .toHashCode();
   }
}
