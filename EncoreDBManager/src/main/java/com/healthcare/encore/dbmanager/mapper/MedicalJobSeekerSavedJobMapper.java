/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.MedicalJobSeekerSavedJobsDAO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerSavedJobDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.MedicalJobSeekerSavedJob;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalJobSeekerSavedJobMapper extends AbstractMapper<MedicalJobSeekerSavedJobDTO, MedicalJobSeekerSavedJob> {

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   @Autowired
   private MedicalJobSeekerSavedJobsDAO savedJobsDAO;

   @Autowired
   private MedicalEmployerJobPostingMapper jobPostingMapper;

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerSavedJob getModel(final MedicalJobSeekerSavedJobDTO savedJobDTO) {
      MedicalJobSeekerSavedJob savedJob = new MedicalJobSeekerSavedJob();
      savedJob.setJobPostingId(savedJobDTO.getMedicalEmployerJobPostingDTO().getId());
      MedicalEmployerJobPosting jobPosting = this.jobPostingMapper.getModel(savedJobDTO.getMedicalEmployerJobPostingDTO());
      savedJob.setJobPostingDetails(jobPosting);
      savedJob.setSavedDate(savedJobDTO.getSavedDate());
      return savedJob;
   }

   public MedicalJobSeekerSavedJobDTO getDTO(final UserDTO jobSeekerUserDTO, final MedicalJobSeekerSavedJob savedJob) {
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(savedJob.getJobPostingId(), true);
      MedicalJobSeekerSavedJobDTO savedJobDTO = this.savedJobsDAO.findByJobPosting(jobSeekerUserDTO, jobPostingDTO);
      if (savedJobDTO == null) {
         savedJobDTO = new MedicalJobSeekerSavedJobDTO();
         savedJobDTO.setUserDTO(jobSeekerUserDTO);
         savedJobDTO.setMedicalEmployerJobPostingDTO(jobPostingDTO);
      }

      savedJobDTO.setSavedDate(savedJob.getSavedDate());
      jobPostingDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      return savedJobDTO;
   }
}
