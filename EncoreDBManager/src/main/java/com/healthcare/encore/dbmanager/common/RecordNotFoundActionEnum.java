package com.healthcare.encore.dbmanager.common;

/**
 * 
 * @author ckumar
 *
 */
public enum RecordNotFoundActionEnum {
   //@formatter:off
   Create("Create", "Create record if not found"), 
   Error("Error", "Throw exception if record not found"),
   ReturnNull("ReturnNull", "Return null if record not found");
   //@formatter:on
   
   /**
    * Name of the enum
    */
   private final String name;

   /**
    * Description of the enum
    */
   private final String desc;
   

   /**
    * 
    * @param name
    * @param desc
    */
   private RecordNotFoundActionEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   /**
   *
   * @param name
   * @return Filter field
   */
   public static RecordNotFoundActionEnum fromName(final String name) {
      for (RecordNotFoundActionEnum value : RecordNotFoundActionEnum.values()) {
         if (value.name.equalsIgnoreCase(name)) {
            return value;
         }
      }
      return null;
   }

   /**
   * @return the name
   */
   public String getName() {
      return this.name;
   }

   /**
   * @return the description
   */
   public String getDesc() {
      return this.desc;
   }   
}
