/**
 *
 */
package com.healthcare.encore.dbmanager.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.MedicalEmployerJobPostingDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerJobInfoDAO;
import com.healthcare.encore.db.dao.OrganizationDAO;
import com.healthcare.encore.db.dao.UserDAO;
import com.healthcare.encore.db.dto.BaseSetupDTO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobInfoDTO;
import com.healthcare.encore.db.dto.OrganizationDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.RecordNotFoundException;
import com.healthcare.encore.model.BaseSetup;

/**
 * @author ckumar
 *
 */
@Component
public class SetupMapperUtil {

   @Autowired
   private OrganizationDAO organizationDAO;
   
   @Autowired
   private UserDAO userDAO;
   
   @Autowired
   private MapperUtil mapperUtil;
   
   @Autowired
   private MedicalJobSeekerJobInfoDAO jobInfoDAO;
   
   @Autowired
   private MedicalEmployerJobPostingDAO medicalEmployerJobPostingDAO;


   /**
    *
    * @param setupDTO
    * @param setup
    */
   public void mapSetupDTOToModel(final BaseSetupDTO setupDTO, final BaseSetup setup) {
      setup.setAuditInfo(this.mapperUtil.getModel(setupDTO.getAuditInfoDTO()));
   }

   /**
    *
    * @param setup
    * @param setupDTO
    */
   public void mapSetupModelToDTO(final BaseSetup setup, final BaseSetupDTO setupDTO) {
   }
   
   public void checkIfUserExists(final Integer userId){
      if (this.getUserDTO(userId) == null && userId != null) {
         throw new RecordNotFoundException("User record not found [" + "UserId=" + userId.intValue() + "]");
      }
   }
   
   public UserDTO getUserDTO(final Integer userId, final boolean errorIfNotFound){
      UserDTO userDTO = this.getUserDTO(userId);
      if (errorIfNotFound && userDTO == null && userId != null) {
         throw new RecordNotFoundException("User record not found [" + "UserId=" + userId.intValue() + "]");
      }
      return userDTO;
   }

   public UserDTO getUserDTO(final Integer userId) {
      return userId == null ? null : this.userDAO.findById(userId);
   }
   
   public OrganizationDTO getOrganizationDTO(final String organizationName, final boolean errorIfNotFound){
      OrganizationDTO orgDTO = this.getOrganizationDTO(organizationName);
      if (errorIfNotFound && orgDTO == null) {
         throw new RecordNotFoundException("Organization record not found [" + "OrganizationId=" + organizationName + "]");
      }
      return orgDTO;
   }

   public OrganizationDTO getOrganizationDTO(final String organizationName) {
      return StringUtils.isBlank(organizationName) ? null : this.organizationDAO.findByName(organizationName);
   }
   
   public MedicalJobSeekerJobInfoDTO getMedicalJobSeekerJobInfoDTO(final Integer jobInfoId, final boolean errorIfNotFound){
      MedicalJobSeekerJobInfoDTO jobInfoDTO = this.getMedicalJobSeekerJobInfoDTO(jobInfoId);
      if (errorIfNotFound && jobInfoDTO == null) {
         throw new RecordNotFoundException("MedicalJobSeekerJobInfo record not found [" + "jobInfoId=" + jobInfoId + "]");
      }
      return jobInfoDTO;
   }

   public MedicalJobSeekerJobInfoDTO getMedicalJobSeekerJobInfoDTO(final Integer jobInfoId) {
      return jobInfoId == null ? null : this.jobInfoDAO.findById(jobInfoId);
   }
   
   public MedicalEmployerJobPostingDTO getMedicalEmployerJobPostingDTO(final Integer jobPostingId, final boolean errorIfNotFound){
      MedicalEmployerJobPostingDTO jobPostingDTO = this.getMedicalEmployerJobPostingDTO(jobPostingId);
      if (errorIfNotFound && jobPostingDTO == null && jobPostingId != null) {
         throw new RecordNotFoundException("MedicalEmployerJobPosting record not found [" + "jobInfoId=" + jobPostingId + "]");
      }
      return jobPostingDTO;
   }

   public MedicalEmployerJobPostingDTO getMedicalEmployerJobPostingDTO(final Integer jobPostingId) {
      return jobPostingId == null ? null : this.medicalEmployerJobPostingDAO.findById(jobPostingId);
   }
   
}
