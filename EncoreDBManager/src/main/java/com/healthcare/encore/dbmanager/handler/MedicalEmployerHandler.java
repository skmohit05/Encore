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
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.encore.db.dao.MedicalEmployerExtendedInfoDAO;
import com.healthcare.encore.db.dao.MedicalEmployerJobPostingDAO;
import com.healthcare.encore.db.dao.MedicalJobSeekerExtendedInfoDAO;
import com.healthcare.encore.db.dao.UserAuthenticationDAO;
import com.healthcare.encore.db.dto.EnumSpecialityTypeDTO;
import com.healthcare.encore.db.dto.MedicalEmployerExtendedInfoDTO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.MedicalJobSeekerExtendedInfoDTO;
import com.healthcare.encore.db.dto.UserAuthenticationDTO;
import com.healthcare.encore.db.dto.UserDTO;
import com.healthcare.encore.dbmanager.common.EnumMapperUtil;
import com.healthcare.encore.dbmanager.common.SetupMapperUtil;
import com.healthcare.encore.dbmanager.mapper.MedicalEmployerExtendedInfoMapper;
import com.healthcare.encore.dbmanager.mapper.MedicalEmployerJobPostingMapper;
import com.healthcare.encore.dbmanager.mapper.MedicalJobSeekerExtendedInfoMapper;
import com.healthcare.encore.model.Candidate;
import com.healthcare.encore.model.FacilityTypeEnum;
import com.healthcare.encore.model.MedicalEmployerExtendedInfo;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.MedicalJobSeekerJobInfo;
import com.healthcare.encore.model.PriorityFeatureTypeEnum;
import com.healthcare.encore.model.ShiftTypeEnum;
import com.healthcare.encore.model.SpecialityTypeEnum;
import com.healthcare.encore.model.USStatesTypeEnum;

/**
 * 
 * @author mmeena
 *
 */
@Component
@Transactional
public class MedicalEmployerHandler {
   private static final Logger LOG = Logger.getLogger(MedicalEmployerHandler.class);

   private static final String YEARS_OF_EXPERIENCE = PriorityFeatureTypeEnum.NumberOfYears.getDesc();
   private static final String SALARY = PriorityFeatureTypeEnum.Compensation.getDesc();
   private static final String SUPERVISION_REQUIRED = PriorityFeatureTypeEnum.Supervision.getDesc();
   private static final String PRESCRIPTION_AUTHORITY_REQUIRED = PriorityFeatureTypeEnum.PrescriptionAuthority.getDesc();
   private static final String SHIFT = PriorityFeatureTypeEnum.AssignmentShift.getDesc();
   private static final String MALPRACTICE_CANDIDATE_ACCEPTED = PriorityFeatureTypeEnum.MalpracticeCandidate.getDesc();
   private static final String FACILITY_TYPE = PriorityFeatureTypeEnum.FacilityType.getDesc();

   @Autowired
   private MedicalEmployerExtendedInfoDAO extInfoDAO;

   @Autowired
   private MedicalEmployerExtendedInfoMapper empExtInfoMapper;

   @Autowired
   private MedicalJobSeekerExtendedInfoMapper jsExtInfoMapper;

   @Autowired
   private SetupMapperUtil setupMapperUtil;

   @Autowired
   private MedicalEmployerJobPostingDAO jobPostingDAO;

   @Autowired
   private MedicalEmployerJobPostingMapper jobPostingMapper;

   @Autowired
   private MedicalJobSeekerExtendedInfoDAO jsExtInfoDAO;

   @Autowired
   private EnumMapperUtil enumMapperUtil;

   @Autowired
   private UserAuthenticationDAO userAuthenticationDAO;

   @Autowired
   private MedicalJobSeekerHandler jsHandler;

   public MedicalEmployerExtendedInfo getMedicalEmployerExtendedInfo(final int jobSeekerUserId) {
      MedicalEmployerExtendedInfoDTO extInfoDTO = this.getExtInfoDTO(jobSeekerUserId);
      return extInfoDTO == null ? null : this.empExtInfoMapper.getModel(extInfoDTO);
   }

   public List<MedicalEmployerJobPosting> getAllMedicalEmployerJobPostings(final int jobSeekerUserId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      List<MedicalEmployerJobPostingDTO> jobsDTOs = this.jobPostingDAO.findAll(userDTO);
      List<MedicalEmployerJobPosting> jobPostings = this.jobPostingMapper.getModel(jobsDTOs);
      Collections.sort(jobPostings);
      return jobPostings;
   }

   public MedicalEmployerJobPosting getMedicalEmployerJobPosting(final int jobSeekerUserId, final int jobPostingId) {
      this.setupMapperUtil.checkIfUserExists(jobSeekerUserId);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.setupMapperUtil.getMedicalEmployerJobPostingDTO(jobPostingId, true);
      return jobPostingDTO == null ? null : this.jobPostingMapper.getModel(jobPostingDTO);
   }

