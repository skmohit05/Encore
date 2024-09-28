/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.MedicalEmployerJobPosting;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalEmployerJobPostingMapper extends AbstractMapper<MedicalEmployerJobPostingDTO, MedicalEmployerJobPosting> {

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
   public MedicalEmployerJobPosting getModel(final MedicalEmployerJobPostingDTO jobPostingDTO) {
      MedicalEmployerJobPosting jobPosting = new MedicalEmployerJobPosting();

      jobPosting.setMedicalEmployerJobPostingId(jobPostingDTO.getId());
      jobPosting.setTitle(jobPostingDTO.getTitle());
      jobPosting.setSpeciality(jobPostingDTO.getSpeciality());
      jobPosting.setAssignmentType(this.enumMapperUtil.getModel(jobPostingDTO.getAssignmentTypeDTO()));
      jobPosting.setAssignmentShiftType(this.enumMapperUtil.getModel(jobPostingDTO.getAssignmentShiftTypeDTO()));
      jobPosting.setSupervised(jobPostingDTO.isSupervised());
      jobPosting.setPrescriptionAuthorityNeeded(jobPostingDTO.isPrescriptionAuthorityNeeded());
      jobPosting.setAssignmentFromDate(jobPostingDTO.getAssignmentFromDate());
      jobPosting.setAssignmentToDate(jobPostingDTO.getAssignmentToDate());
      jobPosting.setCompensationRange(jobPostingDTO.getCompensationRange());
      jobPosting.setMalpracticeAccepted(jobPostingDTO.isMalpracticeAccepted());
      jobPosting.setMalpracticeCoverage(jobPostingDTO.isMalpracticeCoverage());
      jobPosting.setCredentialingCoverage(jobPostingDTO.isCredentialingCoverage());
      jobPosting.setLicensingCoverage(jobPostingDTO.isLicenseCoverage());
      jobPosting.setTravelHousingCoverage(jobPostingDTO.isTravelHousingCoverage());
      jobPosting.setYearsExperience(jobPostingDTO.getYearsExperience());
      jobPosting.setPostedDate(jobPostingDTO.getPostedDate());
      jobPosting.setUpdatedDate(jobPostingDTO.getUpdatedDate());
      jobPosting.setStatusType(this.enumMapperUtil.getModel(jobPostingDTO.getStatusTypeDTO()));
      jobPosting.setExpiryDate(jobPostingDTO.getExpiryDate());
      jobPosting.setPriorityFeatureType1(this.enumMapperUtil.getModel(jobPostingDTO.getPriorityFeatureTypeDTO1()));
      jobPosting.setPriorityFeatureType2(this.enumMapperUtil.getModel(jobPostingDTO.getPriorityFeatureTypeDTO2()));
      jobPosting.setPriorityFeatureType3(this.enumMapperUtil.getModel(jobPostingDTO.getPriorityFeatureTypeDTO3()));
      jobPosting.setPriorityFeatureType4(this.enumMapperUtil.getModel(jobPostingDTO.getPriorityFeatureTypeDTO4()));
      jobPosting.setPriorityFeatureType5(this.enumMapperUtil.getModel(jobPostingDTO.getPriorityFeatureTypeDTO5()));
      jobPosting.setJobDescription(jobPostingDTO.getJobDescription());
      jobPosting.setCompensation(jobPostingDTO.getCompensation());
      jobPosting.setCompensationType(this.enumMapperUtil.getModel(jobPostingDTO.getCompensationTypeDTO()));
      jobPosting.setState(jobPostingDTO.getState());
      if(jobPostingDTO.getUserDTO().getOrganizationDTO() != null) {
         jobPosting.setOrganizationName(jobPostingDTO.getUserDTO().getOrganizationDTO().getOrganizationName());
      }
      return jobPosting;
   }

   public MedicalEmployerJobPostingDTO getDTO(final MedicalEmployerJobPosting jobPosting, final UserDTO userDTO) {
      MedicalEmployerJobPostingDTO jobPostingDTO =
               this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPosting.getMedicalEmployerJobPostingId(), true);
      if (jobPostingDTO == null) {
         jobPostingDTO = new MedicalEmployerJobPostingDTO();
         jobPostingDTO.setUserDTO(userDTO);
      }

      jobPostingDTO.setTitle(jobPosting.getTitle());
      jobPostingDTO.setSpeciality(jobPosting.getSpeciality());
      jobPostingDTO.setAssignmentTypeDTO(this.enumMapperUtil.getDTO(jobPosting.getAssignmentType()));
      jobPostingDTO.setAssignmentShiftTypeDTO(this.enumMapperUtil.getDTO(jobPosting.getAssignmentShiftType()));
      jobPostingDTO.setSupervised(jobPosting.isSupervised());
      jobPostingDTO.setPrescriptionAuthorityNeeded(jobPosting.isPrescriptionAuthorityNeeded());
      jobPostingDTO.setAssignmentFromDate(jobPosting.getAssignmentFromDate());
      jobPostingDTO.setAssignmentToDate(jobPosting.getAssignmentToDate());
      jobPostingDTO.setCompensationRange(jobPosting.getCompensationRange());
      jobPostingDTO.setMalpracticeAccepted(jobPosting.isMalpracticeAccepted());
      jobPostingDTO.setMalpracticeCoverage(jobPosting.isMalpracticeCoverage());
      jobPostingDTO.setCredentialingCoverage(jobPosting.isCredentialingCoverage());
      jobPostingDTO.setLicenseCoverage(jobPosting.isLicensingCoverage());
      jobPostingDTO.setTravelHousingCoverage(jobPosting.isTravelHousingCoverage());
      jobPostingDTO.setYearsExperience(jobPosting.getYearsExperience());
      jobPostingDTO.setPostedDate(jobPosting.getPostedDate());
      jobPostingDTO.setUpdatedDate(jobPosting.getUpdatedDate());
      jobPostingDTO.setExpiryDate(jobPosting.getExpiryDate());
      jobPostingDTO.setStatusTypeDTO(this.enumMapperUtil.getDTO(jobPosting.getStatusType()));
      jobPostingDTO.setPriorityFeatureTypeDTO1(this.enumMapperUtil.getDTO(jobPosting.getPriorityFeatureType1()));
      jobPostingDTO.setPriorityFeatureTypeDTO2(this.enumMapperUtil.getDTO(jobPosting.getPriorityFeatureType2()));
      jobPostingDTO.setPriorityFeatureTypeDTO3(this.enumMapperUtil.getDTO(jobPosting.getPriorityFeatureType3()));
      jobPostingDTO.setPriorityFeatureTypeDTO4(this.enumMapperUtil.getDTO(jobPosting.getPriorityFeatureType4()));
      jobPostingDTO.setPriorityFeatureTypeDTO5(this.enumMapperUtil.getDTO(jobPosting.getPriorityFeatureType5()));
      jobPostingDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      jobPostingDTO.setJobDescription(jobPosting.getJobDescription());
      jobPostingDTO.setCompensation(jobPosting.getCompensation());
      jobPostingDTO.setCompensationTypeDTO(this.enumMapperUtil.getDTO(jobPosting.getCompensationType()));
      jobPostingDTO.setState(jobPosting.getState());
      return jobPostingDTO;
   }
}
