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
public class MedicalJobSeekerJobInfo implements Comparable<MedicalJobSeekerJobInfo> {

   private Integer medicalJobSeekerJobInfoId;

   private String title;

   private String speciality;

   private String place;

   private String facilityName;

   private FacilityTypeEnum facilityType;
   
   private FacilitySubTypeEnum facilitySubType;

   private AssignmentTypeEnum assignmentType;

   private ShiftTypeEnum assignmentShiftType;

   private String city;

   private String state;

   private String zip;

   private LocalDate assignmentFromDate;

   private LocalDate assignmentToDate;

   private Integer beds;

   private Integer avgPatientsInMonth;

   private Integer peers;

   private Integer nurses;

   private Integer ors;

   private Boolean supervised;

   private Integer compensation;

   private Boolean travel;

   private Boolean travelHousingCoverage;

   private OrganizationTypeEnum organizationType;

   public Integer getMedicalJobSeekerJobInfoId() {
      return this.medicalJobSeekerJobInfoId;
   }

   public void setMedicalJobSeekerJobInfoId(final Integer medicalJobSeekerJobInfoId) {
      this.medicalJobSeekerJobInfoId = medicalJobSeekerJobInfoId;
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

   public String getPlace() {
      return this.place;
   }

   public void setPlace(final String place) {
      this.place = place;
   }

   public String getFacilityName() {
      return this.facilityName;
   }

   public void setFacilityName(final String facilityName) {
      this.facilityName = facilityName;
   }

   public FacilityTypeEnum getFacilityType() {
      return this.facilityType;
   }

   public void setFacilityType(final FacilityTypeEnum facilityType) {
      this.facilityType = facilityType;
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

   public void setAssignmentShiftType(final ShiftTypeEnum assignmentShift) {
      this.assignmentShiftType = assignmentShift;
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

   public Boolean isSupervised() {
      return this.supervised;
   }

   public void setSupervised(final Boolean supervised) {
      this.supervised = supervised;
   }

   public Integer getCompensation() {
      return this.compensation;
   }

   public void setCompensation(final Integer compensation) {
      this.compensation = compensation;
   }

   public Boolean isTravel() {
      return this.travel;
   }

   public void setTravel(final Boolean travel) {
      this.travel = travel;
   }

   public Boolean isTravelHousingCoverage() {
      return this.travelHousingCoverage;
   }

   public void setTravelHousingCoverage(final Boolean travelHousingCoverage) {
      this.travelHousingCoverage = travelHousingCoverage;
   }
   
   public Integer getBeds() {
      return this.beds;
   }

   public void setBeds(final Integer beds) {
      this.beds = beds;
   }

   public FacilitySubTypeEnum getFacilitySubType() {
      return this.facilitySubType;
   }

   public void setFacilitySubType(final FacilitySubTypeEnum facilitySubType) {
      this.facilitySubType = facilitySubType;
   }

   public OrganizationTypeEnum getOrganizationType() {
      return this.organizationType;
   }

   public void setOrganizationType(final OrganizationTypeEnum organizationType) {
      this.organizationType = organizationType;
   }

   @Override
   public int compareTo(final MedicalJobSeekerJobInfo o) {
      Integer val;
      if (this.getAssignmentToDate() == null && o.getAssignmentToDate() == null) {
         val = this.getAssignmentFromDate().compareTo(o.getAssignmentFromDate());
      } else if (this.getAssignmentToDate() == null) {
         val = 1;
      } else if (o.getAssignmentToDate() == null) {
         val = -1;
      } else {
         val = this.getAssignmentToDate().compareTo(o.getAssignmentToDate());
      }
      
      return val;
   }

}
