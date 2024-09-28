package com.healthcare.encore.commons.mailservice;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.healthcare.encore.commons.CommonsException;

/**
 * 
 * @author ckumar
 *
 */
public final class JavaMailService {
   
   /**
    * 
    */
   private static final String API_KEY = "<Key_Here>";
   
   /**
    * 
    */
   private static final Email FROM_ADDRESS = new Email("support@encoretime.co");
   
   /**
    * 
    */
   private static final SendGrid SENDGRID_API;
   
   /**
    * 
    */
   static {
      SENDGRID_API = new SendGrid(API_KEY);
   }
   
   /**
    * 
    */
   private JavaMailService() {
      
   }
   
   /**
    * 
    * @param toAddress
    * @param subject
    * @param text
    */
   public static void sendEmail(final String toAddress, final String subject, final String text) {
      try {
         Request request = getRequest(toAddress, subject, text);
         SENDGRID_API.api(request);
      } catch (IOException ex) {
         throw new CommonsException("Failed sending email to mailId - " + toAddress + " " + ex.getMessage()); //NOPMD
      }
   }
   
   /**
    * 
    * @param toAddress
    * @param subject
    * @param text
    * @return
    * @throws IOException
    */
   private static Request getRequest(final String toAddress, final String subject, final String text) throws IOException {
      Email toEmail = new Email(toAddress);
      Content content = new Content("text/html", text);
      Mail mail = new Mail(FROM_ADDRESS, subject, toEmail, content);
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      return request;
   }
}
