package com.healthcare.encore.dbmanager.common;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.healthcare.encore.model.MedicalEmployerJobPosting;

/**
 *
 * @author mmeena
 *
 */
@Component
public class JobComparator implements Comparator<MedicalEmployerJobPosting>{
   
   private double getRank(final MedicalEmployerJobPosting job) {
      int malpractice = 1;
      int supervised = 1;
      int prescAuth = 1;
      int experience = job.getYearsExperience() == null ? 0 : job.getYearsExperience();
      int comp = job.getCompensation() == null ? 0 : job.getCompensation();
      double numerator = (0.28 * experience) + (0.22 * comp) + (0.19 * malpractice) + (0.18 * supervised) + (0.13 * prescAuth);
      double denominator = (0.18 * experience) + (0.29 * comp);
      return denominator == 0 ? 0 : numerator / denominator;
   }

   @Override
   public int compare(final MedicalEmployerJobPosting job1, final MedicalEmployerJobPosting job2) {
      return Double.compare(this.getRank(job1), this.getRank(job2));
   }

}
