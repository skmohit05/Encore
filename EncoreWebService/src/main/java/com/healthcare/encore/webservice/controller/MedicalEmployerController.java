/**
 *
 */
package com.healthcare.encore.webservice.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.encore.dbmanager.MedicalEmployerManager;
import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.Candidate;
import com.healthcare.encore.model.MedicalEmployerExtendedInfo;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.SpecialityTypeEnum;
import com.healthcare.encore.model.USStatesTypeEnum;
import com.healthcare.encore.model.User;
import com.healthcare.encore.model.UserTypeEnum;
import com.healthcare.encore.security.SecurityManager;
import com.healthcare.encore.webservice.exception.ResourceNotFoundException;

/**
 * 
 * @author mmeena
 *
 */
@RestController
@RequestMapping(value = "api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalEmployerController {

   @Autowired
   private MedicalEmployerManager medicalEmployerManager;
   
   @Autowired
   private SecurityManager securityManager;
   
   @Autowired
   private UserManager userManager;

   @RequestMapping(value = "employers/{employerUserId}/extendedInfo", method = RequestMethod.GET)
   public MedicalEmployerExtendedInfo getExtInfo(@PathVariable final Integer employerUserId) {
      this.checkAccess(employerUserId);
      MedicalEmployerExtendedInfo extInfo = this.medicalEmployerManager.getMedicalEmployerExtendedInfo(employerUserId);
      if (extInfo == null) {
         throw new ResourceNotFoundException("Medical Employer Extended Info not found [userId=" + employerUserId + "]");
      }
      return extInfo;
   }

   @RequestMapping(value = "employers/{employerUserId}/jobs", method = RequestMethod.GET)
   public List<MedicalEmployerJobPosting> getAllJobPostings(@PathVariable final Integer employerUserId) {
      this.checkAccess(employerUserId);
      List<MedicalEmployerJobPosting> jobPostings = this.medicalEmployerManager.getAllMedicalEmployerJobPostings(employerUserId);
      Collections.sort(jobPostings, new Comparator<MedicalEmployerJobPosting>() {
         @Override
         public int compare(final MedicalEmployerJobPosting o1, final MedicalEmployerJobPosting o2) {
            if (o2 == null || o2.getPostedDate() == null) {
               return -1;
            }
            if (o1.getPostedDate() == null) {
               return 1;
            }
            return o2.getPostedDate().compareTo(o1.getPostedDate());
         }
      });
      return jobPostings;
   }

   @RequestMapping(value = "employers/{employerUserId}/jobs/{jobPostingId}", method = RequestMethod.GET)
   public MedicalEmployerJobPosting getJobPosting(@PathVariable final Integer employerUserId,
            @PathVariable final Integer jobPostingId) {
      this.checkAccess(employerUserId);
      return this.medicalEmployerManager.getMedicalEmployerJobPosting(employerUserId, jobPostingId);
   }

   @RequestMapping(value = "candidates", method = RequestMethod.GET)
   public Integer getCandidatesSearchResults(
            @RequestParam(value = "lastLogin", required = false) final Integer lastLogin,
            @RequestParam(value = "title", required = false) final String title,
            @RequestParam(value = "speciality", required = false) final String speciality,
            @RequestParam(value = "location", required = false) final String location) {
      if(StringUtils.isNotBlank(location) && USStatesTypeEnum.fromName(location) == null) {
         throw new IllegalArgumentException("Invalid value passed for location parameter");
      }
      if(StringUtils.isNotBlank(speciality) && SpecialityTypeEnum.fromName(speciality) == null) {
         throw new IllegalArgumentException("Invalid value passed for speciality parameter");
      }
      
      USStatesTypeEnum loc = USStatesTypeEnum.fromName(location);
      SpecialityTypeEnum spec = SpecialityTypeEnum.fromName(speciality);
      return this.medicalEmployerManager.getCandidatesSearchResults(lastLogin, title, spec, loc);
   }

   @RequestMapping(value = "employers/{employerUserId}/candidates", method = RequestMethod.GET)
   public List<Candidate> getCandidatesUserSearchResults(
            @PathVariable final Integer employerUserId,
            @RequestParam(value = "lastLogin", required = false) final Integer lastLogin,
            @RequestParam(value = "title", required = false) final String title,
            @RequestParam(value = "speciality", required = false) final String speciality,
            @RequestParam(value = "location", required = false) final String location,
            @RequestParam(value = "P1", required = false) final String p1,
            @RequestParam(value = "P1value", required = false) final String p1Value,
            @RequestParam(value = "P2", required = false) final String p2,
            @RequestParam(value = "P2value", required = false) final String p2Value,
            @RequestParam(value = "P3", required = false) final String p3,
            @RequestParam(value = "P3value", required = false) final String p3Value,
            @RequestParam(value = "P4", required = false) final String p4,
            @RequestParam(value = "P4value", required = false) final String p4Value,
            @RequestParam(value = "P5", required = false) final String p5,
            @RequestParam(value = "P5value", required = false) final String p5Value) {
      this.checkAccess(employerUserId);
      
      if(StringUtils.isNotBlank(location) && USStatesTypeEnum.fromName(location) == null) {
         throw new IllegalArgumentException("Invalid value passed for location parameter");
      }
      if(StringUtils.isNotBlank(speciality) && SpecialityTypeEnum.fromName(speciality) == null) {
         throw new IllegalArgumentException("Invalid value passed for speciality parameter");
      }
      
      USStatesTypeEnum loc = USStatesTypeEnum.fromName(location);
      SpecialityTypeEnum spec = SpecialityTypeEnum.fromName(speciality);
      return this.medicalEmployerManager.getCandidatesSearchResults(lastLogin, title, spec, loc, p1, p1Value, 
               p2, p2Value, p3, p3Value, p4, p4Value, p5, p5Value);
   }

   @RequestMapping(value = "employers/{employerUserId}/extendedInfo", method = RequestMethod.PUT, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateExtInfo(@PathVariable final Integer employerUserId,
            @RequestBody final MedicalEmployerExtendedInfo extInfo) {
      this.checkAccess(employerUserId);
      this.medicalEmployerManager.saveOrUpdateMedicalEmployerExtendedInfo(employerUserId, extInfo);
      return new ResponseEntity<Object>(extInfo, HttpStatus.OK);
   }

   @RequestMapping(value = "employers/{employerUserId}/jobs/{jobPostingId}", method = RequestMethod.PUT, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateJobPosting(@PathVariable final Integer employerUserId,
            @PathVariable final Integer jobPostingId, @RequestBody final MedicalEmployerJobPosting jobPosting) {
      this.checkAccess(employerUserId);
      if (jobPosting.getMedicalEmployerJobPostingId() != null
               && !jobPosting.getMedicalEmployerJobPostingId().equals(jobPostingId)) {
         throw new IllegalArgumentException("MedicalEmployerJobPosting Id " + jobPostingId + "  is different from request body");
      }
      this.medicalEmployerManager.saveOrUpdateMedicalEmployerJobPosting(employerUserId, jobPosting);
      return new ResponseEntity<Object>(jobPosting, HttpStatus.OK);
   }

   @RequestMapping(value = "employers/{employerUserId}/jobs", method = RequestMethod.POST, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateAllJobPostings(@PathVariable final Integer employerUserId,
            @RequestBody final List<MedicalEmployerJobPosting> jobInfos) {
      this.checkAccess(employerUserId);
      for (MedicalEmployerJobPosting jobInfo : jobInfos) {
         this.medicalEmployerManager.saveOrUpdateMedicalEmployerJobPosting(employerUserId, jobInfo);
      }
      return new ResponseEntity<Object>(jobInfos, HttpStatus.OK);
   }

   @RequestMapping(value = "employers/{employerUserId}/extendedInfo", method = RequestMethod.DELETE)
   public void deleteExtInfo(@PathVariable final Integer employerUserId) {
      this.checkAccess(employerUserId);
      this.medicalEmployerManager.deleteMedicalEmployerExtendedInfo(employerUserId);
   }

   @RequestMapping(value = "employers/{employerUserId}/jobs/{jobPostingId}", method = RequestMethod.DELETE)
   public void deleteJobPosting(@PathVariable final Integer employerUserId, @PathVariable final Integer jobPostingId) {
      this.checkAccess(employerUserId);
      this.medicalEmployerManager.deleteMedicalEmployerJobPosting(employerUserId, jobPostingId);
   }

   private void checkAccess(final Integer userId) {
      Integer loggedInUserId = this.securityManager.getAuditUserId();
      User user = this.userManager.getUser(loggedInUserId);
      if ((userId != null && !loggedInUserId.equals(userId)) || !UserTypeEnum.Employer.equals(user.getUserType())) {
         throw new AccessDeniedException("User " + user.getFirstName() + " does not have permission to access this resource.");
      }
   }

}
