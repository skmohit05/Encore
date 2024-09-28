package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum CommunicationChannelTypeEnum {
   /**
    *
    */
   Email("Email", "Email"),

   /**
    *
    */
   SMS("SMS", "SMS");

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
   private CommunicationChannelTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   /**
   *
   * @param name
   * @return CommunicationChannelTypeEnum
   */
   @JsonCreator
   public static CommunicationChannelTypeEnum fromName(final String name) {
      for (CommunicationChannelTypeEnum value : CommunicationChannelTypeEnum.values()) {
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
