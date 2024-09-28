package com.healthcare.encore.db.dto;

import java.io.Serializable;
import java.time.LocalDate;

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

import com.healthcare.encore.db.audit.LogAuditInfo;
import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * The persistent class for the MedicalJobSeekerJobApplicationInfo database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
         @NamedQuery(name = "MedicalJobSeekerJobApplicationInfoDTO.findAll", query = "SELECT info"
                  + " FROM MedicalJobSeekerJobApplicationInfoDTO info"
                  + " WHERE info.userDTO.id=:jobSeekerUserId", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }),
         @NamedQuery(name = "MedicalJobSeekerJobApplicationInfoDTO.findByJobPostingId", query = "SELECT info"
                  + " FROM MedicalJobSeekerJobApplicationInfoDTO info" + " WHERE info.userDTO.id=:jobSeekerUserId"
                  + " AND info.medicalEmployerJobPostingDTO.id=:jobPostingId", hints = {
                           @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Entity
@Table(name = "MedicalJobSeekerJobApplicationInfo")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalJobSeekerJobApplicationInfoId", nullable = false))})
//@formatter:on
public class MedicalJobSeekerJobApplicationInfoDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

   private UserDTO userDTO;
   private MedicalEmployerJobPostingDTO medicalEmployerJobPostingDTO;
   private LocalDate appliedDate;
   private boolean accepted;
   private LocalDate startDate;
   private LocalDate endDate;
   private Integer compensation;
   private EnumCompensationTypeDTO compensationTypeDTO;
   private boolean jobCompletedAsPerAgreement;
   private UserDTO employerJobAgreementSignedUserDTO;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalJobSeekerUserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO medicalJobSeekerUserDTO) {
      this.userDTO = medicalJobSeekerUserDTO;
   }
   
   @Column(name = "Compensation")
   public Integer getCompensation() {
      return this.compensation;
   }

   public void setCompensation(final Integer compensation) {
      this.compensation = compensation;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalEmployerJobPostingId", nullable = false)
   public MedicalEmployerJobPostingDTO getMedicalEmployerJobPostingDTO() {
      return this.medicalEmployerJobPostingDTO;
   }

   public void setMedicalEmployerJobPostingDTO(final MedicalEmployerJobPostingDTO medicalEmployerJobPostingDTO) {
      this.medicalEmployerJobPostingDTO = medicalEmployerJobPostingDTO;
   }

   public LocalDate getAppliedDate() {
      return this.appliedDate;
   }

   public void setAppliedDate(final LocalDate appliedDate) {
      this.appliedDate = appliedDate;
   }

   public boolean isAccepted() {
      return this.accepted;
   }

   public void setAccepted(final boolean accepted) {
      this.accepted = accepted;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CompensationTypeId")
   public EnumCompensationTypeDTO getCompensationTypeDTO() {
      return this.compensationTypeDTO;
   }

   public void setCompensationTypeDTO(final EnumCompensationTypeDTO compensationTypeDTO) {
      this.compensationTypeDTO = compensationTypeDTO;
   }

   public boolean isJobCompletedAsPerAgreement() {
      return this.jobCompletedAsPerAgreement;
   }

   public void setJobCompletedAsPerAgreement(final boolean jobCompletedAsPerAgreement) {
      this.jobCompletedAsPerAgreement = jobCompletedAsPerAgreement;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "EmployerJobAgreementSignedUserId")
   public UserDTO getEmployerJobAgreementSignedUserDTO() {
      return this.employerJobAgreementSignedUserDTO;
   }

   public void setEmployerJobAgreementSignedUserDTO(final UserDTO employerJobAgreementSignedUserDTO) {
      this.employerJobAgreementSignedUserDTO = employerJobAgreementSignedUserDTO;
   }
}
