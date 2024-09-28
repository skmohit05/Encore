package com.healthcare.encore.db.dto;

import java.io.Serializable;

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
 * The persistent class for the MedicalEmployerExtendedInfo database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
           name = "MedicalEmployerExtendedInfoDTO.findByUserId",
           query = "SELECT eei"
                    + " FROM MedicalEmployerExtendedInfoDTO eei"
                    + " LEFT JOIN FETCH eei.userDTO"
                    + " WHERE eei.userDTO.id=:userId",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Table(name = "MedicalEmployerExtendedInfo")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalEmployerExtendedInfoId", nullable = false))})
//@formatter:on
public class MedicalEmployerExtendedInfoDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private UserDTO userDTO;
   private String organizationRole;
   private String address1;
   private String address2;
   private String city;
   private String state;
   private String zip;
   private String phone;
   private Boolean malpracticeCandidateAcceptable;
   private Boolean boardActionsCandidateAcceptable;
   private Boolean disciplinaryActionCandidateAcceptable;
   private EnumJobTypeDTO jobTypeDTO;
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
   
   public String getOrganizationRole() {
      return this.organizationRole;
   }

   public void setOrganizationRole(final String organizationRole) {
      this.organizationRole = organizationRole;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalEmployerUserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO userDTO) {
      this.userDTO = userDTO;
   }

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

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "JobPreferenceTypeId")
   public EnumJobTypeDTO getJobTypeDTO() {
      return this.jobTypeDTO;
   }

   public void setJobTypeDTO(final EnumJobTypeDTO jobTypeDTO) {
      this.jobTypeDTO = jobTypeDTO;
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

   public Boolean isDisciplinaryActionCandidateAcceptable() {
      return this.disciplinaryActionCandidateAcceptable;
   }

   public void setDisciplinaryActionCandidateAcceptable(final Boolean disciplinaryActionCandidateAcceptable) {
      this.disciplinaryActionCandidateAcceptable = disciplinaryActionCandidateAcceptable;
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
