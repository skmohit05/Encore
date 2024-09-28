package com.healthcare.encore.commons.log;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * 
 * @author ckumar
 *
 */
public final class LogUtil {
   /**
    * 
    */
   private LogUtil() {
   }

   /**
    * 
    * @param log
    * @param throwable
    * @return log message
    */
   public static String logError(final Logger log, final Throwable throwable) {
      return logError(log, throwable, "Exception stack trace", Level.DEBUG);
   }

   /**
    * 
    * @param log
    * @param throwable
    * @param stackTraceHeader
    * @param stackTraceLevel
    * @return log message
    */
   public static String logError(final Logger log, final Throwable throwable, final String stackTraceHeader,
            final Level stackTraceLevel) {
      String message = throwable.getClass().getName() + "-[" + throwable.getMessage() + "]";
      log.error("Error Message=[" + throwable.getClass().getName() + "-" + LogUtil.getMessageInSingleLine(throwable.getMessage())
               + "]");
      if (throwable instanceof ConstraintViolationException) {
         message = message + System.lineSeparator() + "ConstraintViolation messages - ";
         ConstraintViolationException cve = (ConstraintViolationException) throwable;
         for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
            String violationMessage = violation.getMessage() + StringUtils.SPACE + violation.getPropertyPath();
            message = message + System.lineSeparator() + violationMessage;
            log.error("ConstraintViolation Message=[" + LogUtil.getMessageInSingleLine(violationMessage) + "]");
         }
      }
      log.log(stackTraceLevel, stackTraceHeader, throwable);
      return message;
   }

   /**
    * 
    * @param message
    * @return log message with newlines removed and concatenated with pipe
    */
   public static String getMessageInSingleLine(final String message) {
      return StringUtils.trimToEmpty(message).replaceAll("\r", "|").replaceAll("\n", "|");
   }
}
