package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum SpecialityTypeEnum {
   /**
    *
    */
   Cardiology("Cardiology", "Cardiology"),

   /**
    *
    */
   Dermatology("Dermatology", "Dermatology"),

   /**
    *
    */
   Nephrology("Nephrology", "Nephrology"),

   /**
    *
    */
   Neurology("Neurology", "Neurology"),

   /**
    *
    */
   Pediatrics("Pediatrics", "Pediatrics"),

   /**
    *
    */
   Psychiatry("Psychiatry", "Psychiatry"),

   /**
    *
    */
   Pulmonology("Pulmonology", "Pulmonology"),

   /**
    *
    */
   Anesthesiology("Anesthesiology", "Anesthesiology"),

   /**
    *
    */
   EmergencyMedicine("EmergencyMedicine", "Emergency Medicine"),

   /**
    *
    */
   FamilyPractice("FamilyPractice", "Family Practice"),

   /**
    *
    */
   GeneralPractice("GeneralPractice", "General Practice"),

   /**
    *
    */
   Endocrinology("Endocrinology", "Endocrinology"),

   /**
    *
    */
   Gastroenterology("Gastroenterology", "Gastroenterology"),

   /**
    *
    */
   Gynecology("Gynecology", "Gynecology"),

   /**
    *
    */
   InternalMedicine("InternalMedicine", "Internal Medicine");

   /**
    *
    */
   private final String name;

   /**
    *
    */
   private final String desc;

   /**
    *
    * @param name
    * @param desc
    */
   private SpecialityTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   /**
   *
   * @param name
   * @return SpecialityEnum
   */
   @JsonCreator
   public static SpecialityTypeEnum fromName(final String name) {
      for (SpecialityTypeEnum value : SpecialityTypeEnum.values()) {
         if (value.name.equalsIgnoreCase(name)) {
            return value;
         }
      }
      return null;
   }

   /**
    *
    * @return name
    */
   public String getName() {
      return this.name();
   }

   /**
    *
    * @return desc
    */
   public String getDesc() {
      return this.desc;
   }
}
