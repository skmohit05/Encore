package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum OrganizationTypeEnum {

   EmployeeBasedPractice("EmployeeBasedPractice", "Employee Based Practice"),
   PrivatePractice("PrivatePractice", "Private Practice"),
   Corporate("Corporate", "Corporate");

   private final String name;

   private final String desc;

   private OrganizationTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static OrganizationTypeEnum fromName(final String name) {
      for (OrganizationTypeEnum value : OrganizationTypeEnum.values()) {
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
