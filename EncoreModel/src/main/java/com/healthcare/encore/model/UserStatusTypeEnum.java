package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum UserStatusTypeEnum {
   
   /**
    * 
    */
   Active("Active", "User is active"),
   
   /**
    * 
    */
   Inactive("Inactive", "User is inactive"),
   
   /**
    * 
    */
   Verified("Verified", "User is verified"),
   
   /**
    * 
    */
   Pending("Pending", "User is pending"),
   
   /**
    * 
    */
   Rejected("Rejected", "User is Rejected");

   private final String name;

   /**
    *
    */
   private final String desc;

   private UserStatusTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static UserStatusTypeEnum fromName(final String name) {
      for (UserStatusTypeEnum value : UserStatusTypeEnum.values()) {
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
