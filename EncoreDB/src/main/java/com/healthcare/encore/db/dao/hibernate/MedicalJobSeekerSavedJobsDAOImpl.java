package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalJobSeekerSavedJobsDAO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerSavedJobDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalJobSeekerSavedJobsDAOImpl extends BaseDAOImpl<MedicalJobSeekerSavedJobDTO, Integer>
         implements MedicalJobSeekerSavedJobsDAO {

   /**
    *
    */
   public MedicalJobSeekerSavedJobsDAOImpl() {
      super(MedicalJobSeekerSavedJobDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<MedicalJobSeekerSavedJobDTO> findAll(final UserDTO jobSeekerUserDTO) {
      return super.list("MedicalJobSeekerSavedJobDTO.findAll", new String[] { "jobSeekerUserId" }, jobSeekerUserDTO.getId());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerSavedJobDTO findByJobPosting(final UserDTO jobSeekerUserDTO, final MedicalEmployerJobPostingDTO jobPostingDTO) {
      return super.findUnique("MedicalJobSeekerSavedJobDTO.findByJobPostingId", new String[] { "jobSeekerUserId", "jobPostingId" },
               jobSeekerUserDTO.getId(), jobPostingDTO.getId());
   }

}
