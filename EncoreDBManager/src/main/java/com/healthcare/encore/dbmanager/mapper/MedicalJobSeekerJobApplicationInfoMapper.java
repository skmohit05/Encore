/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.MedicalJobSeekerJobApplicationInfoDAO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobApplicationInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.MedicalJobSeekerJobApplicationInfo;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalJobSeekerJobApplicationInfoMapper
         extends AbstractMapper<MedicalJobSeekerJobApplicationInfoDTO, MedicalJobSeekerJobApplicationInfo> {

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private MedicalJobSeekerJobApplicationInfoDAO jobApplicationInfoDAO;

   @Autowired
   private MedicalEmployerJobPostingMapper jobPostingMapper;

   @Override
   public MedicalJobSeekerJobApplicationInfo getModel(final MedicalJobSeekerJobApplicationInfoDTO jobApplicationDTO) {
      MedicalJobSeekerJobApplicationInfo jobApplication = new MedicalJobSeekerJobApplicationInfo();
      jobApplication.setJobPostingId(jobApplicationDTO.getMedicalEmployerJobPostingDTO().getId());
      jobApplication.setAccepted(jobApplicationDTO.isAccepted());
      jobApplication.setAppliedDate(jobApplicationDTO.getAppliedDate());
      jobApplication.setCompensation(jobApplicationDTO.getCompensation());
      jobApplication.setCompensationType(this.enumMapperUtil.getModel(jobApplicationDTO.getCompensationTypeDTO()));
      jobApplication.setEmployerJobAgreementSignedUserId(jobApplicationDTO.getEmployerJobAgreementSignedUserDTO().getId());
      jobApplication.setEndDate(jobApplicationDTO.getEndDate());
      jobApplication.setJobCompletedAsPerAgreement(jobApplicationDTO.isJobCompletedAsPerAgreement());
      jobApplication.setStartDate(jobApplicationDTO.getStartDate());

      MedicalEmployerJobPosting jobPosting = this.jobPostingMapper.getModel(jobApplicationDTO.getMedicalEmployerJobPostingDTO());
      jobApplication.setJobPostingDetails(jobPosting);
      return jobApplication;
   }

   public MedicalJobSeekerJobApplicationInfoDTO getDTO(final UserDTO jobSeekerUserDTO,
            final MedicalJobSeekerJobApplicationInfo jobApplicationInfo) {
      Integer jobPostingId = jobApplicationInfo.getJobPostingId();
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPostingId, true);
      MedicalJobSeekerJobApplicationInfoDTO jobApplicationDTO = this.jobApplicationInfoDAO.findByJobPosting(jobSeekerUserDTO,
               jobPostingDTO);
      if (jobApplicationDTO == null) {
         jobApplicationDTO = new MedicalJobSeekerJobApplicationInfoDTO();
         jobApplicationDTO.setUserDTO(jobSeekerUserDTO);
         jobApplicationDTO.setMedicalEmployerJobPostingDTO(jobPostingDTO);
      }

      jobApplicationDTO.setAccepted(jobApplicationInfo.isAccepted());
      jobApplicationDTO.setAppliedDate(jobApplicationInfo.getAppliedDate());
      jobApplicationDTO.setCompensation(jobApplicationInfo.getCompensation());
      jobApplicationDTO.setCompensationTypeDTO(this.enumMapperUtil.getDTO(jobApplicationInfo.getCompensationType()));
      jobApplicationDTO.setEmployerJobAgreementSignedUserDTO(jobPostingDTO.getUserDTO());
      jobApplicationDTO.setEndDate(jobApplicationInfo.getEndDate());
      jobApplicationDTO.setJobCompletedAsPerAgreement(jobApplicationInfo.isJobCompletedAsPerAgreement());
      jobApplicationDTO.setUserDTO(jobSeekerUserDTO);
      jobApplicationDTO.setStartDate(jobApplicationInfo.getStartDate());
      jobPostingDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      return jobApplicationDTO;
   }
}