   public Integer getCandidatesSearchResults(final Integer lastLogin, final String title, final SpecialityTypeEnum speciality,
            final USStatesTypeEnum location) {
      List<MedicalJobSeekerExtendedInfoDTO> candidates = this.getCandidatesSearchResults(lastLogin, title, speciality, location, false);
      LOG.info("Found " + candidates.size() + " candidates matching with basic filters: "
               + this.getFilterString(lastLogin, title, speciality, location).toString());
      return candidates.size();
   }

   // CHECKSTYLE:OFF
   public List<Candidate> getCandidatesSearchResults(final Integer lastLogin, final String title, final SpecialityTypeEnum speciality,
            final USStatesTypeEnum location, final String P1, final String P1value, final String P2, final String P2value, final String P3,
            final String P3value, final String P4, final String P4value, final String P5, final String P5value) {
      List<MedicalJobSeekerExtendedInfoDTO> extInfoDTOs = this.getCandidatesSearchResults(lastLogin, title, speciality, location, true);
      List<Candidate> candidates = this.filterCandidateAndAssignRank(extInfoDTOs, P1, P1value, P2, P2value, P3, P3value, P4, P4value, P5,
               P5value, location);
      LOG.info("Found " + candidates.size() + " candidates matching with custom filters: " + this.getAdvanceFilterString(lastLogin, title,
               speciality, location, P1, P1value, P2, P2value, P3, P3value, P4, P4value, P5, P5value).toString());
      return candidates;
   }

   private List<MedicalJobSeekerExtendedInfoDTO> getCandidatesSearchResults(final Integer lastLogin, final String title,
            final SpecialityTypeEnum speciality, final USStatesTypeEnum location, final boolean customSearch) {
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DAY_OF_YEAR, lastLogin == null ? -60 : -lastLogin);
      String loc = location == null ? null : location.getName();
      EnumSpecialityTypeDTO specialityTypeDTO = this.enumMapperUtil.getDTO(speciality);
      String titleSearch = StringUtils.isBlank(title) ? null : title;
      String locSearch = StringUtils.isBlank(loc) ? null : loc;
      List<MedicalJobSeekerExtendedInfoDTO> jsExtInfoDtos = this.jsExtInfoDAO.findByCandidateSeach(titleSearch, specialityTypeDTO,
               locSearch);

      List<MedicalJobSeekerExtendedInfoDTO> jsExtInfoDtosWithLastLogin = new ArrayList<>();
      if (lastLogin != null) {
         LocalDate loginDate = Instant.ofEpochMilli(cal.getTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
         for (MedicalJobSeekerExtendedInfoDTO dto : jsExtInfoDtos) {
            UserAuthenticationDTO uaDTO = this.userAuthenticationDAO.findByUserId(dto.getUserDTO().getId());
            if (uaDTO.getLastSigninDate().isAfter(loginDate)) {
               jsExtInfoDtosWithLastLogin.add(dto);
            }
         }
      } else {
         jsExtInfoDtosWithLastLogin.addAll(jsExtInfoDtos);
      }
      // Collections.sort(jsExtInfo);
      return jsExtInfoDtosWithLastLogin;
   }

