/**
 *
 */
package com.healthcare.encore.model;

/**
 * 
 * @author mmeena
 *
 */
public class Candidate extends BaseSetup implements Comparable<Candidate> {
   private Integer userId;
   private String name;
   private String location;
   private String title;
   private SpecialityTypeEnum specialityType;
   private Integer compensation;
   private Double rank;
   private MedicalJobSeekerExtendedInfo candidateDetails;
//   private Integer yearsExperience;

   public String getTitle() {
      return this.title;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public SpecialityTypeEnum getSpecialityType() {
      return this.specialityType;
   }

   public void setSpecialityType(final SpecialityTypeEnum specialityType) {
      this.specialityType = specialityType;
   }

   public Integer getCompensation() {
      return this.compensation;
   }

   public void setCompensation(final Integer compensation) {
      this.compensation = compensation;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public void setUserId(final Integer userId) {
      this.userId = userId;
   }

   public String getName() {
      return this.name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public String getLocation() {
      return this.location;
   }

   public void setLocation(final String location) {
      this.location = location;
   }

   public Double getRank() {
      return this.rank;
   }

   public void setRank(final Double rank) {
      this.rank = rank;
   }

   @Override
   public int compareTo(final Candidate candidate) {
      return -(this.getRank().compareTo(candidate.getRank()));
   }

   public MedicalJobSeekerExtendedInfo getCandidateDetails() {
      return this.candidateDetails;
   }

   public void setCandidateDetails(final MedicalJobSeekerExtendedInfo candidateDetails) {
      this.candidateDetails = candidateDetails;
   }

//   public Integer getYearsExperience() {
//      return this.yearsExperience;
//   }
//
//   public void setYearsExperience(final Integer yearsExperience) {
//      this.yearsExperience = yearsExperience;
//   }
}
