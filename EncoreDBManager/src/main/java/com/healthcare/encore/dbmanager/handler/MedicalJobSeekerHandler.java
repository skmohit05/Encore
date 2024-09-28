/**
 *
 */
package com.healthcare.encore.dbmanager.handler;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.encore.commons.mailservice.JavaMailContent;
import com.healthcare.encore.commons.mailservice.JavaMailService;
import com.healthcare.encore.db.dao.MedicalEmployerJobPostingDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerExtendedInfoDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerJobApplicationInfoDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerJobInfoDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerJobsDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerSavedJobsDAO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobApplicationInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobInfoDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerJobsDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerSavedJobDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.JobComparator;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.dbmanager.mapper.MedicalEmployerJobPostingMapper;
import com.healthcare.encore.dbmanager.mapper.MedicalJobSeekerExtendedInfoMapper;
import com.healthcare.encore.dbmanager.mapper.MedicalJobSeekerJobApplicationInfoMapper;
import com.healthcare.encore.dbmanager.mapper.MedicalJobSeekerJobInfoMapper;
import com.healthcare.encore.dbmanager.mapper.MedicalJobSeekerSavedJobMapper;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.MedicalJobSeekerExtendedInfo;
import com.healthcare.encore.model.MedicalJobSeekerJobApplicationInfo;
import com.healthcare.encore.model.MedicalJobSeekerJobInfo;
import com.healthcare.encore.model.MedicalJobSeekerSavedJob;
import com.healthcare.encore.model.MedicalJobSeekerStateLevelInfo;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * 
 * @author mmeena
 *
 */
@Component
@Transactional
public class MedicalJobSeekerHandler {
   private static final Logger LOG = Logger.getLogger(MedicalJobSeekerHandler.class);

   @Autowired
   private MedicalJobSeekerExtendedInfoDAO jsExtInfoDAO;

   @Autowired
   private MedicalJobSeekerJobInfoDAO jobInfoDAO;

   @Autowired
   private MedicalJobSeekerExtendedInfoMapper extInfoMapper;

   @Autowired
   private MedicalJobSeekerJobInfoMapper jobInfoMapper;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private MedicalJobSeekerJobsDAO medicalJobSeekerJobsDAO;

   @Autowired
   private MedicalJobSeekerSavedJobsDAO savedJobsDAO;

   @Autowired
   private MedicalJobSeekerSavedJobMapper savedJobMapper;

   @Autowired
   private MedicalJobSeekerJobApplicationInfoDAO jobApplicationInfoDAO;

   @Autowired
   private MedicalJobSeekerJobApplicationInfoMapper jobApplicationInfoMapper;

   @Autowired
   private MedicalEmployerJobPostingDAO meJobPostingDAO;

   @Autowired
   private MedicalEmployerJobPostingMapper meJobPostingMapper;

   public List<MedicalJobSeekerJobInfo> getAllMedicalJobSeekerJobInfo(final int jobSeekerUserId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      List<MedicalJobSeekerJobsDTO> jobsDTOs = this.medicalJobSeekerJobsDAO.findAll(userDTO);
      List<MedicalJobSeekerJobInfo> jobsInfo = this.jobInfoMapper.getModels(jobsDTOs);
      Collections.sort(jobsInfo);
      Collections.reverse(jobsInfo);
      return jobsInfo;
   }

   public MedicalJobSeekerJobInfo getMedicalJobSeekerJobInfo(final int jobSeekerUserId, final int jobInfoId) {
      this.setupMapperUtil.checkIfUserExists(jobSeekerUserId);
      MedicalJobSeekerJobInfoDTO jobInfoDTO = this.setupMapperUtil.getMedicalJobSeekerJobInfoDTO(jobInfoId, true);
      return jobInfoDTO == null ? null : this.jobInfoMapper.getModel(jobInfoDTO);
   }

   public MedicalJobSeekerExtendedInfo getMedicalJobSeekerExtendedInfo(final int jobSeekerUserId) {
      MedicalJobSeekerExtendedInfoDTO extInfoDTO = this.getExtInfoDTO(jobSeekerUserId);
      return extInfoDTO == null ? null : this.extInfoMapper.getModel(extInfoDTO);
   }

