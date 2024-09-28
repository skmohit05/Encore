package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalJobSeekerStateLevelInfoDAO;
import com.healthcare.encore.db.dto.EnumUSStatesTypeDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerStateLevelInfoDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalJobSeekerStateLevelInfoDAOImpl extends BaseDAOImpl<MedicalJobSeekerStateLevelInfoDTO, Integer>
         implements MedicalJobSeekerStateLevelInfoDAO {

   /**
    *
    */
   public MedicalJobSeekerStateLevelInfoDAOImpl() {
      super(MedicalJobSeekerStateLevelInfoDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<MedicalJobSeekerStateLevelInfoDTO> findAll(final MedicalJobSeekerExtendedInfoDTO jobSeekerExtendedInfoDTO) {
      return super.list("MedicalJobSeekerStateLevelInfoDTO.findAll", new String[] { "jobSeekerExtendedInfoDTO" },
               jobSeekerExtendedInfoDTO.getId());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerStateLevelInfoDTO findByUserState(final MedicalJobSeekerExtendedInfoDTO jobSeekerExtendedInfoDTO,
            final EnumUSStatesTypeDTO usStatesTypeDTO) {
      return super.findUnique("MedicalJobSeekerStateLevelInfoDTO.findByUserStateId", new String[] { "jobSeekerExtendedInfoId", "stateId" },
               jobSeekerExtendedInfoDTO.getId(), usStatesTypeDTO.getId());
   }

}
