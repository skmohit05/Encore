package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalJobSeekerExtendedInfoDAO;
import com.healthcare.encore.db.dto.EnumSpecialityTypeDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalJobSeekerExtendedInfoDAOImpl extends BaseDAOImpl<MedicalJobSeekerExtendedInfoDTO, Integer>
         implements MedicalJobSeekerExtendedInfoDAO {

   /**
    *
    */
   public MedicalJobSeekerExtendedInfoDAOImpl() {
      super(MedicalJobSeekerExtendedInfoDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerExtendedInfoDTO findByUser(final UserDTO userDTO) {
      return super.findUnique("MedicalJobSeekerExtendedInfoDTO.findByUserId", new String[] { "userId" }, userDTO.getId());
   }

   @Override
   public List<MedicalJobSeekerExtendedInfoDTO> findByCandidateSeach(final String title, final EnumSpecialityTypeDTO specialityTypeDTO,
            final String location) {
      return super.list("MedicalJobSeekerExtendedInfoDTO.findByCandidateSeach", new String[] { "title", "specialityTypeDTO", "state" },
               title, specialityTypeDTO, location);
   }

}
