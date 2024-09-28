/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.MedicalEmployerExtendedInfoDAO;
import com.healthcare.encore.db.dto.MedicalEmployerExtendedInfoDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.MedicalEmployerExtendedInfo;

/**
 * @author mmeena
 *
 */
@Component
public class MedicalEmployerExtendedInfoMapper
         extends AbstractMapper<MedicalEmployerExtendedInfoDTO, MedicalEmployerExtendedInfo> {

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private MedicalEmployerExtendedInfoDAO extInfoDAO;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   /**
    * {@inheritDoc}
    */
   @Override
   public MedicalEmployerExtendedInfo getModel(final MedicalEmployerExtendedInfoDTO extInfoDTO) {
      MedicalEmployerExtendedInfo extInfo = new MedicalEmployerExtendedInfo();
      extInfo.setOrganizationRole(extInfoDTO.getOrganizationRole());
      extInfo.setAddress1(extInfoDTO.getAddress1());
      extInfo.setAddress2(extInfoDTO.getAddress2());
      extInfo.setCity(extInfoDTO.getCity());
      extInfo.setState(extInfoDTO.getState());
      extInfo.setZip(extInfoDTO.getZip());
      extInfo.setPhone(extInfoDTO.getPhone());
      extInfo.setMalpracticeCandidateAcceptable(extInfoDTO.isMalpracticeCandidateAcceptable());
      extInfo.setBoardActionsCandidateAcceptable(extInfoDTO.isBoardActionsCandidateAcceptable());
      extInfo.setDisciplinaryActionsCandidateAcceptable(extInfoDTO.isBoardActionsCandidateAcceptable());
      extInfo.setJobPreferenceType(this.enumMapperUtil.getModel(extInfoDTO.getJobTypeDTO()));
      extInfo.setGovernmentAssignment(extInfoDTO.isGovernmentAssignment());
      extInfo.setAvgPatientsInMonth(extInfoDTO.getAvgPatientsInMonth());
      extInfo.setBeds(extInfoDTO.getBeds());
      extInfo.setPeers(extInfoDTO.getPeers());
      extInfo.setNurses(extInfoDTO.getNurses());
      extInfo.setOrs(extInfoDTO.getOrs());
      extInfo.setCredentialingCoverage(extInfoDTO.isCredentialingCoverage());
      extInfo.setTravelHousingCoverage(extInfoDTO.isTravelHousingCoverage());
      extInfo.setLicenseCoverage(extInfoDTO.isLicenseCoverage());
      extInfo.setMalpracticeCoverage(extInfoDTO.isMalpracticeCoverage());
      return extInfo;
   }

   public MedicalEmployerExtendedInfoDTO getDTO(final int userId, final MedicalEmployerExtendedInfo extInfo) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(userId, true);
      MedicalEmployerExtendedInfoDTO extInfoDTO = this.extInfoDAO.findByUser(userDTO);
      if (extInfoDTO == null) {
         extInfoDTO = new MedicalEmployerExtendedInfoDTO();
         extInfoDTO.setUserDTO(userDTO);
      }

      extInfoDTO.setOrganizationRole(extInfo.getOrganizationRole());
      extInfoDTO.setAddress1(extInfo.getAddress1());
      extInfoDTO.setAddress2(extInfo.getAddress2());
      extInfoDTO.setCity(extInfo.getCity());
      extInfoDTO.setState(extInfo.getState());
      extInfoDTO.setZip(extInfo.getZip());
      extInfoDTO.setPhone(extInfo.getPhone());
      extInfoDTO.setMalpracticeCandidateAcceptable(extInfo.isMalpracticeCandidateAcceptable());
      extInfoDTO.setBoardActionsCandidateAcceptable(extInfo.isBoardActionsCandidateAcceptable());
      extInfoDTO.setDisciplinaryActionCandidateAcceptable(extInfo.isBoardActionsCandidateAcceptable());
      extInfoDTO.setJobTypeDTO(this.enumMapperUtil.getDTO(extInfo.getJobPreferenceType()));
      extInfoDTO.setGovernmentAssignment(extInfo.isGovernmentAssignment());
      extInfoDTO.setBeds(extInfo.getBeds());
      extInfoDTO.setAvgPatientsInMonth(extInfo.getAvgPatientsInMonth());
      extInfoDTO.setPeers(extInfo.getPeers());
      extInfoDTO.setNurses(extInfo.getNurses());
      extInfoDTO.setOrs(extInfo.getOrs());
      extInfoDTO.setCredentialingCoverage(extInfo.isCredentialingCoverage());
      extInfoDTO.setTravelHousingCoverage(extInfo.isTravelHousingCoverage());
      extInfoDTO.setLicenseCoverage(extInfo.isLicenseCoverage());
      extInfoDTO.setMalpracticeCoverage(extInfo.isMalpracticeCoverage());
      extInfoDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      return extInfoDTO;
   }
}