   private List<Candidate> filterCandidateAndAssignRank(final List<MedicalJobSeekerExtendedInfoDTO> extInfoDTOs, final String P1,
            final String P1value, final String P2, final String P2value, final String P3, final String P3value, final String P4,
            final String P4value, final String P5, final String P5value, final USStatesTypeEnum location) {
      List<Candidate> candidates = new ArrayList<>();
      for (MedicalJobSeekerExtendedInfoDTO extInfoDTO : extInfoDTOs) {
         if (StringUtils.equalsAnyIgnoreCase(YEARS_OF_EXPERIENCE, P1, P2)) {
            int years = -1;
            if (YEARS_OF_EXPERIENCE.equalsIgnoreCase(P1) && !P1value.isEmpty()) {
               years = Integer.parseInt(P1value);
            } else if (!P2value.isEmpty()) {
               years = Integer.parseInt(P2value);
            }
            if (extInfoDTO.getYearsExperience() == null || extInfoDTO.getYearsExperience() < years) {
               continue;
            }
         }
         if (StringUtils.equalsAnyIgnoreCase(SALARY, P1, P2)) {
            int salary = Integer.MAX_VALUE;
            if (SALARY.equalsIgnoreCase(P1) && !P1value.isEmpty()) {
               salary = Integer.parseInt(P1value);
            } else if (!P2value.isEmpty()) {
               salary = Integer.parseInt(P2value);
            }
            if (extInfoDTO.getCompensation() == null || extInfoDTO.getCompensation() > salary) {
               continue;
            }
         }
         if (StringUtils.equalsAnyIgnoreCase(MALPRACTICE_CANDIDATE_ACCEPTED, P3, P4, P5)) {
            boolean malpractice = true;
            if (MALPRACTICE_CANDIDATE_ACCEPTED.equalsIgnoreCase(P3) && !P3value.isEmpty()) {
               malpractice = Boolean.parseBoolean(P3value);
            } else if (MALPRACTICE_CANDIDATE_ACCEPTED.equalsIgnoreCase(P4) && !P4value.isEmpty()) {
               malpractice = Boolean.parseBoolean(P4value);
            } else if (MALPRACTICE_CANDIDATE_ACCEPTED.equalsIgnoreCase(P5) && !P5value.isEmpty()) {
               malpractice = Boolean.parseBoolean(P5value);
            }
            if (!malpractice && extInfoDTO.isMalpractice()) {
               continue;
            }
         }
         if (StringUtils.equalsAnyIgnoreCase(SHIFT, P3, P4, P5)) {
            ShiftTypeEnum shift = null;
            if (SHIFT.equalsIgnoreCase(P3) && !P3value.isEmpty()) {
               shift = ShiftTypeEnum.fromName(P3value);
            } else if (SHIFT.equalsIgnoreCase(P4) && !P4value.isEmpty()) {
               shift = ShiftTypeEnum.fromName(P4value);
            } else if (SHIFT.equalsIgnoreCase(P5) && !P5value.isEmpty()) {
               shift = ShiftTypeEnum.fromName(P5value);
            }
            if (shift != null && !shift.equals(this.enumMapperUtil.getModel(extInfoDTO.getShiftTypeDTO()))) {
               continue;
            }
         }
         if (StringUtils.equalsAnyIgnoreCase(FACILITY_TYPE, P3, P4, P5)) {
            FacilityTypeEnum facilityType = null;
            if (FACILITY_TYPE.equalsIgnoreCase(P3) && !P3value.isEmpty()) {
               facilityType = FacilityTypeEnum.fromName(P3value);
            } else if (FACILITY_TYPE.equalsIgnoreCase(P4) && !P4value.isEmpty()) {
               facilityType = FacilityTypeEnum.fromName(P4value);
            } else if (FACILITY_TYPE.equalsIgnoreCase(P5) && !P5value.isEmpty()) {
               facilityType = FacilityTypeEnum.fromName(P5value);
            }

            List<MedicalJobSeekerJobInfo> jobInfos = this.jsHandler.getAllMedicalJobSeekerJobInfo(extInfoDTO.getUserDTO().getId());
            if (facilityType != null && ((jobInfos.size() != 0 && !facilityType.equals(jobInfos.get(0).getFacilityType()))
                     || (jobInfos.size() >= 1 && !facilityType.equals(jobInfos.get(1).getFacilityType())))) {
               continue;
            }
         }
         if (StringUtils.equalsAnyIgnoreCase(SUPERVISION_REQUIRED, P3, P4, P5)) {
            boolean supervision = true;
            if (SUPERVISION_REQUIRED.equalsIgnoreCase(P3) && !P3value.isEmpty()) {
               supervision = Boolean.parseBoolean(P3value);
            } else if (SUPERVISION_REQUIRED.equalsIgnoreCase(P4) && !P4value.isEmpty()) {
               supervision = Boolean.parseBoolean(P4value);
            } else if (SUPERVISION_REQUIRED.equalsIgnoreCase(P5) && !P5value.isEmpty()) {
               supervision = Boolean.parseBoolean(P5value);
            }

            List<MedicalJobSeekerJobInfo> jobInfos = this.jsHandler.getAllMedicalJobSeekerJobInfo(extInfoDTO.getUserDTO().getId());
            boolean userSupervision = (jobInfos.size() != 0 && jobInfos.get(0).isSupervised())
                     || (jobInfos.size() >= 1 && jobInfos.get(1).isSupervised());
            if (supervision && !userSupervision) {
               continue;
            }
         }
         if (StringUtils.equalsAnyIgnoreCase(PRESCRIPTION_AUTHORITY_REQUIRED, P3, P4, P5)) {
            boolean prescAuth = true;
            if (PRESCRIPTION_AUTHORITY_REQUIRED.equalsIgnoreCase(P3) && !P3value.isEmpty()) {
               prescAuth = Boolean.parseBoolean(P3value);
            } else if (PRESCRIPTION_AUTHORITY_REQUIRED.equalsIgnoreCase(P4) && !P4value.isEmpty()) {
               prescAuth = Boolean.parseBoolean(P4value);
            } else if (PRESCRIPTION_AUTHORITY_REQUIRED.equalsIgnoreCase(P5) && !P5value.isEmpty()) {
               prescAuth = Boolean.parseBoolean(P5value);
            }
            if (prescAuth && !this.jsHandler.isJobSeekerHasPrescriptionAuthority(location, this.jsExtInfoMapper.getModel(extInfoDTO))) {
               continue;
            }
         }

         Candidate c = this.jsExtInfoMapper.getCandidateModel(extInfoDTO);
         if (!P1value.isEmpty() && !P2value.isEmpty()) {
            int p1v = YEARS_OF_EXPERIENCE.equalsIgnoreCase(P1) ? extInfoDTO.getYearsExperience() : extInfoDTO.getCompensation();
            int p2v = YEARS_OF_EXPERIENCE.equalsIgnoreCase(P2) ? extInfoDTO.getYearsExperience() : extInfoDTO.getCompensation();
            double numerator = (0.28 * p1v) + (0.22 * p2v) + (0.19 * 1) + (0.18 * 1) + (0.13 * 1);
            double denominator = (0.18 * p1v) + (0.29 * p2v);
            double rank = denominator == 0 ? 0 : numerator / denominator;
            c.setRank(rank);
         }
         candidates.add(c);
      }

      if (!P1value.isEmpty() && !P2value.isEmpty()) {
         Collections.sort(candidates);
      }
      return candidates;
   }

