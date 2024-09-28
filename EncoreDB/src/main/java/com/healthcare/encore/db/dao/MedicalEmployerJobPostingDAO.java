package com.healthcare.encore.db.dao;

import java.time.LocalDate;
import java.util.List;

import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalEmployerJobPostingDAO extends BaseDAO<MedicalEmployerJobPostingDTO, Integer> {
   
   List<MedicalEmployerJobPostingDTO> findAll(UserDTO userDTO);
   
   List<MedicalEmployerJobPostingDTO> findByJobSeach(LocalDate date, String title, String speciality, String location);
}
