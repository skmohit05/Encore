package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum AssignmentTypeEnum {
   /**
    *
    */
   OR("OR", "OR"), 
   Outpatient("Outpatient", "Outpatient"), 
   ER("ER", "ER");

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
   private AssignmentTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   /**
   *
   * @param name
   * @return AssignmentTypeEnum
   */
   @JsonCreator
   public static AssignmentTypeEnum fromName(final String name) {
      for (AssignmentTypeEnum value : AssignmentTypeEnum.values()) {
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
