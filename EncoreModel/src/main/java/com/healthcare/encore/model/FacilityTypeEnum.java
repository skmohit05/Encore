package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum FacilityTypeEnum {

   ER("ER", "ER"),
   OP("OP", "OP"),
   Hospital("Hospital", "Hospital"),
   ImagingCenter("ImagingCenter", "Imaging Center");

   private final String name;

   private final String desc;

   private FacilityTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static FacilityTypeEnum fromName(final String name) {
      for (FacilityTypeEnum value : FacilityTypeEnum.values()) {
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
