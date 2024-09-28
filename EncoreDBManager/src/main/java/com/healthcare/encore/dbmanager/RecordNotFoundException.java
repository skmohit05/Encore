/**
 *
 */
package com.healthcare.encore.dbmanager;

/**
 * Exception raised when passed in parameter record is not found in the database
 * and associated update or delete action is performed
 * 
 * @author ckumar
 *
 */
public class RecordNotFoundException extends RuntimeException {
   /**
    *
    */
   private static final long serialVersionUID = 1L;

   /**
    *
    */
   public RecordNotFoundException() {
      super();
   }

   /**
    *
    * @param message
    */
   public RecordNotFoundException(final String message) {
      super(message);
   }

   /**
    *
    * @param cause
    */
   public RecordNotFoundException(final Throwable cause)  {
      super(cause);
   }

   /**
    *
    * @param message
    * @param cause
    */
   public RecordNotFoundException(final String message, final Throwable cause) {
      super(message, cause);
   }

   /**
    *
    * @param message
    * @param cause
    * @param enableSuppression
    * @param writableStackTrace
    */
   public RecordNotFoundException(final String message, final Throwable cause,
            final boolean enableSuppression, final boolean writableStackTrace)  {
      super(message, cause, enableSuppression, writableStackTrace);
   }
}
