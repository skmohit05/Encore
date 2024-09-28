package com.healthcare.encore.db.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.healthcare.encore.db.audit.LogAuditInfo;
import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * The persistent class for the MedicalJobSeekerExtendedInfo database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
           name = "MedicalJobSeekerExtendedInfoDTO.findByUserId",
           query = "SELECT ucf"
                    + " FROM MedicalJobSeekerExtendedInfoDTO ucf"
                    + " LEFT JOIN FETCH ucf.userDTO"
                    + " WHERE ucf.userDTO.id=:userId",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
            name = "MedicalJobSeekerExtendedInfoDTO.findByCandidateSeach",
            query = "SELECT ucf"
                     + " FROM MedicalJobSeekerExtendedInfoDTO ucf"
                     + " WHERE (:title is null or ucf.title=:title)"
                     + "and (:state is null or ucf.state=:state)"
                     + "and (:specialityTypeDTO is null or ucf.specialityTypeDTO=:specialityTypeDTO)",
            hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) 
   })
@Entity
@Table(name = "MedicalJobSeekerExtendedInfo")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalJobSeekerExtendedInfoId", nullable = false))})
//@formatter:on
public class MedicalJobSeekerExtendedInfoDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private UserDTO userDTO;
   
   private String address1;
   
   private String address2;
   
   private String city;
   
   private String state;
   
   private String zip;
   
   private String title;
   
   private EnumSpecialityTypeDTO specialityTypeDTO;
   
   private Boolean malpractice;
   
   private Boolean boardActions;
   
   private Boolean disciplinaryActions;
   
   private Boolean lossOfPrivileges;
   
   private Boolean epicExperience;
   
   private String malpracticeInfo;
   
   private String boardActionsInfo;
   
   private String disciplinaryActionsInfo;
   
   private String lossOfPrivilegesInfo;
   
   private Integer epicExperienceYears;
   
   private EnumJobTypeDTO jobTypeDTO;
   
   private Boolean travel;
   
   private EnumUSStatesTypeDTO usStatesTypeDTO;
   
   private EnumShiftTypeDTO shiftTypeDTO;
   
   private Boolean callPreference;
   
   private Boolean governmentAssignment;
   
   private String additionalInformation1;
   
   private String additionalInformation2;
   
   private String additionalInformation3;
   
   private Boolean nPDB;
   
   private String nPDBInfo;
   
   private List<MedicalJobSeekerStateLevelInfoDTO> medicalJobSeekerStateLevelInfoDTOs = new ArrayList<>();
   
   private Integer compensation;
   
   private EnumCompensationTypeDTO compensationTypeDTO;

   private Integer yearsExperience;

   public String getAddress1() {
      return this.address1;
   }

   public void setAddress1(final String address1) {
      this.address1 = address1;
   }
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalJobSeekerUserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO userDTO) {
      this.userDTO = userDTO;
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

   public String getTitle() {
      return this.title;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "SpecialityTypeId", nullable = false)
   public EnumSpecialityTypeDTO getSpecialityTypeDTO() {
      return this.specialityTypeDTO;
   }

   public void setSpecialityTypeDTO(final EnumSpecialityTypeDTO specialityTypeDTO) {
      this.specialityTypeDTO = specialityTypeDTO;
   }

   public Boolean isMalpractice() {
      return this.malpractice;
   }

   public void setMalpractice(final Boolean malpractice) {
      this.malpractice = malpractice;
   }

   public Boolean isBoardActions() {
      return this.boardActions;
   }

   public void setBoardActions(final Boolean boardActions) {
      this.boardActions = boardActions;
   }

   public Boolean isDisciplinaryActions() {
      return this.disciplinaryActions;
   }

   public void setDisciplinaryActions(final Boolean disciplinaryActions) {
      this.disciplinaryActions = disciplinaryActions;
   }

   public String getMalpracticeInfo() {
      return this.malpracticeInfo;
   }

   public void setMalpracticeInfo(final String malpracticeInfo) {
      this.malpracticeInfo = malpracticeInfo;
   }

   public String getBoardActionsInfo() {
      return this.boardActionsInfo;
   }

   public void setBoardActionsInfo(final String boardActionsInfo) {
      this.boardActionsInfo = boardActionsInfo;
   }

   public String getDisciplinaryActionsInfo() {
      return this.disciplinaryActionsInfo;
   }

   public void setDisciplinaryActionsInfo(final String disciplinaryActionsInfo) {
      this.disciplinaryActionsInfo = disciplinaryActionsInfo;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "JobPreferenceTypeId", nullable = false)
   public EnumJobTypeDTO getJobTypeDTO() {
      return this.jobTypeDTO;
   }

   public void setJobTypeDTO(final EnumJobTypeDTO jobTypeDTO) {
      this.jobTypeDTO = jobTypeDTO;
   }

   public Boolean isTravel() {
      return this.travel;
   }

   public void setTravel(final Boolean travel) {
      this.travel = travel;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ShiftPreferenceTypeId", nullable = false)
   public EnumShiftTypeDTO getShiftTypeDTO() {
      return this.shiftTypeDTO;
   }

   public void setShiftTypeDTO(final EnumShiftTypeDTO shiftTypeDTO) {
      this.shiftTypeDTO = shiftTypeDTO;
   }

   public Boolean isCallPreference() {
      return this.callPreference;
   }

   public void setCallPreference(final Boolean callPreference) {
      this.callPreference = callPreference;
   }

   public Boolean isGovernmentAssignment() {
      return this.governmentAssignment;
   }

   public void setGovernmentAssignment(final Boolean governmentAssignment) {
      this.governmentAssignment = governmentAssignment;
   }

   public String getAdditionalInformation1() {
      return this.additionalInformation1;
   }

   public void setAdditionalInformation1(final String additionalInformation1) {
      this.additionalInformation1 = additionalInformation1;
   }

   public String getAdditionalInformation2() {
      return this.additionalInformation2;
   }

   public void setAdditionalInformation2(final String additionalInformation2) {
      this.additionalInformation2 = additionalInformation2;
   }

   public String getAdditionalInformation3() {
      return this.additionalInformation3;
   }

   public void setAdditionalInformation3(final String additionalInformation3) {
      this.additionalInformation3 = additionalInformation3;
   }

   public Boolean isLossOfPrivileges() {
      return this.lossOfPrivileges;
   }

   public void setLossOfPrivileges(final Boolean lossOfPrivileges) {
      this.lossOfPrivileges = lossOfPrivileges;
   }

   public Boolean isEpicExperience() {
      return this.epicExperience;
   }

   public void setEpicExperience(final Boolean epicExperience) {
      this.epicExperience = epicExperience;
   }

   public String getLossOfPrivilegesInfo() {
      return this.lossOfPrivilegesInfo;
   }

   public void setLossOfPrivilegesInfo(final String lossOfPrivilegesInfo) {
      this.lossOfPrivilegesInfo = lossOfPrivilegesInfo;
   }

   public Integer getEpicExperienceYears() {
      return this.epicExperienceYears;
   }

   public void setEpicExperienceYears(final Integer epicExperienceYears) {
      this.epicExperienceYears = epicExperienceYears;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "TravelStatePreferenceId", nullable = false)
   public EnumUSStatesTypeDTO getUsStatesTypeDTO() {
      return this.usStatesTypeDTO;
   }

   public void setUsStatesTypeDTO(final EnumUSStatesTypeDTO usStatesTypeDTO) {
      this.usStatesTypeDTO = usStatesTypeDTO;
   }

   @Column(name = "NPDB")
   public Boolean isNPDB() {
      return this.nPDB;
   }

   public void setNPDB(final Boolean nPDB) {
      this.nPDB = nPDB;
   }

   @Column(name = "NPDBInfo")
   public String getNPDBInfo() {
      return this.nPDBInfo;
   }

   public void setNPDBInfo(final String nPDBInfo) {
      this.nPDBInfo = nPDBInfo;
   }

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "medicalJobSeekerExtendedInfoDTO", cascade = CascadeType.ALL, orphanRemoval = true)
   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
   public List<MedicalJobSeekerStateLevelInfoDTO> getMedicalJobSeekerStateLevelInfoDTOs() {
      return this.medicalJobSeekerStateLevelInfoDTOs;
   }

   public void setMedicalJobSeekerStateLevelInfoDTOs(final List<MedicalJobSeekerStateLevelInfoDTO> medicalJobSeekerStateLevelInfoDTOs) {
      this.medicalJobSeekerStateLevelInfoDTOs = medicalJobSeekerStateLevelInfoDTOs;
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

   public Integer getYearsExperience() {
      return this.yearsExperience;
   }

   public void setYearsExperience(final Integer yearsExperience) {
      this.yearsExperience = yearsExperience;
   }
}
