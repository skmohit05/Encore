package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum JobTypeEnum {
   /**
    *
    */
   LocumTenens("LocumTenens", "Locum Tenens"),

   /**
    *
    */
   Permanent("Permanent", "Permanent"),

   /**
    *
    */
   Temporary("Temporary", "Temporary");

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
   private JobTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   /**
   *
   * @param name
   * @return JobTypeEnum
   */
   @JsonCreator
   public static JobTypeEnum fromName(final String name) {
      for (JobTypeEnum value : JobTypeEnum.values()) {
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
