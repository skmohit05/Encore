/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.MedicalJobSeekerExtendedInfoDAO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerStateLevelInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.Candidate;
import com.healthcare.encore.model.MedicalJobSeekerExtendedInfo;
import com.healthcare.encore.model.MedicalJobSeekerStateLevelInfo;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalJobSeekerExtendedInfoMapper extends AbstractMapper<MedicalJobSeekerExtendedInfoDTO, MedicalJobSeekerExtendedInfo> {

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private MedicalJobSeekerExtendedInfoDAO extInfoDAO;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   @Autowired
   private MedicalJobSeekerStateLevelInfoMapper stateLevelInfoMapper;

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerExtendedInfo getModel(final MedicalJobSeekerExtendedInfoDTO extInfoDTO) {
      MedicalJobSeekerExtendedInfo extInfo = new MedicalJobSeekerExtendedInfo();
      extInfo.setAdditionalInformation1(extInfoDTO.getAdditionalInformation1());
      extInfo.setAdditionalInformation2(extInfoDTO.getAdditionalInformation2());
      extInfo.setAdditionalInformation3(extInfoDTO.getAdditionalInformation3());
      extInfo.setAddress1(extInfoDTO.getAddress1());
      extInfo.setAddress2(extInfoDTO.getAddress2());
      extInfo.setBoardActions(extInfoDTO.isBoardActions());
      extInfo.setBoardActionsInfo(extInfoDTO.getBoardActionsInfo());
      extInfo.setCallPreference(extInfoDTO.isCallPreference());
      extInfo.setCity(extInfoDTO.getCity());
      extInfo.setDisciplinaryActions(extInfoDTO.isDisciplinaryActions());
      extInfo.setDisciplinaryActionsInfo(extInfoDTO.getDisciplinaryActionsInfo());
      extInfo.setGovernmentAssignment(extInfoDTO.isGovernmentAssignment());
      extInfo.setJobPreferenceType(this.enumMapperUtil.getModel(extInfoDTO.getJobTypeDTO()));
      extInfo.setMalpractice(extInfoDTO.isMalpractice());
      extInfo.setMalpracticeInfo(extInfoDTO.getMalpracticeInfo());
      extInfo.setShiftPreferenceType(this.enumMapperUtil.getModel(extInfoDTO.getShiftTypeDTO()));
      extInfo.setSpecialityType(this.enumMapperUtil.getModel(extInfoDTO.getSpecialityTypeDTO()));
      extInfo.setState(extInfoDTO.getState());
      extInfo.setTitle(extInfoDTO.getTitle());
      extInfo.setTravel(extInfoDTO.isTravel());
      extInfo.setZip(extInfoDTO.getZip());
      extInfo.setLossOfPrivileges(extInfoDTO.isLossOfPrivileges());
      extInfo.setEpicExperience(extInfoDTO.isEpicExperience());
      extInfo.setLossOfPrivilegesInfo(extInfoDTO.getLossOfPrivilegesInfo());
      extInfo.setEpicExperienceYears(extInfoDTO.getEpicExperienceYears());
      extInfo.setTravelStatePreference(this.enumMapperUtil.getModel(extInfoDTO.getUsStatesTypeDTO()));
      extInfo.setNpdb(extInfoDTO.isNPDB());
      extInfo.setNpdbInfo(extInfoDTO.getNPDBInfo());
      extInfo.setStateLevelInfo(this.stateLevelInfoMapper.getJobSeekerStateLevelInfo(extInfoDTO));
      extInfo.setCompensation(extInfoDTO.getCompensation());
      extInfo.setCompensationType(this.enumMapperUtil.getModel(extInfoDTO.getCompensationTypeDTO()));
      extInfo.setYearsExperience(extInfoDTO.getYearsExperience());
      return extInfo;
   }

   public Candidate getCandidateModel(final MedicalJobSeekerExtendedInfoDTO extInfoDTO) {
      Candidate candidate = new Candidate();
      candidate.setSpecialityType(this.enumMapperUtil.getModel(extInfoDTO.getSpecialityTypeDTO()));
      candidate.setLocation(extInfoDTO.getState());
      candidate.setTitle(extInfoDTO.getTitle());
      candidate.setCompensation(extInfoDTO.getCompensation());
      candidate.setUserId(extInfoDTO.getUserDTO().getId());
      String lastName = extInfoDTO.getUserDTO().getLastName() != null ? " " + extInfoDTO.getUserDTO().getLastName() : StringUtils.EMPTY;
      candidate.setName(extInfoDTO.getUserDTO().getFirstName() + lastName);
      candidate.setCandidateDetails(this.getModel(extInfoDTO));

      // candidate.setYearsExperience(extInfoDTO.getYearsExperience());
      return candidate;
   }

   public MedicalJobSeekerExtendedInfoDTO getDTO(final int userId, final MedicalJobSeekerExtendedInfo extInfo) {
      MedicalJobSeekerExtendedInfoDTO extInfoDTO = this.getDTO(userId);
      extInfoDTO.setAdditionalInformation1(extInfo.getAdditionalInformation1());
      extInfoDTO.setAdditionalInformation2(extInfo.getAdditionalInformation2());
      extInfoDTO.setAdditionalInformation3(extInfo.getAdditionalInformation3());
      extInfoDTO.setAddress1(extInfo.getAddress1());
      extInfoDTO.setAddress2(extInfo.getAddress2());
      extInfoDTO.setBoardActions(extInfo.isBoardActions());
      extInfoDTO.setBoardActionsInfo(extInfo.getBoardActionsInfo());
      extInfoDTO.setCallPreference(extInfo.isCallPreference());
      extInfoDTO.setCity(extInfo.getCity());
      extInfoDTO.setDisciplinaryActions(extInfo.isDisciplinaryActions());
      extInfoDTO.setDisciplinaryActionsInfo(extInfo.getDisciplinaryActionsInfo());
      extInfoDTO.setGovernmentAssignment(extInfo.isGovernmentAssignment());
      extInfoDTO.setJobTypeDTO(this.enumMapperUtil.getDTO(extInfo.getJobPreferenceType()));
      extInfoDTO.setMalpractice(extInfo.isMalpractice());
      extInfoDTO.setMalpracticeInfo(extInfo.getMalpracticeInfo());
      extInfoDTO.setShiftTypeDTO(this.enumMapperUtil.getDTO(extInfo.getShiftPreferenceType()));
      extInfoDTO.setSpecialityTypeDTO(this.enumMapperUtil.getDTO(extInfo.getSpecialityType()));
      extInfoDTO.setState(extInfo.getState());
      extInfoDTO.setTitle(extInfo.getTitle());
      extInfoDTO.setTravel(extInfo.isTravel());
      extInfoDTO.setZip(extInfo.getZip());
      extInfoDTO.setLossOfPrivileges(extInfo.isLossOfPrivileges());
      extInfoDTO.setEpicExperience(extInfo.isEpicExperience());
      extInfoDTO.setLossOfPrivilegesInfo(extInfo.getLossOfPrivilegesInfo());
      extInfoDTO.setEpicExperienceYears(extInfo.getEpicExperienceYears());
      if(extInfo.getTravelStatePreference() != null) {
         extInfoDTO.setUsStatesTypeDTO(this.enumMapperUtil.getDTO(extInfo.getTravelStatePreference()));
      }
      extInfoDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      extInfoDTO.setNPDB(extInfo.isNpdb());
      extInfoDTO.setNPDBInfo(extInfo.getNpdbInfo());

      Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> stateLevelsInfo = extInfo.getStateLevelInfo();
      extInfoDTO.getMedicalJobSeekerStateLevelInfoDTOs().clear();
      for (Map.Entry<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> entry : stateLevelsInfo.entrySet()) {
         MedicalJobSeekerStateLevelInfoDTO stateLevelInfoDTO = this.stateLevelInfoMapper.getDTO(extInfoDTO, entry.getKey(),
                  entry.getValue());
         extInfoDTO.getMedicalJobSeekerStateLevelInfoDTOs().add(stateLevelInfoDTO);
      }
      
      extInfoDTO.setCompensation(extInfo.getCompensation());
      extInfoDTO.setCompensationTypeDTO(this.enumMapperUtil.getDTO(extInfo.getCompensationType()));
      extInfoDTO.setYearsExperience(extInfo.getYearsExperience());
      return extInfoDTO;
   }
   
   private MedicalJobSeekerExtendedInfoDTO getDTO(final int userId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(userId, true);
      MedicalJobSeekerExtendedInfoDTO extInfoDTO = this.extInfoDAO.findByUser(userDTO);
      if (extInfoDTO == null) {
         extInfoDTO = new MedicalJobSeekerExtendedInfoDTO();
         extInfoDTO.setUserDTO(userDTO);
      }
      
      return extInfoDTO;
   }
}
