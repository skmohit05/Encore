/**
 *
 */
package com.healthcare.encore.dbmanager.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dao.EnumAssignmentTypeDAO;
import com.healthcare.encore.db.dao.EnumCommunicationChannelTypeDAO;
import com.healthcare.encore.db.dao.EnumCompensationTypeDAO;
import com.healthcare.encore.db.dao.EnumFacilitySubTypeDAO;
import com.healthcare.encore.db.dao.EnumFacilityTypeDAO;
import com.healthcare.encore.db.dao.EnumFieldTypeDAO;
import com.healthcare.encore.db.dao.EnumJobPostingStatusTypeDAO;
import com.healthcare.encore.db.dao.EnumJobTypeDAO;
import com.healthcare.encore.db.dao.EnumMFATypeDAO;
import com.healthcare.encore.db.dao.EnumOrganizationTypeDAO;
import com.healthcare.encore.db.dao.EnumPriorityFeatureTypeDAO;
import com.healthcare.encore.db.dao.EnumShiftTypeDAO;
import com.healthcare.encore.db.dao.EnumSpecialityTypeDAO;
import com.healthcare.encore.db.dao.EnumUSStatesTypeDAO;
import com.healthcare.encore.db.dao.EnumUserStatusTypeDAO;
import com.healthcare.encore.db.dao.EnumUserTypeDAO;
import com.healthcare.encore.db.dto.EnumAssignmentTypeDTO;
import com.healthcare.encore.db.dto.EnumCommunicationChannelTypeDTO;
import com.healthcare.encore.db.dto.EnumCompensationTypeDTO;
import com.healthcare.encore.db.dto.EnumFacilitySubTypeDTO;
import com.healthcare.encore.db.dto.EnumFacilityTypeDTO;
import com.healthcare.encore.db.dto.EnumFieldTypeDTO;
import com.healthcare.encore.db.dto.EnumJobPostingStatusTypeDTO;
import com.healthcare.encore.db.dto.EnumJobTypeDTO;
import com.healthcare.encore.db.dto.EnumMFATypeDTO;
import com.healthcare.encore.db.dto.EnumOrganizationTypeDTO;
import com.healthcare.encore.db.dto.EnumPriorityFeatureTypeDTO;
import com.healthcare.encore.db.dto.EnumShiftTypeDTO;
import com.healthcare.encore.db.dto.EnumSpecialityTypeDTO;
import com.healthcare.encore.db.dto.EnumUSStatesTypeDTO;
import com.healthcare.encore.db.dto.EnumUserStatusTypeDTO;
import com.healthcare.encore.db.dto.EnumUserTypeDTO;
import com.healthcare.encore.model.AssignmentTypeEnum;
import com.healthcare.encore.model.CommunicationChannelTypeEnum;
import com.healthcare.encore.model.CompensationTypeEnum;
import com.healthcare.encore.model.FacilitySubTypeEnum;
import com.healthcare.encore.model.FacilityTypeEnum;
import com.healthcare.encore.model.FieldTypeEnum;
import com.healthcare.encore.model.JobPostingStatusTypeEnum;
import com.healthcare.encore.model.JobTypeEnum;
import com.healthcare.encore.model.MFATypeEnum;
import com.healthcare.encore.model.OrganizationTypeEnum;
import com.healthcare.encore.model.PriorityFeatureTypeEnum;
import com.healthcare.encore.model.ShiftTypeEnum;
import com.healthcare.encore.model.SpecialityTypeEnum;
import com.healthcare.encore.model.USStatesTypeEnum;
import com.healthcare.encore.model.UserStatusTypeEnum;
import com.healthcare.encore.model.UserTypeEnum;

/**
 * Enum mapper methods
 *
 * @author mmeena
 *
 */
//CHECKSTYLE:OFF - Fan-Out Complexity > 40
@Component
public class EnumMapperUtil {
   // CHECKSTYLE:ON

