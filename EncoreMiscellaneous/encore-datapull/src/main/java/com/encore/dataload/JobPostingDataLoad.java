package com.encore.dataload;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.encore.datapull.DBUtil;
import com.encore.datapull.model.LTJobDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.healthcare.encore.dbmanager.MedicalEmployerManager;
import com.healthcare.encore.dbmanager.UserManager;
import com.healthcare.encore.model.AssignmentTypeEnum;
import com.healthcare.encore.model.CompensationTypeEnum;
import com.healthcare.encore.model.JobPostingStatusTypeEnum;
import com.healthcare.encore.model.MedicalEmployerExtendedInfo;
import com.healthcare.encore.model.MedicalEmployerJobPosting;
import com.healthcare.encore.model.ShiftTypeEnum;
import com.healthcare.encore.model.User;

public class JobPostingDataLoad {
   private static final Logger logger = LogManager.getLogger(JobPostingDataLoad.class);
   
   static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   static final String[] AssignmentTypeKeys = { "Practice Setting", "Assignment Type" };
   static final String[] AssignmentShiftKeys = { "Shift", "Shift Hours", "Hours", "Clinic Hours", "Schedule", "Shift Type", "Start Time" };
   static final String[] AssignmentFromDateKeys = { "Dates", "Dates Needed", "Starting", "Start" };
   static final String SupervisionKey = "Supervision/Medical Direction (CRNA)";
   static final String PrescriptionAuthorityKey = "Prescriptive Authority Required";
   static final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "January",
            "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Asap",
            "Ongoing" };
   static final String PayRateKey = "Pay Rate";
   static final String CompensationKey = "Compensation";
   static final String[] hourlyRateKeys = {"perHour", "/hour", "perHr", "/hr", "hourly"};
   static final String[] dailyRateKeys = {"perDay", "/day", "daily"};
   static final String[] weeklyRateKeys = {"perWeek", "/week", "weekly"};
   static final String[] monthlyRateKeys = {"perMonth", "/month", "monthly"};
   static final String ENCORE_ORG = "Encore";

   public static void main(String[] args) throws JsonMappingException, JsonProcessingException, SQLException {
      try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/config/dbManagerBeans.xml");) {
         MedicalEmployerManager employerManager = context.getBean(MedicalEmployerManager.class);
         UserManager userManager = context.getBean(UserManager.class);
         List<User> users = userManager.getAllUsers(true);
         int encoreEmployerUserId = -1;
         for(User user : users) {
        	 if(user.getOrganization() != null && ENCORE_ORG.equalsIgnoreCase(user.getOrganization().getOrganizationName())) {
        		 encoreEmployerUserId = user.getUserId();
        		 break;
        	 }
         }
         if(encoreEmployerUserId == -1) {
        	 return;
         }
         
         MedicalEmployerExtendedInfo extInfo = employerManager.getMedicalEmployerExtendedInfo(encoreEmployerUserId);

         for (MedicalEmployerJobPosting jobPosting : mapJobPostingDetails()) {
            jobPosting.setState(extInfo.getState());
            employerManager.saveOrUpdateMedicalEmployerJobPosting(encoreEmployerUserId, jobPosting);
         }
      }
   }

   public static List<MedicalEmployerJobPosting> mapJobPostingDetails() throws JsonMappingException, JsonProcessingException, SQLException {
      List<MedicalEmployerJobPosting> jobPostings = new ArrayList<>();

      List<Pair<String, LTJobDetail>> details = DBUtil.getAllLTJobDetails();
      for (Pair<String, LTJobDetail> detail : details) {
         try {
            MedicalEmployerJobPosting jobPosting = new MedicalEmployerJobPosting();
            LTJobDetail job = detail.getValue();

            Date date = Date.from(job.getCreateDtm());
            jobPosting.setPostedDate(asLocalDate(date));

            Map<String, String> jobDetails = job.getJobDetails();
            String jobDescription = job.getDesc1();
            Pair<LocalDate, LocalDate> assignmentDates = extractAssignmentDates(jobDescription);
            if (asLocalDate(new Date()).compareTo(assignmentDates.getRight()) > 0) {
               continue;
            }
            jobPosting.setAssignmentFromDate(assignmentDates.getLeft());
            jobPosting.setAssignmentToDate(assignmentDates.getRight());
            jobPosting.setJobDescription(jobDescription);
            String titleString = jobDetails.get("Title");
            String[] titles = StringUtils.split(titleString, ",");
            if(titles.length > 0) {
               jobPosting.setTitle(titles[0].toUpperCase());               
            }
            jobPosting.setSpeciality(jobDetails.get("Specialty").toUpperCase());

            String compensation = jobDetails.get("Compensation");
            boolean travelHousingCoverage = false;
            boolean malpracticeCoverage = false;
            if (StringUtils.isNotBlank(compensation)) {
               jobPosting.setCompensationRange(compensation);
               if (StringUtils.containsIgnoreCase(compensation, "malpractice")) {
                  malpracticeCoverage = true;
                  jobPosting.setMalpracticeCoverage(true);
                  jobPosting.setMalpracticeAccepted(true);
               } else if (StringUtils.containsAny(compensation.toLowerCase(), "travel", "lodging")) {
                  travelHousingCoverage = true;
                  jobPosting.setTravelHousingCoverage(true);
               }
            }

            int hourlyRate = extractCompensationHourlyRate(StringUtils.isNotBlank(compensation) ? compensation : jobDescription);
            if (hourlyRate != 0) {
               jobPosting.setCompensation(hourlyRate);
            } else {
               jobPosting.setCompensation(100);
            }
            jobPosting.setCompensationType(CompensationTypeEnum.Hourly);

            if (!malpracticeCoverage && StringUtils.containsIgnoreCase(jobDescription, "malpractice")) {
               jobPosting.setMalpracticeCoverage(true);
            }

            if (!travelHousingCoverage && StringUtils.containsAny(jobDescription.toLowerCase(), "travel", "lodging", "housing")) {
               jobPosting.setTravelHousingCoverage(true);
            }

            if (!travelHousingCoverage && StringUtils.containsAny(jobDescription.toLowerCase(), "licensingcoverage", "licensing coverage",
                     "licensecoverage", "license coverage", "license")) {
               jobPosting.setLicensingCoverage(true);
            }

            if (StringUtils.containsIgnoreCase(jobDescription, "Credentialing")) {
               jobPosting.setCredentialingCoverage(true);
            }

            jobPosting.setAssignmentType(extractAssignmentType(jobDescription));
            jobPosting.setAssignmentShiftType(extractAssignmentShift(jobDescription));
            jobPosting.setSupervised(extractSuperVision(jobDescription));
            jobPosting.setPrescriptionAuthorityNeeded(extractPrescriptionAuthorityRequired(jobDescription));
            jobPosting.setStatusType(JobPostingStatusTypeEnum.Active);
            jobPosting.setExpiryDate(LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 12, 31));

            jobPosting.setYearsExperience(3);
            jobPostings.add(jobPosting);
         } catch (Exception e) {
            logger.error("Error while parsing json data for url: " + detail.getLeft());
         }
      }

      return jobPostings;
   }
   
   public static int extractCompensationHourlyRate(final String compensation){
      int hourlyRate = 0;
      
      String comp = StringUtils.deleteWhitespace(compensation).toLowerCase();
      for(String r : hourlyRateKeys) {
         int sindex = comp.indexOf(r.toLowerCase());
         if (sindex != -1 && sindex > 1) {
            int rate = extractCompensationRate(comp, sindex);
            hourlyRate = rate;
            break;
         }
         
      }
      
      if(hourlyRate == 0) {
         for(String r : dailyRateKeys) {
            int sindex = comp.indexOf(r.toLowerCase());
            if (sindex != -1 && sindex > 1) {
               int rate = extractCompensationRate(comp, sindex);
               hourlyRate = rate / 8;
               break;
            }
            
         }
      }
      
      if(hourlyRate == 0) {
         for(String r : weeklyRateKeys) {
            int sindex = comp.indexOf(r.toLowerCase());
            if (sindex != -1 && sindex > 1) {
               int rate = extractCompensationRate(comp, sindex);
               hourlyRate = rate / (8 * 5);
               break;
            }
            
         }
      }
      
      if(hourlyRate == 0) {
         for(String r : monthlyRateKeys) {
            int sindex = comp.indexOf(r.toLowerCase());
            if (sindex != -1 && sindex > 1) {
               int rate = extractCompensationRate(comp, sindex);
               hourlyRate = rate / (8 * ((184+176)/2));
               break;
            }
            
         }
      }
      
      return hourlyRate;
   }
   
   public static int extractCompensationRate(final String comp, final int sindex){
      String minRateStr = "";
      String maxRateStr = "";
      int i = sindex - 1;
      boolean lowerBoundFound = false;
      boolean dollarSymbolFound = false;
      while(i>=0) {
         String val = String.valueOf(comp.charAt(i));
         if(!val.equals(",")) {
            if(val.equals("$")) {
               dollarSymbolFound = true;
               break;
            }
            else if(!lowerBoundFound && val.equals("-")) {
               lowerBoundFound = true;
            }
            else if (StringUtils.isNumeric(val)) {
               if(lowerBoundFound) {
                  minRateStr += val;
               } else {
                  maxRateStr += val;
               }
            } else {
               break;
            }
         }
         
         i--;
      }
      
      int maxRate = 0;
      int minRate = 0;
      if(StringUtils.isNotBlank(maxRateStr) && dollarSymbolFound) {
         maxRate = Integer.valueOf(StringUtils.reverse(maxRateStr));
      }
      
      if(StringUtils.isNotBlank(minRateStr) && dollarSymbolFound) {
         minRate = Integer.valueOf(StringUtils.reverse(minRateStr));
      }
      
      return maxRate == 0 ? minRate : maxRate;
   }

   public static AssignmentTypeEnum extractAssignmentType(final String jobDescription) {
      AssignmentTypeEnum assignmentType = null;
      for (String key : AssignmentTypeKeys) {
         int sindex = jobDescription.indexOf(key);
         if (sindex != -1) {
            int endIndex = sindex + key.length() + 12;
            String subString = jobDescription.substring(sindex + key.length(),
                     endIndex < jobDescription.length() ? endIndex : jobDescription.length());
            if (StringUtils.containsIgnoreCase(subString, AssignmentTypeEnum.OR.getDesc())) {
               assignmentType = AssignmentTypeEnum.OR;
               break;
            } else if (StringUtils.containsIgnoreCase(subString, AssignmentTypeEnum.Outpatient.getDesc())) {
               assignmentType = AssignmentTypeEnum.Outpatient;
               break;
            }
         }
      }

      return assignmentType;
   }

   public static ShiftTypeEnum extractAssignmentShift(final String jobDescription) {
      ShiftTypeEnum shiftType = null;
      for (String key : AssignmentShiftKeys) {
         int sindex = jobDescription.indexOf(key);
         if (sindex != -1) {
            int endIndex = sindex + key.length() + 15;
            String subString1 = jobDescription.substring(sindex + key.length(),
                     endIndex < jobDescription.length() ? endIndex : jobDescription.length());
            int lookBeforeTextIndex = sindex - 15;
            String subString2 = lookBeforeTextIndex > 0 ? jobDescription.substring(lookBeforeTextIndex, sindex) : StringUtils.EMPTY;
            if ((StringUtils.containsIgnoreCase(subString1, ShiftTypeEnum.Weekend.getDesc())
                     && StringUtils.containsIgnoreCase(subString1, "No" + ShiftTypeEnum.Weekend.getDesc()))
                     || (StringUtils.containsIgnoreCase(subString2, ShiftTypeEnum.Weekend.getDesc())
                              && StringUtils.containsIgnoreCase(subString2, "No" + ShiftTypeEnum.Weekend.getDesc()))) {
               shiftType = ShiftTypeEnum.Weekend;
               break;
            } else if (StringUtils.containsIgnoreCase(subString1, ShiftTypeEnum.Night.getDesc())
                     || StringUtils.containsIgnoreCase(subString2, ShiftTypeEnum.Night.getDesc())) {
               shiftType = ShiftTypeEnum.Night;
               break;
            }
         }
      }

      if (shiftType == null) {
         if (StringUtils.containsIgnoreCase(jobDescription, ShiftTypeEnum.Weekend.getDesc())
                  && StringUtils.containsIgnoreCase(jobDescription, "No" + ShiftTypeEnum.Weekend.getDesc())) {
            shiftType = ShiftTypeEnum.Weekend;
         } else if (StringUtils.containsIgnoreCase(jobDescription, ShiftTypeEnum.Night.getDesc())) {
            shiftType = ShiftTypeEnum.Night;
         }
      }

      return shiftType == null ? ShiftTypeEnum.Day : shiftType;
   }

   public static boolean extractSuperVision(final String jobDescription) {
      boolean supervision = false;
      int sindex = jobDescription.indexOf(SupervisionKey);
      if (sindex != -1) {
         int endIndex = sindex + SupervisionKey.length() + 12;
         String value = jobDescription.substring(sindex + SupervisionKey.length(),
                  endIndex < jobDescription.length() ? endIndex : jobDescription.length());
         if (!StringUtils.containsIgnoreCase(value, "Autonomous")
                  && (StringUtils.containsIgnoreCase(value, "Supervised") || StringUtils.containsIgnoreCase(value, "Supervision"))) {
            supervision = true;
         }
      } else if (!StringUtils.containsIgnoreCase(jobDescription, "Autonomous")
               && (StringUtils.containsIgnoreCase(jobDescription, "Supervised")
                        || StringUtils.containsIgnoreCase(jobDescription, "Supervision"))) {
         supervision = true;
      }

      return supervision;
   }

   public static boolean extractPrescriptionAuthorityRequired(final String jobDescription) {
      boolean prescriptionAuthReqd = false;
      int sindex = jobDescription.indexOf(PrescriptionAuthorityKey);
      if (sindex != -1) {
         int endIndex = sindex + PrescriptionAuthorityKey.length() + 12;
         String value = jobDescription.substring(sindex + PrescriptionAuthorityKey.length(),
                  endIndex < jobDescription.length() ? endIndex : jobDescription.length());
         if (!StringUtils.containsIgnoreCase(value, "No")) {
            prescriptionAuthReqd = true;
         }
      }

      return prescriptionAuthReqd;
   }

   public static Pair<LocalDate, LocalDate> extractAssignmentDates(final String jobDescription) {
      LocalDate endDate = null;
      LocalDate beginDate = null;
      for (int i = 0; i < months.length; i++) {
         int endMonth = 0;
         String endSearchString = "-" + months[i];
         String localJobDesc = StringUtils.deleteWhitespace(jobDescription).toLowerCase();
         int sindex = localJobDesc.indexOf(endSearchString.toLowerCase());
         Calendar calendar = Calendar.getInstance();
         int currMonth = calendar.get(Calendar.MONTH) + 1;
         int year = calendar.get(Calendar.YEAR);
         if (sindex != -1 && sindex > 1) {
            if (i == 24) {
               endDate = asLocalDate(calendar.getTime());
            } else if (i != 25) {
               endMonth = (i % 12) + 1;
               year = endMonth < currMonth ? year + 1 : year;
               String date1stDigit = String.valueOf(jobDescription.charAt(sindex + endSearchString.length()));
               String date2ndDigit = String.valueOf(jobDescription.charAt(sindex + endSearchString.length() + 1));
               if (StringUtils.isNumeric(date2ndDigit)) {
                  endDate = LocalDate.of(year, endMonth,
                           Integer.parseInt(date1stDigit + date2ndDigit));
               } else if (StringUtils.isNumeric(date1stDigit)) {
                  endDate = LocalDate.of(year, endMonth, Integer.parseInt(date1stDigit));
               } else {
                  LocalDate ld = LocalDate.of(year, endMonth, 1);
                  calendar.setTime(asDate(ld));
                  endDate = LocalDate.of(year, endMonth, calendar.getActualMaximum(Calendar.DATE));
               }
            }
            
            int beginDateDummyIndex = sindex - 12 > 0 ? sindex - 12 : sindex;
            String subString = localJobDesc.substring(beginDateDummyIndex, sindex);
            for (int j = 0; j < months.length; j++) {
               int beginDateSIndex = subString.indexOf(months[j].toLowerCase());
               int beginMonth = 0;
               if(beginDateSIndex != -1) {
                  if(j == 24 || j == 25) {
                     beginDate = asLocalDate(Calendar.getInstance().getTime());
                  } else {
                     beginMonth = (j % 12) + 1;
                     String date1stDigit = String.valueOf(jobDescription.charAt(sindex - 2));
                     String date2ndDigit = String.valueOf(jobDescription.charAt(sindex - 1));
                     year = Calendar.getInstance().get(Calendar.YEAR);
                     if (StringUtils.isNumeric(date2ndDigit)) {
                        beginDate = LocalDate.of(year, beginMonth,
                                 Integer.parseInt(date1stDigit + date2ndDigit));
                     } else if (StringUtils.isNumeric(date1stDigit)) {
                        beginDate = LocalDate.of(year, beginMonth, Integer.parseInt(date1stDigit));
                     } else {
                        beginDate = LocalDate.of(year, beginMonth, 1);
                     }
                  }
               }
            }
            
            break;
         }
      }

		if (beginDate == null && endDate == null) {
			beginDate = getFirstDayOfNext();
			endDate = getLastDayOfNext6Month(beginDate);
		} else if (beginDate != null && endDate == null) {
			endDate = getLastDayOfNext6Month(beginDate);
		} else if (beginDate == null && endDate != null) {
			beginDate = getFirstDayOfNext();
			if (beginDate.compareTo(endDate) > 0) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 1);
				beginDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
						calendar.get(Calendar.DATE));
			}
		}

		return Pair.of(beginDate, endDate);
   }

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate getFirstDayOfNext() {
		Calendar today = Calendar.getInstance();
		Calendar next = Calendar.getInstance();
		next.clear();
		next.set(Calendar.YEAR, today.get(Calendar.YEAR));
		next.set(Calendar.DAY_OF_MONTH, 1);
		next.set(Calendar.MONTH, today.get(Calendar.MONTH));
		next.add(Calendar.MONTH, 1);
		return LocalDate.of(next.get(Calendar.YEAR), next.get(Calendar.MONTH) + 1, next.get(Calendar.DATE));
	}

	public static LocalDate getLastDayOfNext6Month(final LocalDate startDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(asDate(startDate));
		calendar.add(Calendar.MONTH, 5);
		return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.getActualMaximum(Calendar.DATE));
	}

}
