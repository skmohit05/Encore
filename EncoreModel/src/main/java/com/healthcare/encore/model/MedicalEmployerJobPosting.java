/**
 *
 */
package com.healthcare.encore.model;

import java.time.LocalDate;

/**
 * 
 * @author mmeena
 *
 */
public class MedicalEmployerJobPosting implements Comparable<MedicalEmployerJobPosting>{

   private Integer medicalEmployerJobPostingId;
   private String title;
   private String speciality;
   private String jobDescription;
   private AssignmentTypeEnum assignmentType;
   private ShiftTypeEnum assignmentShiftType;
   private Boolean supervised;
   private Boolean prescriptionAuthorityNeeded;
   private LocalDate assignmentFromDate;
   private LocalDate assignmentToDate;
   private String compensationRange;
   private Boolean malpracticeAccepted;
   private Boolean malpracticeCoverage;
   private Boolean credentialingCoverage;
   private Boolean licensingCoverage;
   private Boolean travelHousingCoverage;
   private Integer yearsExperience;
   private PriorityFeatureTypeEnum priorityFeatureType1;
   private PriorityFeatureTypeEnum priorityFeatureType2;
   private PriorityFeatureTypeEnum priorityFeatureType3;
   private PriorityFeatureTypeEnum priorityFeatureType4;
   private PriorityFeatureTypeEnum priorityFeatureType5;
   private LocalDate postedDate;
   private LocalDate updatedDate;
   private JobPostingStatusTypeEnum statusType;
   private LocalDate expiryDate;
   private Integer compensation;
   private CompensationTypeEnum compensationType;
   private String state;
   private String organizationName;

   public Integer getMedicalEmployerJobPostingId() {
      return this.medicalEmployerJobPostingId;
   }

   public void setMedicalEmployerJobPostingId(final Integer medicalEmployerJobPostingId) {
      this.medicalEmployerJobPostingId = medicalEmployerJobPostingId;
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

   public AssignmentTypeEnum getAssignmentType() {
      return this.assignmentType;
   }

   public void setAssignmentType(final AssignmentTypeEnum assignmentType) {
      this.assignmentType = assignmentType;
   }

   public ShiftTypeEnum getAssignmentShiftType() {
      return this.assignmentShiftType;
   }

   public void setAssignmentShiftType(final ShiftTypeEnum assignmentShiftType) {
      this.assignmentShiftType = assignmentShiftType;
   }

   public Boolean isSupervised() {
      return this.supervised;
   }

   public void setSupervised(final Boolean supervised) {
      this.supervised = supervised;
   }

   public Boolean isPrescriptionAuthorityNeeded() {
      return this.prescriptionAuthorityNeeded;
   }

   public void setPrescriptionAuthorityNeeded(final Boolean prescriptionAuthorityNeeded) {
      this.prescriptionAuthorityNeeded = prescriptionAuthorityNeeded;
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

   public Boolean isLicensingCoverage() {
      return this.licensingCoverage;
   }

   public String getOrganizationName() {
      return this.organizationName;
   }

   public void setOrganizationName(final String organizationName) {
      this.organizationName = organizationName;
   }

   public void setLicensingCoverage(final Boolean licensingCoverage) {
      this.licensingCoverage = licensingCoverage;
   }

   public Boolean isTravelHousingCoverage() {
      return this.travelHousingCoverage;
   }

   public void setTravelHousingCoverage(final Boolean travelHousingCoverage) {
      this.travelHousingCoverage = travelHousingCoverage;
   }

   public Integer getYearsExperience() {
      return this.yearsExperience;
   }

   public void setYearsExperience(final Integer yearsExperience) {
      this.yearsExperience = yearsExperience;
   }

   public PriorityFeatureTypeEnum getPriorityFeatureType1() {
      return this.priorityFeatureType1;
   }

   public void setPriorityFeatureType1(final PriorityFeatureTypeEnum priorityFeatureType1) {
      this.priorityFeatureType1 = priorityFeatureType1;
   }

   public PriorityFeatureTypeEnum getPriorityFeatureType2() {
      return this.priorityFeatureType2;
   }

   public void setPriorityFeatureType2(final PriorityFeatureTypeEnum priorityFeatureType2) {
      this.priorityFeatureType2 = priorityFeatureType2;
   }

   public PriorityFeatureTypeEnum getPriorityFeatureType3() {
      return this.priorityFeatureType3;
   }

   public void setPriorityFeatureType3(final PriorityFeatureTypeEnum priorityFeatureType3) {
      this.priorityFeatureType3 = priorityFeatureType3;
   }

   public PriorityFeatureTypeEnum getPriorityFeatureType4() {
      return this.priorityFeatureType4;
   }

   public void setPriorityFeatureType4(final PriorityFeatureTypeEnum priorityFeatureType4) {
      this.priorityFeatureType4 = priorityFeatureType4;
   }

   public PriorityFeatureTypeEnum getPriorityFeatureType5() {
      return this.priorityFeatureType5;
   }

   public void setPriorityFeatureType5(final PriorityFeatureTypeEnum priorityFeatureType5) {
      this.priorityFeatureType5 = priorityFeatureType5;
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

   public JobPostingStatusTypeEnum getStatusType() {
      return this.statusType;
   }

   public void setStatusType(final JobPostingStatusTypeEnum statusType) {
      this.statusType = statusType;
   }

   public LocalDate getExpiryDate() {
      return this.expiryDate;
   }

   public void setExpiryDate(final LocalDate expiryDate) {
      this.expiryDate = expiryDate;
   }

   public Integer getCompensation() {
      return this.compensation;
   }

   public void setCompensation(final Integer compensation) {
      this.compensation = compensation;
   }

   public CompensationTypeEnum getCompensationType() {
      return this.compensationType;
   }

   public void setCompensationType(final CompensationTypeEnum compensationType) {
      this.compensationType = compensationType;
   }

   public String getState() {
      return this.state;
   }

   public void setState(final String state) {
      this.state = state;
   }

   @Override
   public int compareTo(final MedicalEmployerJobPosting o) {
//      if(o == null || o.getPostedDate() == null) {
//         return -1;
//      }
//      
//      if(this.postedDate == null) {
//         return 1;
//      }
//      return o.getPostedDate().compareTo(this.postedDate);
      if(o == null || o.getAssignmentFromDate() == null) {
         return -1;
      }
      
      if(this.getAssignmentFromDate() == null) {
         return 1;
      }
      return o.getAssignmentFromDate().compareTo(this.getAssignmentFromDate());
   }
}
