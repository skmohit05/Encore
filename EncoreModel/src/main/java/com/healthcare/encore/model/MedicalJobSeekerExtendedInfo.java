/**
 *
 */
package com.healthcare.encore.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author mmeena
 *
 */
public class MedicalJobSeekerExtendedInfo extends BaseSetup {

   @NotBlank(message = "address1 cannot be blank or null")
   private String address1;

   private String address2;

   @NotBlank(message = "city cannot be blank or null")
   private String city;

   @NotBlank(message = "state cannot be blank or null")
   private String state;

   @NotBlank(message = "zip cannot be blank or null")
   private String zip;

   @NotBlank(message = "title cannot be blank or null")
   private String title;

   @NotNull(message = "specialityType cannot be blank or null")
   private SpecialityTypeEnum specialityType;

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

   @NotNull(message = "jobPreferenceType cannot be blank or null")
   private JobTypeEnum jobPreferenceType;

   private Boolean travel;
   
   private USStatesTypeEnum travelStatePreference;

   @NotNull(message = "shiftPreferenceType cannot be blank or null")
   private ShiftTypeEnum shiftPreferenceType;

   private Boolean callPreference;

   private Boolean governmentAssignment;

   private String additionalInformation1;

   private String additionalInformation2;

   private String additionalInformation3;
   
   private Boolean npdb;
   
   private String npdbInfo;
   
   private Integer compensation;
   
   private CompensationTypeEnum compensationType;

   private Integer yearsExperience;
   
   private Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> stateLevelInfo = new HashMap<>();

   public String getAddress2() {
      return this.address2;
   }

   public void setAddress2(final String address2) {
      this.address2 = address2;
   }
   
   public String getAddress1() {
      return this.address1;
   }

   public void setAddress1(final String address1) {
      this.address1 = address1;
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

   public SpecialityTypeEnum getSpecialityType() {
      return this.specialityType;
   }

   public void setSpecialityType(final SpecialityTypeEnum specialityType) {
      this.specialityType = specialityType;
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

   public JobTypeEnum getJobPreferenceType() {
      return this.jobPreferenceType;
   }

   public void setJobPreferenceType(final JobTypeEnum jobPreferenceType) {
      this.jobPreferenceType = jobPreferenceType;
   }

   public Boolean isTravel() {
      return this.travel;
   }

   public Boolean isNpdb() {
      return this.npdb;
   }

   public void setNpdb(final Boolean npdb) {
      this.npdb = npdb;
   }

   public String getNpdbInfo() {
      return this.npdbInfo;
   }

   public void setNpdbInfo(final String npdbInfo) {
      this.npdbInfo = npdbInfo;
   }

   public void setTravel(final Boolean travel) {
      this.travel = travel;
   }

   public ShiftTypeEnum getShiftPreferenceType() {
      return this.shiftPreferenceType;
   }

   public void setShiftPreferenceType(final ShiftTypeEnum shiftPreferenceType) {
      this.shiftPreferenceType = shiftPreferenceType;
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

   public Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> getStateLevelInfo() {
      return this.stateLevelInfo;
   }

   public void setStateLevelInfo(final Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> stateLevelInfo) {
      this.stateLevelInfo = stateLevelInfo;
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

   public Integer getYearsExperience() {
      return this.yearsExperience;
   }

   public void setYearsExperience(final Integer yearsExperience) {
      this.yearsExperience = yearsExperience;
   }

   public USStatesTypeEnum getTravelStatePreference() {
      return this.travelStatePreference;
   }

   public void setTravelStatePreference(final USStatesTypeEnum travelStatePreference) {
      this.travelStatePreference = travelStatePreference;
   }
}