   @Autowired
   private EnumUserStatusTypeDAO enumUserStatusTypeDAO;

   @Autowired
   private EnumOrganizationTypeDAO enumOrganizationTypeDAO;

   @Autowired
   private EnumCommunicationChannelTypeDAO enumCommunicationChannelTypeDAO;
   
   @Autowired
   private EnumFieldTypeDAO enumFieldTypeDAO;
   
   @Autowired
   private EnumUserTypeDAO enumUserTypeDAO;
   
   @Autowired
   private EnumSpecialityTypeDAO enumSpecialityTypeDAO;
   
   @Autowired
   private EnumShiftTypeDAO enumShiftTypeDAO;
   
   @Autowired
   private EnumJobTypeDAO enumJobTypeDAO;
   
   @Autowired
   private EnumAssignmentTypeDAO enumAssignmentTypeDAO;
   
   @Autowired
   private EnumFacilityTypeDAO enumFacilityTypeDAO;
   
   @Autowired
   private EnumFacilitySubTypeDAO enumFacilitySubTypeDAO;
   
   @Autowired
   private EnumCompensationTypeDAO enumCompensationTypeDAO;
   
   @Autowired
   private EnumPriorityFeatureTypeDAO enumPriorityFeatureTypeDAO;

   @Autowired
   private EnumJobPostingStatusTypeDAO enumJobPostingStatusTypeDAO;
   
   @Autowired
   private EnumUSStatesTypeDAO enumUSStatesTypeDAO;
   
   @Autowired
   private EnumMFATypeDAO enumMFATypeDAO;

   public EnumUserStatusTypeDTO getDTO(final UserStatusTypeEnum enumValue) {
      return enumValue == null ? null : this.enumUserStatusTypeDAO.findByName(enumValue.getName());
   }

   public UserStatusTypeEnum getModel(final EnumUserStatusTypeDTO dto) {
      return dto == null ? null : UserStatusTypeEnum.fromName(dto.getName());
   }

   public EnumOrganizationTypeDTO getDTO(final OrganizationTypeEnum enumValue) {
      return enumValue == null ? null : this.enumOrganizationTypeDAO.findByName(enumValue.getName());
   }

   public OrganizationTypeEnum getModel(final EnumOrganizationTypeDTO dto) {
      return dto == null ? null : OrganizationTypeEnum.fromName(dto.getName());
   }

   public EnumCommunicationChannelTypeDTO getDTO(final CommunicationChannelTypeEnum enumValue) {
      return enumValue == null ? null : this.enumCommunicationChannelTypeDAO.findByName(enumValue.getName());
   }

   public CommunicationChannelTypeEnum getModel(final EnumCommunicationChannelTypeDTO dto) {
      return dto == null ? null : CommunicationChannelTypeEnum.fromName(dto.getName());
   }

   public EnumFieldTypeDTO getDTO(final FieldTypeEnum enumValue) {
      return enumValue == null ? null : this.enumFieldTypeDAO.findByName(enumValue.getName());
   }

   public FieldTypeEnum getModel(final EnumFieldTypeDTO dto) {
      return dto == null ? null : FieldTypeEnum.fromName(dto.getName());
   }

   public EnumUserTypeDTO getDTO(final UserTypeEnum enumValue) {
      return enumValue == null ? null : this.enumUserTypeDAO.findByName(enumValue.getName());
   }

   public UserTypeEnum getModel(final EnumUserTypeDTO dto) {
      return dto == null ? null : UserTypeEnum.fromName(dto.getName());
   }

   public EnumSpecialityTypeDTO getDTO(final SpecialityTypeEnum enumValue) {
      return enumValue == null ? null : this.enumSpecialityTypeDAO.findByName(enumValue.getName());
   }

   public SpecialityTypeEnum getModel(final EnumSpecialityTypeDTO dto) {
      return dto == null ? null : SpecialityTypeEnum.fromName(dto.getName());
   }

