/**
 *
 */
package com.healthcare.encore.commons;

/**
 * @author ckumar
 *
 */
public class CommonsException extends RuntimeException {
   /**
    *
    */
   private static final long serialVersionUID = 1L;

   /**
    *
    */
   public CommonsException() {
      super();
   }

   /**
    *
    * @param message
    */
   public CommonsException(final String message) {
      super(message);
   }

   /**
    *
    * @param cause
    */
   public CommonsException(final Throwable cause) {
      super(cause);
   }

   /**
    *
    * @param message
    * @param cause
    */
   public CommonsException(final String message, final Throwable cause) {
      super(message, cause);
   }

   /**
    *
    * @param message
    * @param cause
    * @param enableSuppression
    * @param writableStackTrace
    */
   public CommonsException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
   }
}
