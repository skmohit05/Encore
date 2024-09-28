/**
 *
 */
package com.healthcare.encore.model;

import javax.validation.constraints.NotBlank;

/**
 * 
 * @author mmeena
 *
 */
public class MedicalEmployerExtendedInfo {

   @NotBlank(message = "organizationRole cannot be blank or null")
   private String organizationRole;

   @NotBlank(message = "address1 cannot be blank or null")
   private String address1;

   private String address2;

   @NotBlank(message = "city cannot be blank or null")
   private String city;

   @NotBlank(message = "state cannot be blank or null")
   private String state;

   @NotBlank(message = "zip cannot be blank or null")
   private String zip;

   @NotBlank(message = "phone cannot be blank or null")
   private String phone;

   private Boolean malpracticeCandidateAcceptable;

   private Boolean boardActionsCandidateAcceptable;

   private Boolean disciplinaryActionsCandidateAcceptable;

   private JobTypeEnum jobPreferenceType;

   private Boolean governmentAssignment;

   private Integer beds;

   private Integer avgPatientsInMonth;

   private Integer peers;

   private Integer nurses;

   private Integer ors;

   private Boolean malpracticeCoverage;

   private Boolean credentialingCoverage;

   private Boolean licenseCoverage;

   private Boolean travelHousingCoverage;

   public String getAddress1() {
      return this.address1;
   }

   public void setAddress1(final String address1) {
      this.address1 = address1;
   }

   public String getAddress2() {
      return this.address2;
   }

   public void setAddress2(final String address2) {
      this.address2 = address2;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(final String city) {
      this.city = city;
   }

   public String getState() {
      return this.state;
   }

   public void setState(final String state) {
      this.state = state;
   }

   public String getZip() {
      return this.zip;
   }

   public void setZip(final String zip) {
      this.zip = zip;
   }

   public JobTypeEnum getJobPreferenceType() {
      return this.jobPreferenceType;
   }

   public void setJobPreferenceType(final JobTypeEnum jobPreferenceType) {
      this.jobPreferenceType = jobPreferenceType;
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

   public Boolean isLicenseCoverage() {
      return this.licenseCoverage;
   }

   public void setLicenseCoverage(final Boolean licenseCoverage) {
      this.licenseCoverage = licenseCoverage;
   }

   public Boolean isTravelHousingCoverage() {
      return this.travelHousingCoverage;
   }

   public void setTravelHousingCoverage(final Boolean travelHousingCoverage) {
      this.travelHousingCoverage = travelHousingCoverage;
   }

   public Boolean isGovernmentAssignment() {
      return this.governmentAssignment;
   }

   public void setGovernmentAssignment(final Boolean governmentAssignment) {
      this.governmentAssignment = governmentAssignment;
   }

   public String getOrganizationRole() {
      return this.organizationRole;
   }

   public void setOrganizationRole(final String organizationRole) {
      this.organizationRole = organizationRole;
   }

   public String getPhone() {
      return this.phone;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public Boolean isMalpracticeCandidateAcceptable() {
      return this.malpracticeCandidateAcceptable;
   }

   public void setMalpracticeCandidateAcceptable(final Boolean malpracticeCandidateAcceptable) {
      this.malpracticeCandidateAcceptable = malpracticeCandidateAcceptable;
   }

   public Boolean isBoardActionsCandidateAcceptable() {
      return this.boardActionsCandidateAcceptable;
   }

   public void setBoardActionsCandidateAcceptable(final Boolean boardActionsCandidateAcceptable) {
      this.boardActionsCandidateAcceptable = boardActionsCandidateAcceptable;
   }

   public Boolean isDisciplinaryActionsCandidateAcceptable() {
      return this.disciplinaryActionsCandidateAcceptable;
   }

   public void setDisciplinaryActionsCandidateAcceptable(final Boolean disciplinaryActionsCandidateAcceptable) {
      this.disciplinaryActionsCandidateAcceptable = disciplinaryActionsCandidateAcceptable;
   }

   public Integer getBeds() {
      return this.beds;
   }

   public void setBeds(final Integer beds) {
      this.beds = beds;
   }

   public Integer getAvgPatientsInMonth() {
      return this.avgPatientsInMonth;
   }

   public void setAvgPatientsInMonth(final Integer avgPatientsInMonth) {
      this.avgPatientsInMonth = avgPatientsInMonth;
   }

   public Integer getPeers() {
      return this.peers;
   }

   public void setPeers(final Integer peers) {
      this.peers = peers;
   }

   public Integer getNurses() {
      return this.nurses;
   }

   public void setNurses(final Integer nurses) {
      this.nurses = nurses;
   }

   public Integer getOrs() {
      return this.ors;
   }

   public void setOrs(final Integer ors) {
      this.ors = ors;
   }
}
