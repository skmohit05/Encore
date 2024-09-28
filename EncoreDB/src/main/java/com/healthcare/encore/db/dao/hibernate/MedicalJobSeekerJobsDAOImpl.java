package com.healthcare.encore.db.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalJobSeekerJobsDAO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobsDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalJobSeekerJobsDAOImpl extends BaseDAOImpl<MedicalJobSeekerJobsDTO, Integer> implements MedicalJobSeekerJobsDAO {

   /**
    *
    */
   public MedicalJobSeekerJobsDAOImpl() {
      super(MedicalJobSeekerJobsDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<MedicalJobSeekerJobsDTO> findAll(final UserDTO userDTO) {
      return super.list("MedicalJobSeekerJobsDTO.findAll", new String[] { "userId" }, userDTO.getId());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerJobsDTO findByJobInfo(final UserDTO userDTO, final MedicalJobSeekerJobInfoDTO jobInfoDTO) {
      return super.findUnique("MedicalJobSeekerJobsDTO.findByJobInfoId", new String[] { "userId", "jobInfoId" }, userDTO.getId(),
               jobInfoDTO.getId());
   }
   
}
