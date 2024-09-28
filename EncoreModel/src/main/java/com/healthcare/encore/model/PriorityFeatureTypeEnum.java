package com.healthcare.encore.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author mmeena
 *
 */
public enum PriorityFeatureTypeEnum {

   Supervision("Supervision", "Supervision Required"), 
   PrescriptionAuthority("PrescriptionAuthority", "Prescription Authority Required"), 
   Compensation("Compensation", "Salary"), 
   NumberOfYears("NumberOfYears", "Years of Experience"), 
   AssignmentShift("AssignmentShift", "Shift"), 
   MalpracticeCandidate("MalpracticeCandidate", "Malpractice Candidate Accepted"), 
   FacilityType("FacilityType", "Facility Type");

   private final String name;
   private final String desc;
   private Integer priority;

   private PriorityFeatureTypeEnum(final String name, final String desc) {
      this.name = name;
      this.desc = desc;
   }

   @JsonCreator
   public static PriorityFeatureTypeEnum fromName(final String name) {
      for (PriorityFeatureTypeEnum value : PriorityFeatureTypeEnum.values()) {
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

   public Integer getPriority() {
      return this.priority;
   }

   public void setPriority(final Integer priority) {
      this.priority = priority;
   }
}
