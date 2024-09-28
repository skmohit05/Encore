package com.healthcare.encore.db.dao;

import java.util.List;

import com.healthcare.encore.db.dto.EnumUSStatesTypeDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerStateLevelInfoDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalJobSeekerStateLevelInfoDAO extends BaseDAO<MedicalJobSeekerStateLevelInfoDTO, Integer> {

   List<MedicalJobSeekerStateLevelInfoDTO> findAll(MedicalJobSeekerExtendedInfoDTO jobSeekerExtendedInfoDTO);

   MedicalJobSeekerStateLevelInfoDTO findByUserState(MedicalJobSeekerExtendedInfoDTO jobSeekerExtendedInfoDTO,
            EnumUSStatesTypeDTO usStatesTypeDTO);
}
