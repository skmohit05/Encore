/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.MedicalJobSeekerStateLevelInfoDAO;
import com.healthcare.encore.db.dto.EnumUSStatesTypeDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerStateLevelInfoDTO;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.model.MedicalJobSeekerExtendedInfo;
import com.healthcare.encore.model.MedicalJobSeekerStateLevelInfo;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalJobSeekerStateLevelInfoMapper
         extends AbstractMapper<MedicalJobSeekerStateLevelInfoDTO, MedicalJobSeekerStateLevelInfo> {

   @Autowired
   private MedicalJobSeekerStateLevelInfoDAO stateLevelInfoDAO;

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalJobSeekerStateLevelInfo getModel(final MedicalJobSeekerStateLevelInfoDTO stateLevelInfoDTO) {
      MedicalJobSeekerStateLevelInfo stateLevelInfo = new MedicalJobSeekerStateLevelInfo();
      stateLevelInfo.setLicenseExpirationDate(stateLevelInfoDTO.getLicenseExpirationDate());
      stateLevelInfo.setPrescriptionAuthority(stateLevelInfoDTO.isPrescriptionAuthority());
      return stateLevelInfo;
   }

   public MedicalJobSeekerStateLevelInfoDTO getDTO(final MedicalJobSeekerExtendedInfoDTO jobSeekerExtendedInfoDTO,
            final USStatesTypeEnum usStatesType, final MedicalJobSeekerStateLevelInfo stateLevelInfo) {
      EnumUSStatesTypeDTO usStatesTypeDTO = this.enumMapperUtil.getDTO(usStatesType);
      MedicalJobSeekerStateLevelInfoDTO stateLevelInfoDTO = this.stateLevelInfoDAO.findByUserState(jobSeekerExtendedInfoDTO,
               usStatesTypeDTO);
      if (stateLevelInfoDTO == null) {
         stateLevelInfoDTO = new MedicalJobSeekerStateLevelInfoDTO();
      }

      stateLevelInfoDTO.setLicenseExpirationDate(stateLevelInfo.getLicenseExpirationDate());
      stateLevelInfoDTO.setPrescriptionAuthority(stateLevelInfo.isPrescriptionAuthority());
      stateLevelInfoDTO.setUsStatesTypeDTO(usStatesTypeDTO);
      stateLevelInfoDTO.setMedicalJobSeekerExtendedInfoDTO(jobSeekerExtendedInfoDTO);
      return stateLevelInfoDTO;
   }

   public List<MedicalJobSeekerStateLevelInfoDTO> getDTOs(final MedicalJobSeekerExtendedInfoDTO jobSeekerExtendedInfoDTO,
            final MedicalJobSeekerExtendedInfo extInfo) {
      List<MedicalJobSeekerStateLevelInfoDTO> stateLevelInfoDTOs = new ArrayList<>();

      Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> stateLevelsInfo = extInfo.getStateLevelInfo();
      for (Map.Entry<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> entry : stateLevelsInfo.entrySet()) {
         MedicalJobSeekerStateLevelInfoDTO stateLevelInfoDTO = this.getDTO(jobSeekerExtendedInfoDTO, entry.getKey(), entry.getValue());
         stateLevelInfoDTOs.add(stateLevelInfoDTO);
      }

      return stateLevelInfoDTOs;
   }

   public Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> getJobSeekerStateLevelInfo(
            final MedicalJobSeekerExtendedInfoDTO extInfoDTO) {
      Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> stateLevelsInfo = new TreeMap<>();
      List<MedicalJobSeekerStateLevelInfoDTO> stateLevelInfoDTOs = extInfoDTO.getMedicalJobSeekerStateLevelInfoDTOs();
      for (MedicalJobSeekerStateLevelInfoDTO stateLevelInfoDTO : stateLevelInfoDTOs) {
         MedicalJobSeekerStateLevelInfo stateLevelInfo = this.getModel(stateLevelInfoDTO);
         USStatesTypeEnum usStateType = this.enumMapperUtil.getModel(stateLevelInfoDTO.getUsStatesTypeDTO());
         stateLevelsInfo.put(usStateType, stateLevelInfo);
      }

      return stateLevelsInfo;
   }
}
