package com.healthcare.encore.db.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import com.healthcare.encore.db.audit.LogAuditInfo;
import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * The persistent class for the MedicalJobSeekerStateLevelInfo database table.
 *
 * @author mmeena
 */
// @formatter:off
@LogAuditInfo
@NamedQueries({
         @NamedQuery(name = "MedicalJobSeekerStateLevelInfoDTO.findAll", query = "SELECT sli"
                  + " FROM MedicalJobSeekerStateLevelInfoDTO sli"
                  + " WHERE sli.medicalJobSeekerExtendedInfoDTO.id=:jobSeekerExtendedInfoDTO", hints = {
                           @QueryHint(name = "org.hibernate.cacheable", value = "true") }),
         @NamedQuery(name = "MedicalJobSeekerStateLevelInfoDTO.findByUserStateId", query = "SELECT sli"
                  + " FROM MedicalJobSeekerStateLevelInfoDTO sli" + " WHERE sli.medicalJobSeekerExtendedInfoDTO.id=:jobSeekerExtendedInfoId"
                  + " AND sli.usStatesTypeDTO.id=:stateId", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Entity
@Table(name = "MedicalJobSeekerStateLevelInfo")
// @formatter:on
public class MedicalJobSeekerStateLevelInfoDTO implements Serializable {

   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

   private Integer id;

   private MedicalJobSeekerExtendedInfoDTO medicalJobSeekerExtendedInfoDTO;

   private EnumUSStatesTypeDTO usStatesTypeDTO;

   private LocalDate licenseExpirationDate;

   private Boolean prescriptionAuthority;

   @Id
   @Column(name = "MedicalJobSeekerStateLevelInfoId", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer getId() {
      return this.id;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalJobSeekerExtendedInfoId", nullable = false)
   public MedicalJobSeekerExtendedInfoDTO getMedicalJobSeekerExtendedInfoDTO() {
      return this.medicalJobSeekerExtendedInfoDTO;
   }

   public void setMedicalJobSeekerExtendedInfoDTO(final MedicalJobSeekerExtendedInfoDTO medicalJobSeekerExtendedInfoDTO) {
      this.medicalJobSeekerExtendedInfoDTO = medicalJobSeekerExtendedInfoDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "StateId", nullable = false)
   public EnumUSStatesTypeDTO getUsStatesTypeDTO() {
      return this.usStatesTypeDTO;
   }

   public void setUsStatesTypeDTO(final EnumUSStatesTypeDTO usStatesTypeDTO) {
      this.usStatesTypeDTO = usStatesTypeDTO;
   }

   public LocalDate getLicenseExpirationDate() {
      return this.licenseExpirationDate;
   }

   public void setLicenseExpirationDate(final LocalDate licenseExpirationDate) {
      this.licenseExpirationDate = licenseExpirationDate;
   }

   public Boolean isPrescriptionAuthority() {
      return this.prescriptionAuthority;
   }

   public void setPrescriptionAuthority(final Boolean prescriptionAuthority) {
      this.prescriptionAuthority = prescriptionAuthority;
   }
}
