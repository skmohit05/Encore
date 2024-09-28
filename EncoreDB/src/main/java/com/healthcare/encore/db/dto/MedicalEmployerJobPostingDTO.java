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
 * The persistent class for the MedicalEmployerJobPosting database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "MedicalEmployerJobPostingDTO.findAll",
            query = "SELECT jp"
                     + " FROM MedicalEmployerJobPostingDTO jp"
                     + " LEFT JOIN FETCH jp.userDTO"
                     + " WHERE jp.userDTO.id=:userId",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),

   @NamedQuery(
            name = "MedicalEmployerJobPostingDTO.findByJobSearch",
            query = "SELECT jp"
                     + " FROM MedicalEmployerJobPostingDTO jp"
                     + " WHERE jp.postedDate= :date"
                     + " AND jp.title= :title"
                     + " AND jp.speciality= :speciality",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})})
@Entity
@Table(name = "MedicalEmployerJobPosting")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalEmployerJobPostingId", nullable = false))})
//@formatter:on
public class MedicalEmployerJobPostingDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

   private UserDTO userDTO;
   private String title;
   private String speciality;
   private String jobDescription;
   private EnumAssignmentTypeDTO assignmentTypeDTO;
   private EnumShiftTypeDTO assignmentShiftTypeDTO;
   private Boolean supervised;
   private Boolean prescriptionAuthorityNeeded;
   private LocalDate assignmentFromDate;
   private LocalDate assignmentToDate;
   private String compensationRange;
   private Boolean malpracticeAccepted;
   private Boolean malpracticeCoverage;
   private Boolean credentialingCoverage;
   private Boolean licenseCoverage;
   private Boolean travelHousingCoverage;
   private Integer yearsExperience;
   private EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO1; 
   private EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO2; 
   private EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO3; 
   private EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO4; 
   private EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO5;
   private LocalDate postedDate;
   private LocalDate updatedDate;
   private EnumJobPostingStatusTypeDTO statusTypeDTO;
   private LocalDate expiryDate;
   private Integer compensation;
   private EnumCompensationTypeDTO compensationTypeDTO;
   private String state;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalEmployerUserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO userDTO) {
      this.userDTO = userDTO;
   }
   
   public String getTitle() {
      return this.title;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public String getSpeciality() {
      return this.speciality;
   }

   public void setSpeciality(final String speciality) {
      this.speciality = speciality;
   }

   public String getJobDescription() {
      return this.jobDescription;
   }

   public void setJobDescription(final String jobDescription) {
      this.jobDescription = jobDescription;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "AssignmentTypeId", nullable = false)
   public EnumAssignmentTypeDTO getAssignmentTypeDTO() {
      return this.assignmentTypeDTO;
   }

   public void setAssignmentTypeDTO(final EnumAssignmentTypeDTO assignmentTypeDTO) {
      this.assignmentTypeDTO = assignmentTypeDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "AssignmentShiftTypeId", nullable = false)
   public EnumShiftTypeDTO getAssignmentShiftTypeDTO() {
      return this.assignmentShiftTypeDTO;
   }

   public void setAssignmentShiftTypeDTO(final EnumShiftTypeDTO assignmentShiftTypeDTO) {
      this.assignmentShiftTypeDTO = assignmentShiftTypeDTO;
   }

   public LocalDate getAssignmentFromDate() {
      return this.assignmentFromDate;
   }

   public void setAssignmentFromDate(final LocalDate assignmentFromDate) {
      this.assignmentFromDate = assignmentFromDate;
   }

   public LocalDate getAssignmentToDate() {
      return this.assignmentToDate;
   }

   public void setAssignmentToDate(final LocalDate assignmentToDate) {
      this.assignmentToDate = assignmentToDate;
   }

   public Boolean isSupervised() {
      return this.supervised;
   }

   public void setSupervised(final Boolean supervised) {
      this.supervised = supervised;
   }

   public Boolean isMalpracticeCoverage() {
      return this.malpracticeCoverage;
   }

   public void setMalpracticeCoverage(final Boolean malpracticeCoverage) {
      this.malpracticeCoverage = malpracticeCoverage;
   }

   public Boolean isCredentialingCoverage() {
      return this.credentialingCoverage;
   }

   public void setCredentialingCoverage(final Boolean credentialingCoverage) {
      this.credentialingCoverage = credentialingCoverage;
   }

   public Boolean isTravelHousingCoverage() {
      return this.travelHousingCoverage;
   }

   public void setTravelHousingCoverage(final Boolean travelHousingCoverage) {
      this.travelHousingCoverage = travelHousingCoverage;
   }

   public Boolean isPrescriptionAuthorityNeeded() {
      return this.prescriptionAuthorityNeeded;
   }

   public void setPrescriptionAuthorityNeeded(final Boolean prescriptionAuthorityNeeded) {
      this.prescriptionAuthorityNeeded = prescriptionAuthorityNeeded;
   }

   public String getCompensationRange() {
      return this.compensationRange;
   }

   public void setCompensationRange(final String compensationRange) {
      this.compensationRange = compensationRange;
   }

   public Boolean isMalpracticeAccepted() {
      return this.malpracticeAccepted;
   }

   public void setMalpracticeAccepted(final Boolean malpracticeAccepted) {
      this.malpracticeAccepted = malpracticeAccepted;
   }

   public Boolean isLicenseCoverage() {
      return this.licenseCoverage;
   }

   public void setLicenseCoverage(final Boolean licenseCoverage) {
      this.licenseCoverage = licenseCoverage;
   }

   public Integer getYearsExperience() {
      return this.yearsExperience;
   }

   public void setYearsExperience(final Integer yearsExperience) {
      this.yearsExperience = yearsExperience;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "Priority1", nullable = false)
   public EnumPriorityFeatureTypeDTO getPriorityFeatureTypeDTO1() {
      return this.priorityFeatureTypeDTO1;
   }

   public void setPriorityFeatureTypeDTO1(final EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO1) {
      this.priorityFeatureTypeDTO1 = priorityFeatureTypeDTO1;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "Priority2", nullable = false)
   public EnumPriorityFeatureTypeDTO getPriorityFeatureTypeDTO2() {
      return this.priorityFeatureTypeDTO2;
   }

   public void setPriorityFeatureTypeDTO2(final EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO2) {
      this.priorityFeatureTypeDTO2 = priorityFeatureTypeDTO2;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "Priority3", nullable = false)
   public EnumPriorityFeatureTypeDTO getPriorityFeatureTypeDTO3() {
      return this.priorityFeatureTypeDTO3;
   }

   public void setPriorityFeatureTypeDTO3(final EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO3) {
      this.priorityFeatureTypeDTO3 = priorityFeatureTypeDTO3;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "Priority4", nullable = false)
   public EnumPriorityFeatureTypeDTO getPriorityFeatureTypeDTO4() {
      return this.priorityFeatureTypeDTO4;
   }

   public void setPriorityFeatureTypeDTO4(final EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO4) {
      this.priorityFeatureTypeDTO4 = priorityFeatureTypeDTO4;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "Priority5", nullable = false)
   public EnumPriorityFeatureTypeDTO getPriorityFeatureTypeDTO5() {
      return this.priorityFeatureTypeDTO5;
   }

   public void setPriorityFeatureTypeDTO5(final EnumPriorityFeatureTypeDTO priorityFeatureTypeDTO5) {
      this.priorityFeatureTypeDTO5 = priorityFeatureTypeDTO5;
   }

   public LocalDate getPostedDate() {
      return this.postedDate;
   }

   public void setPostedDate(final LocalDate postedDate) {
      this.postedDate = postedDate;
   }

   public LocalDate getUpdatedDate() {
      return this.updatedDate;
   }

   public void setUpdatedDate(final LocalDate updatedDate) {
      this.updatedDate = updatedDate;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "StatusTypeId", nullable = false)
   public EnumJobPostingStatusTypeDTO getStatusTypeDTO() {
      return this.statusTypeDTO;
   }

   public void setStatusTypeDTO(final EnumJobPostingStatusTypeDTO statusTypeDTO) {
      this.statusTypeDTO = statusTypeDTO;
   }

   public LocalDate getExpiryDate() {
      return this.expiryDate;
   }

   public void setExpiryDate(final LocalDate expiryDate) {
      this.expiryDate = expiryDate;
   }
   
   @Column(name = "Compensation")
   public Integer getCompensation() {
      return this.compensation;
   }

   public void setCompensation(final Integer compensation) {
      this.compensation = compensation;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CompensationTypeId", nullable = false)
   public EnumCompensationTypeDTO getCompensationTypeDTO() {
      return this.compensationTypeDTO;
   }

   public void setCompensationTypeDTO(final EnumCompensationTypeDTO compensationTypeDTO) {
      this.compensationTypeDTO = compensationTypeDTO;
   }

   public String getState() {
      return this.state;
   }

   public void setState(final String state) {
      this.state = state;
   }
}
