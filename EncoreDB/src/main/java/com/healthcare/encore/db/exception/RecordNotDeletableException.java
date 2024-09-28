/**
 *
 */
package com.healthcare.encore.db.exception;

/**
 * Exception raised when passed in parameter record is not deletable in the database
 *
 * @author ckumar
 *
 */
public class RecordNotDeletableException extends RuntimeException {
   /**
    *
    */
   private static final long serialVersionUID = 1L;

   /**
    *
    */
   public RecordNotDeletableException() {
      super();
   }

   /**
    *
    * @param message
    */
   public RecordNotDeletableException(final String message) {
      super(message);
   }

   /**
    *
    * @param cause
    */
   public RecordNotDeletableException(final Throwable cause)  {
      super(cause);
   }

   /**
    *
    * @param message
    * @param cause
    */
   public RecordNotDeletableException(final String message, final Throwable cause) {
      super(message, cause);
   }

   /**
    *
    * @param message
    * @param cause
    * @param enableSuppression
    * @param writableStackTrace
    */
   public RecordNotDeletableException(final String message, final Throwable cause,
            final boolean enableSuppression, final boolean writableStackTrace)  {
      super(message, cause, enableSuppression, writableStackTrace);
   }
}
