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
public class MedicalJobSeekerJobApplicationInfo {

   private Integer jobPostingId;
   
   private MedicalEmployerJobPosting jobPostingDetails;

   private LocalDate appliedDate;

   private boolean accepted;

   private LocalDate startDate;

   private LocalDate endDate;

   private Integer compensation;

   private CompensationTypeEnum compensationType;

   private boolean jobCompletedAsPerAgreement;

   private int employerJobAgreementSignedUserId;

   public Integer getJobPostingId() {
      return this.jobPostingId;
   }

   public void setJobPostingId(final Integer jobPostingId) {
      this.jobPostingId = jobPostingId;
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

   public boolean isJobCompletedAsPerAgreement() {
      return this.jobCompletedAsPerAgreement;
   }

   public void setJobCompletedAsPerAgreement(final boolean jobCompletedAsPerAgreement) {
      this.jobCompletedAsPerAgreement = jobCompletedAsPerAgreement;
   }

   public int getEmployerJobAgreementSignedUserId() {
      return this.employerJobAgreementSignedUserId;
   }

   public void setEmployerJobAgreementSignedUserId(final int employerJobAgreementSignedUserId) {
      this.employerJobAgreementSignedUserId = employerJobAgreementSignedUserId;
   }

   public MedicalEmployerJobPosting getJobPostingDetails() {
      return this.jobPostingDetails;
   }

   public void setJobPostingDetails(final MedicalEmployerJobPosting jobPostingDetails) {
      this.jobPostingDetails = jobPostingDetails;
   }
}
