package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum USStatesTypeEnum {

   Alabama("Alabama", "Alabama"),
   Alaska("Alaska", "Alaska"),
   Arizona("Arizona", "Arizona"),
   Arkansas("Arkansas", "Arkansas"),
   California("California", "California"),
   Colorado("Colorado", "Colorado"),
   Connecticut("Connecticut", "Connecticut"),
   Delaware("Delaware", "Delaware"),
   Florida("Florida", "Florida"),
   Georgia("Georgia", "Georgia"),
   Hawaii("Hawaii", "Hawaii"),
   Idaho("Idaho", "Idaho"),
   Illinois("Illinois", "Illinois"),
   Indiana("Indiana", "Indiana"),
   Iowa("Iowa", "Iowa"),
   Kansas("Kansas", "Kansas"),
   Kentucky("Kentucky", "Kentucky"),
   Louisiana("Louisiana", "Louisiana"),
   Maine("Maine", "Maine"),
   Maryland("Maryland", "Maryland"),
   Massachusetts("Massachusetts", "Massachusetts"),
   Michigan("Michigan", "Michigan"),
   Minnesota("Minnesota", "Minnesota"),
   Mississippi("Mississippi", "Mississippi"),
   Missouri("Missouri", "Missouri"),
   Montana("Montana", "Montana"),
   Nebraska("Nebraska", "Nebraska"),
   Nevada("Nevada", "Nevada"),
   NewHampshire("NewHampshire", "New Hampshire"),
   NewJersey("NewJersey", "New Jersey"),
   NewMexico("NewMexico", "New Mexico"),
   NewYork("NewYork", "New York"),
   NorthCarolina("NorthCarolina", "North Carolina"),
   NorthDakota("NorthDakota", "North Dakota"),
   Ohio("Ohio", "Ohio"),
   Oklahoma("Oklahoma", "Oklahoma"),
   Oregon("Oregon", "Oregon"),
   Pennsylvania("Pennsylvania", "Pennsylvania"),
   RhodeIsland("RhodeIsland", "Rhode Island"),
   SouthCarolina("SouthCarolina", "South Carolina"),
   SouthDakota("SouthDakota", "South Dakota"),
   Tennessee("Tennessee", "Tennessee"),
   Texas("Texas", "Texas"),
   Utah("Utah", "Utah"),
   Vermont("Vermont", "Vermont"),
   Virginia("Virginia", "Virginia"),
   Washington("Washington", "Washington"),
   WestVirginia("WestVirginia", "West Virginia"),
   Wisconsin("Wisconsin", "Wisconsin"),
   Wyoming("Wyoming", "Wyoming");

   private final String name_;

   private final String desc_;

   private USStatesTypeEnum(final String name, final String desc) {
      this.name_ = name;
      this.desc_ = desc;
   }

   public static USStatesTypeEnum fromDescription(final String desc) {
      for (USStatesTypeEnum value : USStatesTypeEnum.values()) {
         if (value.desc_.equalsIgnoreCase(desc)) {
            return value;
         }
      }
      return null;
   }

   @JsonCreator
   public static USStatesTypeEnum fromName(final String name) {
      for (USStatesTypeEnum value : USStatesTypeEnum.values()) {
         if (value.name_.equalsIgnoreCase(name)) {
            return value;
         }
      }
      return null;
   }

   public String getName() {
      return this.name_;
   }

   public String getDesc() {
      return this.desc_;
   }
}
