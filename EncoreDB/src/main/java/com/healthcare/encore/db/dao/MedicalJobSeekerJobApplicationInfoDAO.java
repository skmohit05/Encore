package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobApplicationInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalJobSeekerJobApplicationInfoDAO extends BaseDAO<MedicalJobSeekerJobApplicationInfoDTO, Integer> {

   List<MedicalJobSeekerJobApplicationInfoDTO> findAll(UserDTO jobSeekerUserDTO);

   MedicalJobSeekerJobApplicationInfoDTO findByJobPosting(UserDTO jobSeekerUserDTO, MedicalEmployerJobPostingDTO jobPostingDTO);
}
