package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum FacilitySubTypeEnum {

   PrimacyCareCenter("PrimacyCareCenter", "Primacy Care Center"),
   TertiaryCareCenter("TertiaryCareCenter", "Tertiary Care Center"),
   TraumaCenter1("TraumaCenter1", "Trauma Center 1"),
   TraumaCenter2("TraumaCenter2", "Trauma Center 2"),
   TraumaCenter3("TraumaCenter3", "Trauma Center 3"),
   UniversityCenter("UniversityCenter", "University Center"),
   CriticalAccessHospital("CriticalAccessHospital", "Critical Access Hospital"),
   CommunityHospital("CommunityHospital", "Community Hospital");

   private final String name;

   private final String desc;

   private FacilitySubTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static FacilitySubTypeEnum fromName(final String name) {
      for (FacilitySubTypeEnum value : FacilitySubTypeEnum.values()) {
         if (value.name.equalsIgnoreCase(name)) {
            return value;
         }
      }
      return null;
   }

   public String getName() {
      return this.name();
   }

   public String getDesc() {
      return this.desc;
   }
}
