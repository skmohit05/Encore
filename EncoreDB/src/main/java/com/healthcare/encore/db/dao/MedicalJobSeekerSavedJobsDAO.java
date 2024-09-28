package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerSavedJobDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalJobSeekerSavedJobsDAO extends BaseDAO<MedicalJobSeekerSavedJobDTO, Integer> {

   List<MedicalJobSeekerSavedJobDTO> findAll(UserDTO jobSeekerUserDTO);
   
   MedicalJobSeekerSavedJobDTO findByJobPosting(UserDTO jobSeekerUserDTO, MedicalEmployerJobPostingDTO jobPostingDTO);
}
