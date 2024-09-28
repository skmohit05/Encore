/**
 *
 */
package com.healthcare.encore.dbmanager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.encore.dbmanager.MedicalJobSeekerManager;
import com.healthcare.encore.dbmanager.handler.MedicalJobSeekerHandler;
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
@Service
public class MedicalJobSeekerManagerImpl implements MedicalJobSeekerManager {

   @Autowired
   private MedicalJobSeekerHandler medicalJobSeekerHandler;

   @Override
   public MedicalJobSeekerExtendedInfo getMedicalJobSeekerExtendedInfo(final Integer jobSeekerUserId) {
      return this.medicalJobSeekerHandler.getMedicalJobSeekerExtendedInfo(jobSeekerUserId);
   }

   @Override
   public MedicalJobSeekerExtendedInfo saveOrUpdateMedicalJobSeekerExtendedInfo(final Integer jobSeekerUserId,
            final MedicalJobSeekerExtendedInfo extInfo) {
      return this.medicalJobSeekerHandler.saveOrUpdate(jobSeekerUserId, extInfo);
   }

   @Override
   public void deleteMedicalJobSeekerExtendedInfo(final Integer jobSeekerUserId) {
      this.medicalJobSeekerHandler.deleteMedicalJobSeekerExtendedInfo(jobSeekerUserId);
   }

   @Override
   public List<MedicalJobSeekerJobInfo> getAllMedicalJobSeekerJobInfo(final Integer jobSeekerUserId) {
      return this.medicalJobSeekerHandler.getAllMedicalJobSeekerJobInfo(jobSeekerUserId);
   }

   @Override
   public MedicalJobSeekerJobInfo getMedicalJobSeekerJobInfo(final Integer jobSeekerUserId, final Integer jobInfoId) {
      return this.medicalJobSeekerHandler.getMedicalJobSeekerJobInfo(jobSeekerUserId, jobInfoId);
   }

   @Override
   public List<MedicalJobSeekerSavedJob> getAllMedicalJobSeekerSavedJob(final Integer jobSeekerUserId) {
      return this.medicalJobSeekerHandler.getAllMedicalJobSeekerSavedJobs(jobSeekerUserId);
   }

   @Override
   public MedicalJobSeekerSavedJob getMedicalJobSeekerSavedJob(final Integer jobSeekerUserId, final Integer jobPostingId) {
      return this.medicalJobSeekerHandler.getMedicalJobSeekerSavedJob(jobSeekerUserId, jobPostingId);
   }

   @Override
   public List<MedicalEmployerJobPosting> getMedicalJobsBySearch(final Integer age, final String title, final String speciality,
            final USStatesTypeEnum location) {
      return this.medicalJobSeekerHandler.getMedicalJobsBySearch(age, title, speciality, location);
   }

   @Override
   public List<MedicalEmployerJobPosting> getMedicalJobsByUserSearch(final Integer jobSeekerUserId, final Integer age, final String title,
            final String speciality, final USStatesTypeEnum location) {
      return this.medicalJobSeekerHandler.getMedicalJobsByUserSearch(jobSeekerUserId, age, title, speciality, location);
   }

   @Override
   public void saveOrUpdateMedicalJobSeekerJobInfo(final Integer jobSeekerUserId,
            final MedicalJobSeekerJobInfo jobInfo) {
      this.medicalJobSeekerHandler.saveOrUpdate(jobSeekerUserId, jobInfo);
   }

   @Override
   public void saveOrUpdateMedicalJobSeekerSavedJob(final Integer jobSeekerUserId, final MedicalJobSeekerSavedJob savedJob) {
      this.medicalJobSeekerHandler.saveOrUpdateMedicalJobSeekerSavedJob(jobSeekerUserId, savedJob);
   }

   @Override
   public void deleteMedicalJobSeekerJobInfo(final Integer jobSeekerUserId, final Integer jobInfoId) {
      this.medicalJobSeekerHandler.deleteMedicalJobSeekerJobInfo(jobSeekerUserId, jobInfoId);
   }

   @Override
   public void deleteMedicalJobSeekerSavedJob(final Integer jobSeekerUserId, final Integer jobPostingId) {
      this.medicalJobSeekerHandler.deleteMedicalJobSeekerSavedJob(jobSeekerUserId, jobPostingId);
   }

   @Override
   public List<MedicalJobSeekerJobApplicationInfo> getAllMedicalJobSeekerJobApplicationInfo(final Integer jobSeekerUserId) {
      return this.medicalJobSeekerHandler.getAllMedicalJobSeekerJobApplicationInfo(jobSeekerUserId);
   }

   @Override
   public MedicalJobSeekerJobApplicationInfo getMedicalJobSeekerJobApplicationInfo(final Integer jobSeekerUserId,
            final Integer jobPostingId) {
      return this.medicalJobSeekerHandler.getMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobPostingId);
   }

   @Override
   public void saveOrUpdateMedicalJobSeekerJobApplicationInfo(final Integer jobSeekerUserId,
            final MedicalJobSeekerJobApplicationInfo jobApplicationInfo) {
      this.medicalJobSeekerHandler.saveOrUpdateMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobApplicationInfo);
   }

   @Override
   public void deleteMedicalJobSeekerJobApplicationInfo(final Integer jobSeekerUserId, final Integer jobPostingId) {
      this.medicalJobSeekerHandler.deleteMedicalJobSeekerJobApplicationInfo(jobSeekerUserId, jobPostingId);
   }
}
