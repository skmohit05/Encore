package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalJobSeekerJobApplicationInfoDAO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobApplicationInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalJobSeekerJobApplicationInfoDAOImpl extends BaseDAOImpl<MedicalJobSeekerJobApplicationInfoDTO, Integer>
         implements MedicalJobSeekerJobApplicationInfoDAO {

   /**
    *
    */
   public MedicalJobSeekerJobApplicationInfoDAOImpl() {
      super(MedicalJobSeekerJobApplicationInfoDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<MedicalJobSeekerJobApplicationInfoDTO> findAll(final UserDTO jobSeekerUserDTO) {
      return super.list("MedicalJobSeekerJobApplicationInfoDTO.findAll", new String[] { "jobSeekerUserId" }, jobSeekerUserDTO.getId());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerJobApplicationInfoDTO findByJobPosting(final UserDTO jobSeekerUserDTO,
            final MedicalEmployerJobPostingDTO jobPostingDTO) {
      return super.findUnique("MedicalJobSeekerJobApplicationInfoDTO.findByJobPostingId",
               new String[] { "jobSeekerUserId", "jobPostingId" }, jobSeekerUserDTO.getId(), jobPostingDTO.getId());
   }

}
