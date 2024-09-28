package com.healthcare.encore.db.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalEmployerExtendedInfoDAO;
import com.healthcare.encore.db.dto.MedicalEmployerExtendedInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 * 
 * @author mmeena
 *
 */
@Repository
public class MedicalEmployerExtendedInfoDAOImpl extends BaseDAOImpl<MedicalEmployerExtendedInfoDTO, Integer>
         implements MedicalEmployerExtendedInfoDAO {

   public MedicalEmployerExtendedInfoDAOImpl() {
      super(MedicalEmployerExtendedInfoDTO.class);
   }

   @Override
   public MedicalEmployerExtendedInfoDTO findByUser(final UserDTO userDTO) {
      return super.findUnique("MedicalEmployerExtendedInfoDTO.findByUserId", new String[] { "userId" }, userDTO.getId());
   }
}
