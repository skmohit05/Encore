package com.healthcare.encore.db.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalJobSeekerJobInfoDAO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobInfoDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalJobSeekerJobInfoDAOImpl extends BaseDAOImpl<MedicalJobSeekerJobInfoDTO, Integer> implements MedicalJobSeekerJobInfoDAO {

   /**
    *
    */
   public MedicalJobSeekerJobInfoDAOImpl() {
      super(MedicalJobSeekerJobInfoDTO.class);
   }
   
}
