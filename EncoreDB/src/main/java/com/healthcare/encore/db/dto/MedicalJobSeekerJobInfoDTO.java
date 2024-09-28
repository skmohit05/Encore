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
import javax.persistence.Table;

import com.healthcare.encore.db.audit.LogAuditInfo;
import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * The persistent class for the MedicalJobSeekerJobInfo database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@Entity
@Table(name = "MedicalJobSeekerJobInfo")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalJobSeekerJobInfoId", nullable = false))})
//@formatter:on
public class MedicalJobSeekerJobInfoDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

   private String title;
   private String speciality;
   private String place;
   private String facilityName;
   private EnumFacilityTypeDTO facilityTypeDTO;
   private EnumFacilitySubTypeDTO facilitySubTypeDTO;
   private EnumAssignmentTypeDTO assignmentTypeDTO;
   private EnumShiftTypeDTO assignmentShiftTypeDTO;
   private String city;
   private String state;
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
   private String zip;
   private EnumOrganizationTypeDTO organizationTypeDTO;
   
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
   
   public Integer getBeds() {
      return this.beds;
   }

   public void setBeds(final Integer beds) {
      this.beds = beds;
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

   public String getZip() {
      return this.zip;
   }

   public void setZip(final String zip) {
      this.zip = zip;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "OrganizationTypeId", nullable = false)
   public EnumOrganizationTypeDTO getOrganizationTypeDTO() {
      return this.organizationTypeDTO;
   }

   public void setOrganizationTypeDTO(final EnumOrganizationTypeDTO organizationTypeDTO) {
      this.organizationTypeDTO = organizationTypeDTO;
   }
}
