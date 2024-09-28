/**
 *
 */
package com.healthcare.encore.dbmanager;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.MedicalJobSeekerExtendedInfo;
import com.healthcare.encore.model.MedicalJobSeekerJobApplicationInfo;
import com.healthcare.encore.model.MedicalJobSeekerJobInfo;
import com.healthcare.encore.model.MedicalJobSeekerSavedJob;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * 
 * @author mmeena
 *
 */
//@formatter:off
@Validated
public interface MedicalJobSeekerManager {

   /**
    * 
    * @param jobSeekerUserId
    * @return MedicalJobSeekerExtendedInfo
    */
   MedicalJobSeekerExtendedInfo getMedicalJobSeekerExtendedInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId);

   /**
    * 
    * @return List<MedicalJobSeekerJobInfo>
    */
   List<MedicalJobSeekerJobInfo> getAllMedicalJobSeekerJobInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId);

   /**
    * 
    * @param jobInfoId
    * @return MedicalJobSeekerJobInfo
    */
   MedicalJobSeekerJobInfo getMedicalJobSeekerJobInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "jobInfoId cannot be null")
            @Valid
            Integer jobInfoId);

   List<MedicalJobSeekerSavedJob> getAllMedicalJobSeekerSavedJob(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId);

   MedicalJobSeekerSavedJob getMedicalJobSeekerSavedJob(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "jobPostingId cannot be null")
            @Valid
            Integer jobPostingId);
   
   List<MedicalJobSeekerJobApplicationInfo> getAllMedicalJobSeekerJobApplicationInfo(
         @NotNull(message = "jobSeekerUserId cannot be null")
         @Valid
         Integer jobSeekerUserId);
   
   MedicalJobSeekerJobApplicationInfo getMedicalJobSeekerJobApplicationInfo(
         @NotNull(message = "jobSeekerUserId cannot be null")
         @Valid
         Integer jobSeekerUserId,
         @NotNull(message = "jobPostingId cannot be null")
         @Valid
         Integer jobPostingId);
   
   List<MedicalEmployerJobPosting> getMedicalJobsBySearch(
         @Valid
         Integer age,
         @Valid
         String title,
         @Valid
         String speciality,
         @Valid
         USStatesTypeEnum location);
   
   List<MedicalEmployerJobPosting> getMedicalJobsByUserSearch(
         @NotNull(message = "jobSeekerUserId cannot be null")
         @Valid
         Integer jobSeekerUserId,
         @Valid
         Integer age,
         @Valid
         String title,
         @Valid
         String speciality,
         @Valid
         USStatesTypeEnum location);

   /**
    * Updates the medical job seeker extended info to the database
    *
    * @param user user
    */
   MedicalJobSeekerExtendedInfo saveOrUpdateMedicalJobSeekerExtendedInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "medicalJobSeekerExtendedInfo cannot be null")
            @Valid
            MedicalJobSeekerExtendedInfo medicalJobSeekerExtendedInfo);

   /**
    * 
    * @param jobInfoId
    * @param jobInfo
    */
   void saveOrUpdateMedicalJobSeekerJobInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "jobInfo cannot be null")
            @Valid
            MedicalJobSeekerJobInfo jobInfo);

   /**
    * 
    * @param jobInfoId
    * @param jobInfo
    */
   void saveOrUpdateMedicalJobSeekerSavedJob(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "savedJob cannot be null")
            @Valid
            MedicalJobSeekerSavedJob savedJob);

   /**
    * 
    * @param jobInfoId
    * @param jobApplicationInfo
    */
   void saveOrUpdateMedicalJobSeekerJobApplicationInfo(
         @NotNull(message = "jobSeekerUserId cannot be null")
         @Valid
         Integer jobSeekerUserId,
         @NotNull(message = "savedJob cannot be null")
         @Valid
         MedicalJobSeekerJobApplicationInfo jobApplicationInfo);

   /**
    * 
    * @param jobSeekerUserId
    * @return
    */
   void deleteMedicalJobSeekerExtendedInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId);

   /**
    * 
    * @param jobInfo
    */
   void deleteMedicalJobSeekerJobInfo(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "jobInfoId cannot be null")
            @Valid
            Integer jobInfoId);

   void deleteMedicalJobSeekerSavedJob(
            @NotNull(message = "jobSeekerUserId cannot be null")
            @Valid
            Integer jobSeekerUserId,
            @NotNull(message = "jobPostingId cannot be null")
            @Valid
            Integer jobPostingId);
   
   void deleteMedicalJobSeekerJobApplicationInfo(
         @NotNull(message = "jobSeekerUserId cannot be null")
         @Valid
         Integer jobSeekerUserId,
         @NotNull(message = "jobPostingId cannot be null")
         @Valid
         Integer jobPostingId);
}
//@formatter:on
