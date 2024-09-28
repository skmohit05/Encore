/**
 *
 */
package com.healthcare.encore.model;

/**
 * 
 * @author mmeena
 *
 */
public class Organization {

   private String organizationName;

   private OrganizationTypeEnum organizationType;

   private String speciality;
   
   private FacilityTypeEnum facilityType;
   
   private FacilitySubTypeEnum facilitySubType;

   private boolean government;

   public String getOrganizationName() {
      return this.organizationName;
   }

   public void setOrganizationName(final String organizationName) {
      this.organizationName = organizationName;
   }

   public OrganizationTypeEnum getOrganizationType() {
      return this.organizationType;
   }

   public void setOrganizationType(final OrganizationTypeEnum organizationType) {
      this.organizationType = organizationType;
   }

   public String getSpeciality() {
      return this.speciality;
   }

   public void setSpeciality(final String speciality) {
      this.speciality = speciality;
   }

   public FacilityTypeEnum getFacilityType() {
      return this.facilityType;
   }

   public void setFacilityType(final FacilityTypeEnum facilityType) {
      this.facilityType = facilityType;
   }

   public FacilitySubTypeEnum getFacilitySubType() {
      return this.facilitySubType;
   }

   public void setFacilitySubType(final FacilitySubTypeEnum facilitySubType) {
      this.facilitySubType = facilitySubType;
   }

   public boolean isGovernment() {
      return this.government;
   }

   public void setGovernment(final boolean government) {
      this.government = government;
   }
}
