/**
 *
 */
package com.healthcare.encore.webservice.controller;

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

import com.healthcare.encore.dbmanager.MedicalJobSeekerManager;
import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.MedicalJobSeekerExtendedInfo;
import com.healthcare.encore.model.MedicalJobSeekerJobApplicationInfo;
import com.healthcare.encore.model.MedicalJobSeekerJobInfo;
import com.healthcare.encore.model.MedicalJobSeekerSavedJob;
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
@RequestMapping(value = "api/")
public class MedicalJobSeekerController {

   @Autowired
   private MedicalJobSeekerManager medicalJobSeekerManager;
   
   @Autowired
   private SecurityManager securityManager;
   
   @Autowired
   private UserManager userManager;

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/extendedInfo", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public MedicalJobSeekerExtendedInfo getExtInfo(@PathVariable final Integer jobSeekerUserId) {
      this.checkAccess(jobSeekerUserId);
      MedicalJobSeekerExtendedInfo extInfo = this.medicalJobSeekerManager.getMedicalJobSeekerExtendedInfo(jobSeekerUserId);
      if (extInfo == null) {
         throw new ResourceNotFoundException("Medical Job Seeker Extended Info not found [userId=" + jobSeekerUserId + "]");
      }
      return extInfo;
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/jobInfos", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public List<MedicalJobSeekerJobInfo> getAllJobInfo(@PathVariable final Integer jobSeekerUserId) {
      this.checkAccess(jobSeekerUserId);
      return this.medicalJobSeekerManager.getAllMedicalJobSeekerJobInfo(jobSeekerUserId);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/jobInfos/{jobInfoId}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public MedicalJobSeekerJobInfo getJobInfo(@PathVariable final Integer jobSeekerUserId, @PathVariable final Integer jobInfoId) {
      this.checkAccess(jobSeekerUserId);
      MedicalJobSeekerJobInfo jobInfo = this.medicalJobSeekerManager.getMedicalJobSeekerJobInfo(jobSeekerUserId, jobInfoId);
      if (jobInfo == null) {
         throw new ResourceNotFoundException(
                  "Medical Job Seeker Job Info not found [userId=" + jobSeekerUserId + ", jobInfoId=" + jobInfoId + "]");
      }
      return jobInfo;
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/savedJobs", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public List<MedicalJobSeekerSavedJob> getAllSavedJobs(@PathVariable final Integer jobSeekerUserId) {
      this.checkAccess(jobSeekerUserId);
      return this.medicalJobSeekerManager.getAllMedicalJobSeekerSavedJob(jobSeekerUserId);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/savedJobs/{jobPostingId}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public MedicalJobSeekerSavedJob getSavedJob(@PathVariable final Integer jobSeekerUserId,
            @PathVariable final Integer jobPostingId) {
      this.checkAccess(jobSeekerUserId);
      MedicalJobSeekerSavedJob jobInfo = this.medicalJobSeekerManager.getMedicalJobSeekerSavedJob(jobSeekerUserId, jobPostingId);
      if (jobInfo == null) {
         throw new ResourceNotFoundException(
                  "Medical Job Seeker Saved Job not found [userId=" + jobSeekerUserId + ", jobPostingId=" + jobPostingId + "]");
      }
      return jobInfo;
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/application/jobs", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public List<MedicalJobSeekerJobApplicationInfo> getAllJobApplicationInfo(
            @PathVariable final Integer jobSeekerUserId) {
      this.checkAccess(jobSeekerUserId);
      return this.medicalJobSeekerManager.getAllMedicalJobSeekerJobApplicationInfo(jobSeekerUserId);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/application/jobs/{jobPostingId}", 
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public MedicalJobSeekerJobApplicationInfo getJobApplicationInfo(
            @PathVariable final Integer jobSeekerUserId,
            @PathVariable final Integer jobPostingId) {
      this.checkAccess(jobSeekerUserId);
      MedicalJobSeekerJobApplicationInfo jobApplicationInfo = this.medicalJobSeekerManager
               .getMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobPostingId);
      if (jobApplicationInfo == null) {
         throw new ResourceNotFoundException(
            "Medical Job Seeker JobApplicationInfo not found [userId=" + jobSeekerUserId + ", jobPostingId=" + jobPostingId + "]");
      }
      return jobApplicationInfo;
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/jobs", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
   public List<MedicalEmployerJobPosting> getUserJobSearchResults(
            @PathVariable final Integer jobSeekerUserId,
            @RequestParam(value = "age", required = false) final Integer age,
            @RequestParam(value = "title", required = false) final String title,
            @RequestParam(value = "speciality", required = false) final String speciality,
            @RequestParam(value = "location", required = false) final String location) {
      this.checkAccess(jobSeekerUserId);
      USStatesTypeEnum loc = StringUtils.isBlank(location) ? null : USStatesTypeEnum.fromName(location);
      return this.medicalJobSeekerManager.getMedicalJobsByUserSearch(jobSeekerUserId, age, title, speciality, loc);
   }

   @RequestMapping(value = "jobs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<MedicalEmployerJobPosting> getJobSearchResults(@RequestParam(value = "age", required = false) final Integer age,
            @RequestParam(value = "title", required = false) final String title,
            @RequestParam(value = "speciality", required = false) final String speciality,
            @RequestParam(value = "location", required = false) final String location) {
      USStatesTypeEnum loc = StringUtils.isBlank(location) ? null : USStatesTypeEnum.fromName(location);
      return this.medicalJobSeekerManager.getMedicalJobsBySearch(age, title, speciality, loc);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/extendedInfo", method = RequestMethod.PUT, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateAllExtInfo(@PathVariable final Integer jobSeekerUserId,
            @RequestBody final MedicalJobSeekerExtendedInfo extInfo) {
      this.checkAccess(jobSeekerUserId);
      MedicalJobSeekerExtendedInfo updatedExtInfo = this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerExtendedInfo(jobSeekerUserId,
               extInfo);
      return new ResponseEntity<Object>(updatedExtInfo, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/jobInfos/{jobInfoId}", method = RequestMethod.PUT, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateJobInfo(@PathVariable final Integer jobSeekerUserId,
            @PathVariable final Integer jobInfoId, @RequestBody final MedicalJobSeekerJobInfo jobInfo) {
      this.checkAccess(jobSeekerUserId);
      if (jobInfo.getMedicalJobSeekerJobInfoId() != null && !jobInfo.getMedicalJobSeekerJobInfoId().equals(jobInfoId)) {
         throw new IllegalArgumentException("MedicalJobSeekerJobInfo Id " + jobInfoId + "  is different from request body");
      }
      this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerJobInfo(jobSeekerUserId, jobInfo);
      return new ResponseEntity<Object>(jobInfo, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/jobInfos", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateAllJobInfo(@PathVariable final Integer jobSeekerUserId,
            @RequestBody final List<MedicalJobSeekerJobInfo> jobInfos) {
      this.checkAccess(jobSeekerUserId);
      for (MedicalJobSeekerJobInfo jobInfo : jobInfos) {
         this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerJobInfo(jobSeekerUserId, jobInfo);
      }
      return new ResponseEntity<Object>(jobInfos, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/savedJobs/{jobPostingId}", method = RequestMethod.PUT, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateSavedJob(@PathVariable final Integer jobSeekerUserId,
            @PathVariable final Integer jobPostingId, @RequestBody final MedicalJobSeekerSavedJob savedJob) {
      this.checkAccess(jobSeekerUserId);
      Integer requestBodyJobPostingId = savedJob.getJobPostingId();
      if (requestBodyJobPostingId != null && !requestBodyJobPostingId.equals(jobPostingId)) {
         throw new IllegalArgumentException("MedicalJobSeekerSavedJob Id " + jobPostingId + "  is different from request body");
      }
      this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerSavedJob(jobSeekerUserId, savedJob);
      return new ResponseEntity<Object>(savedJob, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/savedJobs", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateAllSavedJobs(@PathVariable final Integer jobSeekerUserId,
            @RequestBody final List<MedicalJobSeekerSavedJob> savedJobs) {
      this.checkAccess(jobSeekerUserId);
      for (MedicalJobSeekerSavedJob savedJob : savedJobs) {
         this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerSavedJob(jobSeekerUserId, savedJob);
      }
      return new ResponseEntity<Object>(savedJobs, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/application/jobs/{jobPostingId}", method = RequestMethod.PUT, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateJobApplicationInfo(
            @PathVariable final Integer jobSeekerUserId,
            @PathVariable final Integer jobPostingId,
            @RequestBody final MedicalJobSeekerJobApplicationInfo jobApplicationInfo) {
      this.checkAccess(jobSeekerUserId);
      if (jobApplicationInfo.getJobPostingId() != null && !jobApplicationInfo.getJobPostingId().equals(jobPostingId)) {
         throw new IllegalArgumentException("MedicalJobSeekerJobPosting Id " + jobPostingId + "  is different from request body");
      }
      this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobApplicationInfo);
      return new ResponseEntity<Object>(jobApplicationInfo, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/application/jobs", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object> saveOrUpdateAllJobApplicationInfo(
            @PathVariable final Integer jobSeekerUserId,
            @RequestBody final List<MedicalJobSeekerJobApplicationInfo> jobsApplicationInfo) {
      this.checkAccess(jobSeekerUserId);
      for(MedicalJobSeekerJobApplicationInfo jobApplicationInfo : jobsApplicationInfo) {
         this.medicalJobSeekerManager.saveOrUpdateMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobApplicationInfo);
      }
      return new ResponseEntity<Object>(jobsApplicationInfo, HttpStatus.OK);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/{extendedInfo}", method = RequestMethod.DELETE)
   public void deleteExtInfo(@PathVariable final Integer jobSeekerUserId) {
      this.checkAccess(jobSeekerUserId);
      this.medicalJobSeekerManager.deleteMedicalJobSeekerExtendedInfo(jobSeekerUserId);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/jobInfos/{jobInfoId}", method = RequestMethod.DELETE)
   public void deleteJobInfo(@PathVariable final Integer jobSeekerUserId, @PathVariable final Integer jobInfoId) {
      this.checkAccess(jobSeekerUserId);
      this.medicalJobSeekerManager.deleteMedicalJobSeekerJobInfo(jobSeekerUserId, jobInfoId);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/savedJobs/{jobPostingId}", method = RequestMethod.DELETE)
   public void deleteSavedJob(@PathVariable final Integer jobSeekerUserId, @PathVariable final Integer jobPostingId) {
      this.checkAccess(jobSeekerUserId);
      this.medicalJobSeekerManager.deleteMedicalJobSeekerSavedJob(jobSeekerUserId, jobPostingId);
   }

   @RequestMapping(value = "jobSeekers/{jobSeekerUserId}/application/jobs/{jobPostingId}", method = RequestMethod.DELETE)
   public void deleteJobApplicationInfo(
            @PathVariable final Integer jobSeekerUserId,
            @PathVariable final Integer jobPostingId) {
      this.checkAccess(jobSeekerUserId);
      this.medicalJobSeekerManager.deleteMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobPostingId);
   }

   private void checkAccess(final Integer userId) {
      Integer loggedInUserId = this.securityManager.getAuditUserId();
      User user = this.userManager.getUser(loggedInUserId);
      if ((userId != null && !loggedInUserId.equals(userId)) || !UserTypeEnum.JobSeeker.equals(user.getUserType())) {
         throw new AccessDeniedException("User " + user.getFirstName() + " does not have permission to access this resource.");
      }
   }
}
