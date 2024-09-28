/**
 *
 */
package com.healthcare.encore.dbmanager;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.healthcare.encore.model.Candidate;
import com.healthcare.encore.model.MedicalEmployerExtendedInfo;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.SpecialityTypeEnum;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * 
 * @author mmeena
 *
 */
//@formatter:off
@Validated
public interface MedicalEmployerManager {

   /**
    * 
    * @param employerUserId
    * @return MedicalEmployerExtendedInfo
    */
   MedicalEmployerExtendedInfo getMedicalEmployerExtendedInfo(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId);

   /**
    * 
    * @return List<MedicalEmployerJobPosting>
    */
   List<MedicalEmployerJobPosting> getAllMedicalEmployerJobPostings(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId);

   /**
    * 
    * @param employerUserId
    * @param jobPostingId
    * @return MedicalEmployerJobPosting
    */
   MedicalEmployerJobPosting getMedicalEmployerJobPosting(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId,
            @NotNull(message = "jobPostingId cannot be null")
            @Valid
            Integer jobPostingId);
   
   Integer getCandidatesSearchResults(
         @Valid
         Integer lastLogin,
         @Valid
         String title,
         @Valid
         SpecialityTypeEnum speciality,
         @Valid
         USStatesTypeEnum location);
   
   List<Candidate> getCandidatesSearchResults(
         @Valid
         Integer lastLogin,
         @Valid
         String title,
         @Valid
         SpecialityTypeEnum speciality,
         @Valid
         USStatesTypeEnum location,
         String p1, String p1Value,
         String p2, String p2Vvalue,
         String p3, String p3Value,
         String p4, String p4Value,
         String p5, String p5Value);

   /**
    * Updates the medical employer extended info to the database
    *
    * @param user user
    */
   void saveOrUpdateMedicalEmployerExtendedInfo(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId,
            @NotNull(message = "medicalEmployerExtendedInfo cannot be null")
            @Valid
            MedicalEmployerExtendedInfo medicalEmployerExtendedInfo);

   /**
    * 
    * @param employerUserId
    * @param medicalEmployerJobPosting
    */
   void saveOrUpdateMedicalEmployerJobPosting(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId,
            @NotNull(message = "medicalEmployerJobPosting cannot be null")
            @Valid
            MedicalEmployerJobPosting medicalEmployerJobPosting);

   /**
    * 
    * @param employerUserId
    * @return
    */
   void deleteMedicalEmployerExtendedInfo(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId);

   /**
    * 
    * @param employerUserId
    * @param jobPostingId
    * @return
    */
   void deleteMedicalEmployerJobPosting(
            @NotNull(message = "employerUserId cannot be null")
            @Valid
            Integer employerUserId,
            @NotNull(message = "jobPostingId cannot be null")
            @Valid
            Integer jobPostingId);
}
//@formatter:on
