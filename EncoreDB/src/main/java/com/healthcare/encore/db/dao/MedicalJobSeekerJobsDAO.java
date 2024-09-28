package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.MedicalJobSeekerJobInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobsDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalJobSeekerJobsDAO extends BaseDAO<MedicalJobSeekerJobsDTO, Integer> {

   List<MedicalJobSeekerJobsDTO> findAll(UserDTO userDTO);
   
   MedicalJobSeekerJobsDTO findByJobInfo(UserDTO userDTO, MedicalJobSeekerJobInfoDTO jobInfoDTO);
}
