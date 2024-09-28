package com.healthcare.encore.commons.mailservice;

/**
 * 
 * @author ckumar
 *
 */
public final class JavaMailContent {

   /**
    * 
    */
   private JavaMailContent() {

   }

   /**
    * 
    * @param otp
    * @return
    */
   public static String getSendRegistrationOTPMailContent(final String otp) {
      String messageText = "<p><strong>Dear User,</strong></p>" + "<p><strong>Thank you for your interest with Encore Time, "
               + "Please confirm your email.</strong></p>" + "<p>We received your user creation request. "
               + "Please use the below One Time Password to activate your account when prompted.</p>"
               + "<p style=\"text-align:center;\"><strong>" + otp + "</strong></p>" + "<p>Regards,</p>" + "<p>EncoreTime App Team.</p>";

      return messageText;
   }

   /**
    * 
    * @param otp
    * @return
    */
   public static String getSendPasswordResetOTPMailContent(final String userName, final String otp) {
      String messageText = "<p><strong>Dear " + userName + ",</strong></p>" 
               + "<p><strong>Thank you for your interest with Encore Time.</strong></p> "
               + "<p>We received your reset password request. "
               + "Please use the below One Time Password to reset your password when prompted.</p>"
               + "<p style=\"text-align:center;\"><strong>" + otp + "</strong></p>" + "<p>Regards,</p>" + "<p>EncoreTime App Team.</p>";

      return messageText;
   }

   /**
    * 
    * @param otp
    * @return
    */
   public static String getJobseekerSendWelcomeAccountCreationMailContent(final String userName) {
      String link = "http://54.166.121.201:8000/";
      String messageText = "<p><strong>Welcome " + userName + " to Encore Time.</strong></p>"
               + "<p>We are excited that you are part of the community with Encore Time, "
               + "the most efficient marketplace to match best talent like you with employers.</p>"
               + "<button style=\"display:block;margin-left:auto;margin-right:auto;\"><a style=\"text-decoration: none;\" href=\"" + link
               + "\">Get Started</a></button>" + "<p>Regards,</p>" + "<p>EncoreTime App Team.</p>";

      return messageText;
   }

   /**
    * 
    * @param otp
    * @return
    */
   public static String getEmployerSendWelcomeAccountCreationMailContent(final String userName) {
      String link = "http://54.166.121.201:8000/";
      String messageText = "<p><strong>Welcome " + userName + " to Encore Time.</strong></p>"
               + "<p>We are excited that you are part of the community with Encore Time, "
               + "the most efficient marketplace to match best employer like you with great talents.</p>"
               + "<button style=\"display:block;margin-left:auto;margin-right:auto;\"><a style=\"text-decoration: none;\" href=\"" + link
               + "\">Get Started</a></button>" + "<p>Regards,</p>" + "<p>EncoreTime App Team.</p>";

      return messageText;
   }

   public static String getJobSeekerAppliedJobMailContent(final String username, final String employerOrgName, final String title) {
      String messageText = "<p>Congratulations " + username + ". Big first step completed.</p>"
               + "<p>We are excited for you that you applied for the " + title + " with " + employerOrgName
               + ". They will reach out to you if there is a match. We truly believe you are the perfect match. Good luck!</p>"
               + "<p>Regards,</p>" + "<p>EncoreTime App Team.</p>";

      return messageText;
   }

   public static String getEmployerAppliedJobMailContent(final String username, final String jobSeekerName, final String title) {
      String messageText = "<p>Hello " + username + ",</p>" + "<p>" + jobSeekerName + " applied for the job " + title
               + " who we believe is one of the best matches based on what you are looking for. Please review and contact " + jobSeekerName
               + " if interested.</p>" + "<p>Regards,</p>"
               + "<p>EncoreTime App Team.</p>";

      return messageText;
   }

}
