package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum UserTypeEnum {
   
   /**
    * 
    */
   Admin("Admin", "Administartive User"),
   
   /**
    * 
    */
   Employer("Employer", "Employer"),
   
   /**
    * 
    */
   JobSeeker("JobSeeker", "JobSeeker");
   
   /**
    * 
    */
   private final String name;

   /**
    *
    */
   private final String desc;

   private UserTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static UserTypeEnum fromName(final String name) {
      for (UserTypeEnum value : UserTypeEnum.values()) {
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
