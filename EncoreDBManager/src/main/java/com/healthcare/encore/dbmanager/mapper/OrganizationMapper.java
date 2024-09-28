/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthcare.encore.db.dto.OrganizationDTO;
import com.healthcare.encore.dbmanager.common.DBManagerUtil;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.model.Organization;

/**
 * @author mmeena
 *
 */
@Component
public class OrganizationMapper extends AbstractMapper<OrganizationDTO, Organization> {

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private DBManagerUtil dBManagerUtil;

   /**
    * {@inheritDoc}
    */
   @Override
   public Organization getModel(final OrganizationDTO organizationDTO) {
      Organization organization = new Organization();
      organization.setOrganizationName(organizationDTO.getOrganizationName());
      organization.setOrganizationType(this.enumMapperUtil.getModel(organizationDTO.getOrganizationTypeDTO()));
      organization.setSpeciality(organizationDTO.getSpeciality());
      organization.setFacilityType(this.enumMapperUtil.getModel(organizationDTO.getFacilityTypeDTO()));
      organization.setFacilitySubType(this.enumMapperUtil.getModel(organizationDTO.getFacilitySubTypeDTO()));
      organization.setGovernment(organizationDTO.isGovernment());
      return organization;
   }

   public OrganizationDTO getDTO(final Organization organization) {
      OrganizationDTO organizationDTO = this.setupMapperUtil.getOrganizationDTO(organization.getOrganizationName());
      if(organizationDTO == null) {
         organizationDTO = new OrganizationDTO();
         organizationDTO.setOrganizationName(organization.getOrganizationName());
      }
      organizationDTO.setOrganizationTypeDTO(this.enumMapperUtil.getDTO(organization.getOrganizationType()));
      organizationDTO.setSpeciality(organization.getSpeciality());
      organizationDTO.setFacilityTypeDTO(this.enumMapperUtil.getDTO(organization.getFacilityType()));
      organizationDTO.setFacilitySubTypeDTO(this.enumMapperUtil.getDTO(organization.getFacilitySubType()));
      organizationDTO.setGovernment(organization.isGovernment());
      organizationDTO.setAuditInfoDTO(this.dBManagerUtil.getForcedAuditInfo());
      return organizationDTO;
   }
}
