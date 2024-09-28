package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum ShiftTypeEnum {
   /**
    *
    */
   Day("Day", "Day"),

   /**
    *
    */
   Night("Night", "Night"),

   /**
    *
    */
   Weekend("Weekend", "Weekend"),

   /**
    *
    */
   AllDay("AllDay", "All Day"),

   /**
    *
    */
   NoPreference("NoPreference", "No Preference"),

   /**
    *
    */
   Variable("Variable", "Variable"),

   /**
    *
    */
   All("All", "All");

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
   private ShiftTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   /**
   *
   * @param name
   * @return ShiftEnum
   */
   @JsonCreator
   public static ShiftTypeEnum fromName(final String name) {
      for (ShiftTypeEnum value : ShiftTypeEnum.values()) {
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
