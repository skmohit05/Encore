package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum FieldTypeEnum {

   Medical("Medical", "Medical"),

   IT("IT", "IT");

   private final String name;

   private final String desc;

   private FieldTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static FieldTypeEnum fromName(final String name) {
      for (FieldTypeEnum value : FieldTypeEnum.values()) {
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
