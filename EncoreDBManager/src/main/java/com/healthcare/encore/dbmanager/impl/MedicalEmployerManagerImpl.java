/**
 *
 */
package com.healthcare.encore.dbmanager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.encore.dbmanager.MedicalEmployerManager;
import com.healthcare.encore.dbmanager.handler.MedicalEmployerHandler;
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
@Service
public class MedicalEmployerManagerImpl implements MedicalEmployerManager {

   @Autowired
   private MedicalEmployerHandler medicalEmployerHandler;

   @Override
   public MedicalEmployerExtendedInfo getMedicalEmployerExtendedInfo(final Integer employerUserId) {
      return this.medicalEmployerHandler.getMedicalEmployerExtendedInfo(employerUserId);
   }

   @Override
   public void saveOrUpdateMedicalEmployerExtendedInfo(final Integer employerUserId, final MedicalEmployerExtendedInfo extInfo) {
      this.medicalEmployerHandler.saveOrUpdate(employerUserId, extInfo);
   }

   @Override
   public void deleteMedicalEmployerExtendedInfo(final Integer employerUserId) {
      this.medicalEmployerHandler.deleteMedicalEmployerExtendedInfo(employerUserId);
   }

   @Override
   public List<MedicalEmployerJobPosting> getAllMedicalEmployerJobPostings(final Integer employerUserId) {
      return this.medicalEmployerHandler.getAllMedicalEmployerJobPostings(employerUserId);
   }

   @Override
   public MedicalEmployerJobPosting getMedicalEmployerJobPosting(final Integer employerUserId, final Integer jobPostingId) {
      return this.medicalEmployerHandler.getMedicalEmployerJobPosting(employerUserId, jobPostingId);
   }

   @Override
   public void saveOrUpdateMedicalEmployerJobPosting(final Integer employerUserId,
            final MedicalEmployerJobPosting medicalEmployerJobPosting) {
      this.medicalEmployerHandler.saveOrUpdateMedicalEmployerJobPosting(employerUserId, medicalEmployerJobPosting);
   }

   @Override
   public void deleteMedicalEmployerJobPosting(final Integer employerUserId, final Integer jobPostingId) {
      this.medicalEmployerHandler.deleteMedicalEmployerJobPosting(employerUserId, jobPostingId);
   }

   @Override
   public Integer getCandidatesSearchResults(final Integer lastLogin, final String title, final SpecialityTypeEnum speciality,
            final USStatesTypeEnum location) {
      return this.medicalEmployerHandler.getCandidatesSearchResults(lastLogin, title, speciality, location);
   }

   @Override
   public List<Candidate> getCandidatesSearchResults(final Integer lastLogin, final String title, final SpecialityTypeEnum speciality,
            final USStatesTypeEnum location, final String p1, final String p1Value, final String p2, final String p2Value, final String p3,
            final String p3Value, final String p4, final String p4Value, final String p5, final String p5Value) {
      return this.medicalEmployerHandler.getCandidatesSearchResults(lastLogin, title, speciality, location, p1, p1Value, p2, p2Value, p3,
               p3Value, p4, p4Value, p5, p5Value);
   }
}
