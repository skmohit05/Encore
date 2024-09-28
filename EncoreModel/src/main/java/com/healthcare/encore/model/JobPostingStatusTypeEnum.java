package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum JobPostingStatusTypeEnum {
   
   /**
    * 
    */
   Active("Active", "Job Posting is active"),
   
   /**
    * 
    */
   Inactive("Inactive", "Job Posting is inactive"),
   
   /**
    * 
    */
   Verified("Verified", "Job Posting is verified"),
   
   /**
    * 
    */
   Pending("Pending", "Job Posting is pending"),
   
   /**
    * 
    */
   Rejected("Rejected", "Job Posting is Rejected");

   private final String name;

   /**
    *
    */
   private final String desc;

   private JobPostingStatusTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static JobPostingStatusTypeEnum fromName(final String name) {
      for (JobPostingStatusTypeEnum value : JobPostingStatusTypeEnum.values()) {
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