   public EnumJobTypeDTO getDTO(final JobTypeEnum enumValue) {
      return enumValue == null ? null : this.enumJobTypeDAO.findByName(enumValue.getName());
   }

   public JobTypeEnum getModel(final EnumJobTypeDTO dto) {
      return dto == null ? null : JobTypeEnum.fromName(dto.getName());
   }

   public EnumShiftTypeDTO getDTO(final ShiftTypeEnum enumValue) {
      return enumValue == null ? null : this.enumShiftTypeDAO.findByName(enumValue.getName());
   }

   public ShiftTypeEnum getModel(final EnumShiftTypeDTO dto) {
      return dto == null ? null : ShiftTypeEnum.fromName(dto.getName());
   }

   public EnumAssignmentTypeDTO getDTO(final AssignmentTypeEnum enumValue) {
      return enumValue == null ? null : this.enumAssignmentTypeDAO.findByName(enumValue.getName());
   }

   public AssignmentTypeEnum getModel(final EnumAssignmentTypeDTO dto) {
      return dto == null ? null : AssignmentTypeEnum.fromName(dto.getName());
   }

   public EnumFacilityTypeDTO getDTO(final FacilityTypeEnum enumValue) {
      return enumValue == null ? null : this.enumFacilityTypeDAO.findByName(enumValue.getName());
   }

   public FacilityTypeEnum getModel(final EnumFacilityTypeDTO dto) {
      return dto == null ? null : FacilityTypeEnum.fromName(dto.getName());
   }

   public EnumFacilitySubTypeDTO getDTO(final FacilitySubTypeEnum enumValue) {
      return enumValue == null ? null : this.enumFacilitySubTypeDAO.findByName(enumValue.getName());
   }

   public FacilitySubTypeEnum getModel(final EnumFacilitySubTypeDTO dto) {
      return dto == null ? null : FacilitySubTypeEnum.fromName(dto.getName());
   }

   public EnumCompensationTypeDTO getDTO(final CompensationTypeEnum enumValue) {
      return enumValue == null ? null : this.enumCompensationTypeDAO.findByName(enumValue.getName());
   }

   public CompensationTypeEnum getModel(final EnumCompensationTypeDTO dto) {
      return dto == null ? null : CompensationTypeEnum.fromName(dto.getName());
   }

   public EnumPriorityFeatureTypeDTO getDTO(final PriorityFeatureTypeEnum enumValue) {
      return enumValue == null ? null : this.enumPriorityFeatureTypeDAO.findByName(enumValue.getName());
   }

   public PriorityFeatureTypeEnum getModel(final EnumPriorityFeatureTypeDTO dto) {
      return dto == null ? null : PriorityFeatureTypeEnum.fromName(dto.getName());
   }

   public EnumUSStatesTypeDTO getDTO(final USStatesTypeEnum enumValue) {
      return enumValue == null ? null : this.enumUSStatesTypeDAO.findByName(enumValue.getDesc());
   }

   public USStatesTypeEnum getModel(final EnumUSStatesTypeDTO dto) {
      return dto == null ? null : USStatesTypeEnum.fromDescription(dto.getDesc());
   }

   public EnumJobPostingStatusTypeDTO getDTO(final JobPostingStatusTypeEnum enumValue) {
      return enumValue == null ? null : this.enumJobPostingStatusTypeDAO.findByName(enumValue.getName());
   }

   public JobPostingStatusTypeEnum getModel(final EnumJobPostingStatusTypeDTO dto) {
      return dto == null ? null : JobPostingStatusTypeEnum.fromName(dto.getName());
   }

   public EnumMFATypeDTO getDTO(final MFATypeEnum enumValue) {
      return enumValue == null ? null : this.enumMFATypeDAO.findByName(enumValue.getName());
   }

   public MFATypeEnum getModel(final EnumMFATypeDTO dto) {
      return dto == null ? null : MFATypeEnum.fromName(dto.getName());
   }
}
