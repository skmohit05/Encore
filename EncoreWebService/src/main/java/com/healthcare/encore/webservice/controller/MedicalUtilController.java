/**
 *
 */
package com.healthcare.encore.webservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.encore.model.AssignmentTypeEnum;
import com.healthcare.encore.model.CompensationTypeEnum;
import com.healthcare.encore.model.FacilityTypeEnum;
import com.healthcare.encore.model.JobTypeEnum;
import com.healthcare.encore.model.OrganizationTypeEnum;
import com.healthcare.encore.model.PriorityFeatureTypeEnum;
import com.healthcare.encore.model.ShiftTypeEnum;
import com.healthcare.encore.model.SpecialityTypeEnum;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * 
 * @author mmeena
 *
 */
@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalUtilController {

   @RequestMapping(value = "organizationTypes", method = RequestMethod.GET)
   public OrganizationTypeEnum[] getAllOrganizationTypes() {
      return OrganizationTypeEnum.values();
   }

   @RequestMapping(value = "facilityTypes", method = RequestMethod.GET)
   public FacilityTypeEnum[] getAllFacilityTypes() {
      return FacilityTypeEnum.values();
   }

   @RequestMapping(value = "specialityTypes", method = RequestMethod.GET)
   public SpecialityTypeEnum[] getAllSpecialityTypes() {
      return SpecialityTypeEnum.values();
   }

   @RequestMapping(value = "jobTypes", method = RequestMethod.GET)
   public JobTypeEnum[] getAllJobTypes() {
      return JobTypeEnum.values();
   }

   @RequestMapping(value = "uSStatesTypes", method = RequestMethod.GET)
   public USStatesTypeEnum[] getAllUSStatesTypes() {
      return USStatesTypeEnum.values();
   }

   @RequestMapping(value = "shiftTypes", method = RequestMethod.GET)
   public ShiftTypeEnum[] getAllShiftTypes() {
      return ShiftTypeEnum.values();
   }

   @RequestMapping(value = "assignmentTypes", method = RequestMethod.GET)
   public AssignmentTypeEnum[] getAllAssignmentTypes() {
      return AssignmentTypeEnum.values();
   }

   @RequestMapping(value = "priorityFeatureTypes", method = RequestMethod.GET)
   public PriorityFeatureTypeEnum[] getAllPriorityFeatureTypes() {
      return PriorityFeatureTypeEnum.values();
   }

   @RequestMapping(value = "compensationTypes", method = RequestMethod.GET)
   public CompensationTypeEnum[] getAllCompensationTypes() {
      return CompensationTypeEnum.values();
   }

}