   public void saveOrUpdate(final int jobSeekerUserId, final MedicalEmployerExtendedInfo extInfo) {
      MedicalEmployerExtendedInfoDTO extInfoDTO = this.empExtInfoMapper.getDTO(jobSeekerUserId, extInfo);
      this.extInfoDAO.makePersistent(extInfoDTO);
   }

   public void saveOrUpdateMedicalEmployerJobPosting(final int employerUserId, final MedicalEmployerJobPosting jobPosting) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(employerUserId, true);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.jobPostingMapper.getDTO(jobPosting, userDTO);
      this.jobPostingDAO.makePersistent(jobPostingDTO);
   }

   public void deleteMedicalEmployerExtendedInfo(final int jobSeekerUserId) {
      MedicalEmployerExtendedInfoDTO extInfoDTO = this.getExtInfoDTO(jobSeekerUserId);
      this.extInfoDAO.makeTransient(extInfoDTO);
   }

   public void deleteMedicalEmployerJobPosting(final int jobSeekerUserId, final int jobPostingId) {
      this.setupMapperUtil.checkIfUserExists(jobSeekerUserId);
      MedicalEmployerJobPostingDTO jobPostingDTO = this.jobPostingDAO.findById(jobPostingId);
      this.jobPostingDAO.makeTransient(jobPostingDTO);
   }

   private MedicalEmployerExtendedInfoDTO getExtInfoDTO(final int jobSeekerUserId) {
      UserDTO userDTO = this.setupMapperUtil.getUserDTO(jobSeekerUserId, true);
      return this.extInfoDAO.findByUser(userDTO);
   }

   private List<String> getFilterString(final Integer lastLogin, final String title, final SpecialityTypeEnum speciality,
            final USStatesTypeEnum location) {
      List<String> filters = new ArrayList<>();
      if (lastLogin != null) {
         filters.add("lastLogin=" + lastLogin);
      }
      if (title != null && StringUtils.isNotBlank(title)) {
         filters.add("title=" + title);
      }
      if (speciality != null) {
         filters.add("specialty=" + speciality.getName());
      }
      if (location != null) {
         filters.add("location=" + location.getDesc());
      }

      return filters;
   }

   private List<String> getAdvanceFilterString(final Integer lastLogin, final String title, final SpecialityTypeEnum speciality,
            final USStatesTypeEnum location, final String p1, final String p1Value, final String p2, final String p2Value, final String p3,
            final String p3Value, final String p4, final String p4Value, final String p5, final String p5Value) {
      List<String> filters = new ArrayList<>();
      filters.addAll(this.getFilterString(lastLogin, title, speciality, location));
      if (!p1.isEmpty()) {
         filters.add("P1=" + p1);
      }
      if (!p1Value.isEmpty()) {
         filters.add("P1value=" + p1Value);
      }
      if (!p2.isEmpty()) {
         filters.add("P2=" + p2);
      }
      if (!p2Value.isEmpty()) {
         filters.add("P2value=" + p2Value);
      }
      if (!p3.isEmpty()) {
         filters.add("P3=" + p3);
      }
      if (!p3Value.isEmpty()) {
         filters.add("P3value=" + p3Value);
      }
      if (!p4.isEmpty()) {
         filters.add("P4=" + p4);
      }
      if (!p4Value.isEmpty()) {
         filters.add("P4value=" + p4Value);
      }
      if (!p5.isEmpty()) {
         filters.add("P5=" + p5);
      }
      if (!p5Value.isEmpty()) {
         filters.add("P5value=" + p5Value);
      }

      return filters;
   }

}
