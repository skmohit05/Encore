package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumSpecialityTypeDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalJobSeekerExtendedInfoDAO extends BaseDAO<MedicalJobSeekerExtendedInfoDTO, Integer> {

   MedicalJobSeekerExtendedInfoDTO findByUser(UserDTO userDTO);

   List<MedicalJobSeekerExtendedInfoDTO> findByCandidateSeach(String title, EnumSpecialityTypeDTO specialityTypeDTO, String location);
}
