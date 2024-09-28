package com.healthcare.encore.db.dao;

import com.healthcare.encore.db.dto.MedicalEmployerExtendedInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
public interface MedicalEmployerExtendedInfoDAO extends BaseDAO<MedicalEmployerExtendedInfoDTO, Integer> {
   
   MedicalEmployerExtendedInfoDTO findByUser(UserDTO userDTO);
}
