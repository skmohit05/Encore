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
public class MedicalJobSeekerSavedJob {

   private Integer jobPostingId;
   
   private MedicalEmployerJobPosting jobPostingDetails;

   private LocalDate savedDate;

   public Integer getJobPostingId() {
      return this.jobPostingId;
   }

   public void setJobPostingId(final Integer jobPostingId) {
      this.jobPostingId = jobPostingId;
   }

   public LocalDate getSavedDate() {
      return this.savedDate;
   }

   public void setSavedDate(final LocalDate savedDate) {
      this.savedDate = savedDate;
   }

   public MedicalEmployerJobPosting getJobPostingDetails() {
      return this.jobPostingDetails;
   }

   public void setJobPostingDetails(final MedicalEmployerJobPosting jobPostingDetails) {
      this.jobPostingDetails = jobPostingDetails;
   }
}
