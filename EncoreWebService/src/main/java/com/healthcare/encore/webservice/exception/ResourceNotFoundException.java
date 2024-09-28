/**
 * 
 */
package com.healthcare.encore.webservice.exception;

/**
 * 
 * @author ckumar
 *
 */
public class ResourceNotFoundException extends RuntimeException {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
   *
   */
   public ResourceNotFoundException() {
      super();
   }

   /**
   *
   * @param message
   */
   public ResourceNotFoundException(final String message) {
      super(message);
   }

   /**
   *
   * @param cause
   */
   public ResourceNotFoundException(final Throwable cause) {
      super(cause);
   }

   /**
   *
   * @param message
   * @param cause
   */
   public ResourceNotFoundException(final String message, final Throwable cause) {
      super(message, cause);
   }

   /**
   *
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
   public ResourceNotFoundException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
   }

}