   public List<MedicalJobSeekerSavedJob> getAllMedicalJobSeekerSavedJobs(final int jobSeekerUserId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      List<MedicalJobSeekerSavedJobDTO> savedJobsDTOs = this.savedJobsDAO.findAll(userDTO);
      Collections.sort(savedJobsDTOs, new Comparator<MedicalJobSeekerSavedJobDTO>() {
         @Override
         public int compare(final MedicalJobSeekerSavedJobDTO o1, final MedicalJobSeekerSavedJobDTO o2) {
            return o2.getId().compareTo(o1.getId());
         }
      });
      return this.savedJobMapper.getModel(savedJobsDTOs);
   }

   public MedicalJobSeekerSavedJob getMedicalJobSeekerSavedJob(final int jobSeekerUserId, final int jobPostingId) {
      UserDTO jobSeekerUserDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPostingId, true);
      MedicalJobSeekerSavedJobDTO savedJobDTO = this.savedJobsDAO.findByJobPosting(jobSeekerUserDTO, jobPostingDTO);
      return savedJobDTO == null ? null : this.savedJobMapper.getModel(savedJobDTO);
   }

   public List<MedicalJobSeekerJobApplicationInfo> getAllMedicalJobSeekerJobApplicationInfo(final int jobSeekerUserId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      List<MedicalJobSeekerJobApplicationInfoDTO> jobApplicationDTOs = this.jobApplicationInfoDAO.findAll(userDTO);
      return this.jobApplicationInfoMapper.getModel(jobApplicationDTOs);
   }

   public MedicalJobSeekerJobApplicationInfo getMedicalJobSeekerJobApplicationInfo(final int jobSeekerUserId, final int jobPostingId) {
      UserDTO jobSeekerUserDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPostingId, true);
      MedicalJobSeekerJobApplicationInfoDTO jobApplicationInfoDTO = this.jobApplicationInfoDAO.findByJobPosting(jobSeekerUserDTO,
               jobPostingDTO);
      return jobApplicationInfoDTO == null ? null : this.jobApplicationInfoMapper.getModel(jobApplicationInfoDTO);
   }

   public List<MedicalEmployerJobPosting> getMedicalJobsBySearch(final Integer age, final String title, final String speciality,
            final USStatesTypeEnum location) {
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DAY_OF_YEAR, age == null ? -60 : -age);
      LocalDate date = age == null ? null : Instant.ofEpochMilli(cal.getTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
      String loc = location == null ? null : location.getName();
      List<MedicalEmployerJobPostingDTO> jobDtos = this.meJobPostingDAO.findByJobSeach(date, title, speciality, loc);

      List<MedicalEmployerJobPosting> jobs = this.meJobPostingMapper.getModel(jobDtos);
      Collections.sort(jobs);
      LOG.info("Found " + jobs.size() + " jobs matching with filters: " + this.getFilterString(age, title, speciality, location));
      return jobs;
   }

   // CHECKSTYLE:OFF
   public List<MedicalEmployerJobPosting> getMedicalJobsByUserSearch(final int jobSeekerUserId, final Integer age, final String title,
            final String speciality, final USStatesTypeEnum location) {
      List<MedicalEmployerJobPosting> jobs = this.getMedicalJobsBySearch(age, title, speciality, location);

      MedicalJobSeekerExtendedInfo extInfo = this.getMedicalJobSeekerExtendedInfo(jobSeekerUserId);
      if (extInfo != null) {
         jobs.removeIf(i -> this.isJobSeekerJobSearchMismatch(jobSeekerUserId, extInfo, i, location));
         Collections.sort(jobs, new JobComparator());
      }

      LOG.info("Found " + jobs.size() + " jobs matching for job seeker user id " + jobSeekerUserId + " with filters: "
               + this.getFilterString(age, title, speciality, location));
      return jobs;
   }

   private String getFilterString(final Integer age, final String title, final String speciality, final USStatesTypeEnum location) {
      List<String> filters = new ArrayList<>();
      if (age != null) {
         filters.add("age=" + age);
      }
      if (title != null && StringUtils.isNotBlank(title)) {
         filters.add("title=" + title);
      }
      if (speciality != null && StringUtils.isNotBlank(speciality)) {
         filters.add("specialty=" + speciality);
      }
      if (location != null) {
         filters.add("location=" + location.getDesc());
      }

      return filters.toString();
   }

   private boolean isJobSeekerJobSearchMismatch(final int jobSeekerUserId, final MedicalJobSeekerExtendedInfo extInfo,
            final MedicalEmployerJobPosting job, final USStatesTypeEnum location) {
      if (extInfo.getCompensation() != null && (job.getCompensation() == null || (job.getCompensation() < extInfo.getCompensation()))) {
         return true;
      }

      if (job.getYearsExperience() != null
               && (extInfo.getYearsExperience() == null || extInfo.getYearsExperience() < job.getYearsExperience())) {
         return true;
      }

      if (extInfo.isMalpractice() != null && extInfo.isMalpractice()
               && (job.isMalpracticeAccepted() == null || !job.isMalpracticeAccepted())) {
         return true;
      }

      List<MedicalJobSeekerJobInfo> jobInfos = this.getAllMedicalJobSeekerJobInfo(jobSeekerUserId);
      boolean supervision = (jobInfos.size() != 0 && jobInfos.get(0).isSupervised())
               || (jobInfos.size() >= 1 && jobInfos.get(1).isSupervised());

      if ((!supervision && job.isSupervised())) {
         return true;
      }

      if (location != null && !this.isJobSeekerHasPrescriptionAuthority(location, extInfo) && job.isPrescriptionAuthorityNeeded()) {
         return true;
      }

      return false;
   }

   public boolean isJobSeekerHasPrescriptionAuthority(final USStatesTypeEnum location, final MedicalJobSeekerExtendedInfo extInfo) {
      Map<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> stateLevelInfo = extInfo.getStateLevelInfo();
      boolean prescAuth = location != null && stateLevelInfo.get(location) != null
               && stateLevelInfo.get(location).isPrescriptionAuthority();
      if (!prescAuth) {
         for (Map.Entry<USStatesTypeEnum, MedicalJobSeekerStateLevelInfo> entry : stateLevelInfo.entrySet()) {
            if (entry.getValue().isPrescriptionAuthority()) {
               return true;
            }
         }
      }

      return prescAuth;
   }

   // CHECKSTYLE:ON
   public MedicalJobSeekerExtendedInfo saveOrUpdate(final int jobSeekerUserId, final MedicalJobSeekerExtendedInfo extInfo) {
      MedicalJobSeekerExtendedInfoDTO extInfoDTO = this.extInfoMapper.getDTO(jobSeekerUserId, extInfo);
      extInfoDTO = this.jsExtInfoDAO.makePersistent(extInfoDTO);
      return this.extInfoMapper.getModel(extInfoDTO);
   }

   public void saveOrUpdate(final int jobSeekerUserId, final MedicalJobSeekerJobInfo jobInfo) {
      MedicalJobSeekerJobInfoDTO jobInfoDTO = this.jobInfoMapper.getDTO(jobInfo);
      jobInfoDTO = this.jobInfoDAO.makePersistent(jobInfoDTO);
      this.saveMedicalJobSeekerJob(this.setupMapperUtil.getUserDTO(jobSeekerUserId, true), jobInfoDTO);
   }

   public void saveOrUpdateMedicalJobSeekerSavedJob(final Integer jobSeekerUserId, final MedicalJobSeekerSavedJob savedJob) {
      UserDTO jobSeekerUserDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      MedicalJobSeekerSavedJobDTO dto = this.savedJobMapper.getDTO(jobSeekerUserDTO, savedJob);
      this.savedJobsDAO.makePersistent(dto);
   }

   public void saveOrUpdateMedicalJobSeekerJobApplicationInfo(final Integer jobSeekerUserId,
            final MedicalJobSeekerJobApplicationInfo jobApplicationInfo) {
      UserDTO jobSeekerUserDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      MedicalJobSeekerJobApplicationInfoDTO dto = this.jobApplicationInfoMapper.getDTO(jobSeekerUserDTO, jobApplicationInfo);
      UserDTO employerUserDTO = dto.getEmployerJobAgreementSignedUserDTO();
      this.jobApplicationInfoDAO.makePersistent(dto);
      if (!jobApplicationInfo.isAccepted()) {
         String title = dto.getMedicalEmployerJobPostingDTO().getTitle();
         String jobSeekerFirstName = jobSeekerUserDTO.getFirstName();
         String jobSeekerFullName = jobSeekerUserDTO.getFirstName() + " " + jobSeekerUserDTO.getLastName();
         String employerFirstName = employerUserDTO.getFirstName();
         String employerOrgName = employerUserDTO.getOrganizationDTO() != null ? employerUserDTO.getOrganizationDTO().getOrganizationName()
                  : "";
         String jobSeekerAppliedJobSubject = "You successfully applied to " + title + " with " + employerOrgName;
         String employerAppliedJobSubject = "A potential candidate applied for the job " + title + " you posted";
         JavaMailService.sendEmail(jobSeekerUserDTO.getEmail(), jobSeekerAppliedJobSubject,
                  JavaMailContent.getJobSeekerAppliedJobMailContent(jobSeekerFirstName, employerOrgName, title));
         JavaMailService.sendEmail(employerUserDTO.getEmail(), employerAppliedJobSubject,
                  JavaMailContent.getEmployerAppliedJobMailContent(employerFirstName, jobSeekerFullName, title));
      }
   }

   public void deleteMedicalJobSeekerExtendedInfo(final int jobSeekerUserId) {
      MedicalJobSeekerExtendedInfoDTO extInfoDTO = this.getExtInfoDTO(jobSeekerUserId);
      this.jsExtInfoDAO.makeTransient(extInfoDTO);
   }

   public void deleteMedicalJobSeekerJobInfo(final int jobSeekerUserId, final int jobInfoId) {
      MedicalJobSeekerJobInfoDTO jobInfoDTO = this.setupMapperUtil.getMedicalJobSeekerJobInfoDTO(jobInfoId, true);
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId);
      MedicalJobSeekerJobsDTO entity = this.medicalJobSeekerJobsDAO.findByJobInfo(userDTO, jobInfoDTO);
      if (entity != null) {
         this.medicalJobSeekerJobsDAO.makeTransient(entity);
      }

      this.jobInfoDAO.makeTransient(jobInfoDTO);
   }

   public void deleteMedicalJobSeekerSavedJob(final Integer jobSeekerUserId, final Integer jobPostingId) {
      UserDTO jobSeekerUserDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPostingId, true);
      this.savedJobsDAO.makeTransient(this.savedJobsDAO.findByJobPosting(jobSeekerUserDTO, jobPostingDTO));
   }

   public void deleteMedicalJobSeekerJobApplicationInfo(final Integer jobSeekerUserId, final Integer jobPostingId) {
      UserDTO jobSeekerUserDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPostingId, true);
      this.jobApplicationInfoDAO.makeTransient(this.jobApplicationInfoDAO.findByJobPosting(jobSeekerUserDTO, jobPostingDTO));
   }

   private MedicalJobSeekerExtendedInfoDTO getExtInfoDTO(final int jobSeekerUserId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      return this.jsExtInfoDAO.findByUser(userDTO);
   }

   private void saveMedicalJobSeekerJob(final UserDTO userDTO, final MedicalJobSeekerJobInfoDTO jobInfoDTO) {
      MedicalJobSeekerJobsDTO entity = this.medicalJobSeekerJobsDAO.findByJobInfo(userDTO, jobInfoDTO);
      if (entity == null) {
         entity = new MedicalJobSeekerJobsDTO();
      }

      entity.setUserDTO(userDTO);
      entity.setMedicalJobSeekerJobInfoDTO(jobInfoDTO);
      this.medicalJobSeekerJobsDAO.makePersistent(entity);
   }
}
