package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum CompensationTypeEnum {

   Hourly("Hourly", "Hourly"),
   Lumpsum("Lumpsum", "Lumpsum"),
   Yearly("Yearly", "Yearly");

   private final String name;

   /**
    *
    */
   private final String desc;

   private CompensationTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static CompensationTypeEnum fromName(final String name) {
      for (CompensationTypeEnum value : CompensationTypeEnum.values()) {
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
