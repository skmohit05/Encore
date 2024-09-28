/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dto.MedicalJobSeekerJobInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobsDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.MedicalJobSeekerJobInfo;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalJobSeekerJobInfoMapper extends AbstractMapper<MedicalJobSeekerJobInfoDTO, MedicalJobSeekerJobInfo> {

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerJobInfo getModel(final MedicalJobSeekerJobInfoDTO jobInfoDTO) {
      MedicalJobSeekerJobInfo jobInfo = new MedicalJobSeekerJobInfo();
      jobInfo.setAssignmentFromDate(jobInfoDTO.getAssignmentFromDate());
      jobInfo.setAssignmentShiftType(this.enumMapperUtil.getModel(jobInfoDTO.getAssignmentShiftTypeDTO()));
      jobInfo.setAssignmentToDate(jobInfoDTO.getAssignmentToDate());
      jobInfo.setAssignmentType(this.enumMapperUtil.getModel(jobInfoDTO.getAssignmentTypeDTO()));
      jobInfo.setAvgPatientsInMonth(jobInfoDTO.getAvgPatientsInMonth());
      jobInfo.setBeds(jobInfoDTO.getBeds());
      jobInfo.setCity(jobInfoDTO.getCity());
      jobInfo.setCompensation(jobInfoDTO.getCompensation());
      jobInfo.setFacilityName(jobInfoDTO.getFacilityName());
      jobInfo.setFacilityType(this.enumMapperUtil.getModel(jobInfoDTO.getFacilityTypeDTO()));
      jobInfo.setMedicalJobSeekerJobInfoId(jobInfoDTO.getId());
      jobInfo.setNurses(jobInfoDTO.getNurses());
      jobInfo.setOrs(jobInfoDTO.getOrs());
      jobInfo.setPeers(jobInfoDTO.getPeers());
      jobInfo.setPlace(jobInfoDTO.getPlace());
      jobInfo.setSpeciality(jobInfoDTO.getSpeciality());
      jobInfo.setState(jobInfoDTO.getState());
      jobInfo.setSupervised(jobInfoDTO.isSupervised());
      jobInfo.setTitle(jobInfoDTO.getTitle());
      jobInfo.setTravel(jobInfoDTO.isTravel());
      jobInfo.setTravelHousingCoverage(jobInfoDTO.isTravelHousingCoverage());
      jobInfo.setFacilitySubType(this.enumMapperUtil.getModel(jobInfoDTO.getFacilitySubTypeDTO()));
      jobInfo.setOrganizationType(this.enumMapperUtil.getModel(jobInfoDTO.getOrganizationTypeDTO()));
      jobInfo.setZip(jobInfoDTO.getZip());
      return jobInfo;
   }

   public MedicalJobSeekerJobInfoDTO getDTO(final MedicalJobSeekerJobInfo jobInfo) {
      MedicalJobSeekerJobInfoDTO jobInfoDTO =
               this.setupMapperUtil.getMedicalJobSeekerJobInfoDTO(jobInfo.getMedicalJobSeekerJobInfoId());
      if (jobInfoDTO == null) {
         jobInfoDTO = new MedicalJobSeekerJobInfoDTO();
      }

      jobInfoDTO.setAssignmentFromDate(jobInfo.getAssignmentFromDate());
      jobInfoDTO.setAssignmentShiftTypeDTO(this.enumMapperUtil.getDTO(jobInfo.getAssignmentShiftType()));
      jobInfoDTO.setAssignmentToDate(jobInfo.getAssignmentToDate());
      jobInfoDTO.setAssignmentTypeDTO(this.enumMapperUtil.getDTO(jobInfo.getAssignmentType()));
      jobInfoDTO.setAvgPatientsInMonth(jobInfo.getAvgPatientsInMonth());
      jobInfoDTO.setBeds(jobInfo.getBeds());
      jobInfoDTO.setCity(jobInfo.getCity());
      jobInfoDTO.setCompensation(jobInfo.getCompensation());
      jobInfoDTO.setFacilityName(jobInfo.getFacilityName());
      jobInfoDTO.setFacilityTypeDTO(this.enumMapperUtil.getDTO(jobInfo.getFacilityType()));
      jobInfoDTO.setNurses(jobInfo.getNurses());
      jobInfoDTO.setOrs(jobInfo.getOrs());
      jobInfoDTO.setPeers(jobInfo.getPeers());
      jobInfoDTO.setPlace(jobInfo.getPlace());
      jobInfoDTO.setSpeciality(jobInfo.getSpeciality());
      jobInfoDTO.setState(jobInfo.getState());
      jobInfoDTO.setSupervised(jobInfo.isSupervised());
      jobInfoDTO.setTitle(jobInfo.getTitle());
      jobInfoDTO.setTravel(jobInfo.isTravel());
      jobInfoDTO.setTravelHousingCoverage(jobInfo.isTravelHousingCoverage());
      jobInfoDTO.setFacilitySubTypeDTO(this.enumMapperUtil.getDTO(jobInfo.getFacilitySubType()));
      jobInfoDTO.setZip(jobInfo.getZip());
      jobInfoDTO.setOrganizationTypeDTO(this.enumMapperUtil.getDTO(jobInfo.getOrganizationType()));
      jobInfoDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      return jobInfoDTO;
   }

   public List<MedicalJobSeekerJobInfo> getModels(final List<MedicalJobSeekerJobsDTO> jobsDTO) {
      List<MedicalJobSeekerJobInfo> jobInfos = new ArrayList<>();
      for (MedicalJobSeekerJobsDTO jobDTO : jobsDTO) {
         jobInfos.add(this.getModel(jobDTO.getMedicalJobSeekerJobInfoDTO()));
      }

      return jobInfos;
   }
}
