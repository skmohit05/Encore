package com.healthcare.encore.webservice.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.healthcare.encore.db.exception.RecordNotDeletableException;
import com.healthcare.encore.dbmanager.RecordNotFoundException;
import com.healthcare.encore.dbmanager.common.LogUtil;
import com.healthcare.encore.webservice.exception.ResourceNotFoundException;

/**
 *
 * @author ckumar
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//extends ResponseEntityExceptionHandler {

   /**
    *
    */
   private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

   /**
    * catches the resource not found exception returns the message
    *
    * @param e
    * @return message
    */
   @ExceptionHandler(value = ResourceNotFoundException.class)
   public ResponseEntity<List<String>> handleNotFoundException(final ResourceNotFoundException e) {

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.NOT_FOUND);
   }

   /**
    * catches the record not found exception returns the message
    *
    * @param e
    * @return message
    */
   @ExceptionHandler(value = RecordNotFoundException.class)
   public ResponseEntity<List<String>> handleRecordNotFoundException(final RecordNotFoundException e) {

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.NOT_FOUND);
   }

   /**
    * catches the AccessDeniedException returns the message
    *
    * @param e
    * @return message
    */
   @ExceptionHandler(value = AccessDeniedException.class)
   public ResponseEntity<List<String>> handleAccessDeniedException(final AccessDeniedException e) {

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.FORBIDDEN);
   }

   /**
    * catches the AccessDeniedException returns the message
    *
    * @param e
    * @return message
    */
   @ExceptionHandler(value = CredentialsExpiredException.class)
   public ResponseEntity<List<String>> handleAccessDeniedException(final CredentialsExpiredException e) {

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());
      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.FORBIDDEN);
   }

   /**
    * catches the constraint violation exception and  returns the message
    *
    * @param e
    * @return list of constraint violation exceptions messages
    */
   @ExceptionHandler(value = ConstraintViolationException.class)
   public ResponseEntity<List<String>> handleConstraintViolationException(final ConstraintViolationException e) {
      List<String> constraintViolations = new ArrayList<String>();
      for (ConstraintViolation<?> c : e.getConstraintViolations()) {
         constraintViolations.add(c.getMessage());
      }

      return new ResponseEntity<List<String>>(constraintViolations, null, HttpStatus.BAD_REQUEST);
   }

   /**
    * catches illegal argument exception and return the customized exception message
    *
    * @param e
    * @return exception message
    */
   @ExceptionHandler(value = IllegalArgumentException.class)
   public ResponseEntity<List<String>> handleIllegalArgumentException(final IllegalArgumentException e) {

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.BAD_REQUEST);
   }

   /**
    * catches ConstraintViolationException and return the customized message
    *
    * @return exception message
    */
   @ExceptionHandler(value = org.hibernate.exception.ConstraintViolationException.class)
   public ResponseEntity<List<String>> handleSQLIntegrityConstraintViolationException(
            final org.hibernate.exception.ConstraintViolationException e) {
      LogUtil.logError(LOG, e, "Exception stack trace", Level.ERROR);

      List<String> exceptions = new ArrayList<String>();
      exceptions.add("Please try resubmitting the action. If issue persists, Please contact system administrator");

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   /**
    * catches RecordNotDeletableException and return the customized message
    *
    * @return exception message
    */
   @ExceptionHandler(value = RecordNotDeletableException.class)
   public ResponseEntity<List<String>> handleRecordNotDeletableException(final RecordNotDeletableException e) {
      LogUtil.logError(LOG, e, "Exception stack trace", Level.ERROR);

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   /**
    * catches DataIntegrityViolationException and return the customized message
    *
    * @return exception message
    */
   @ExceptionHandler(value = DataIntegrityViolationException.class)
   public ResponseEntity<List<String>> handleDataIntegrityViolationException(final DataIntegrityViolationException e) {
      LogUtil.logError(LOG, e, "Exception stack trace", Level.ERROR);
      List<String> exceptions = new ArrayList<String>();
      exceptions.add("Please try resubmitting the action. If issue persists, Please contact system administrator");

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   /**
    * catches all other type of exception and return customized message
    *
    * @param e
    * @return exception message
    */
   @ExceptionHandler(value = Exception.class)
   public ResponseEntity<List<String>> handleException(final Exception e) {
      LogUtil.logError(LOG, e, "Exception stack trace", Level.ERROR);

      List<String> exceptions = new ArrayList<String>();
      exceptions.add(
               "Exception occured - message=[" + e.getMessage() + "]. If issue persists, Please contact system administrator");

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   /**
    * catches exception if no handler found to handle the input request
    *
    * @param request
    * @param e
    * @return exception message
    */
   @ExceptionHandler(value = NoHandlerFoundException.class)
   public ResponseEntity<List<String>> handleNoHandlerFoundException(final HttpServletRequest request, final NoHandlerFoundException e) {
      List<String> exceptions = new ArrayList<String>();
      exceptions.add("No handler found for " +request.getMethod() + " " + request.getServletPath());
      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.NOT_FOUND);
   }

   /**
    * catches exception when content-type passed other than application/json in incoming request
    *
    * @param e
    * @return exception message
    */
   @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
   public ResponseEntity<List<String>> handleMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException e) {
      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
   }

   /**
    * catches exception when method is not supported for given request URL
    *
    * @param e
    * @return exception message
    */
   @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
   public ResponseEntity<List<String>> handleMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
      List<String> exceptions = new ArrayList<String>();
      exceptions.add(e.getMessage());

      return new ResponseEntity<List<String>>(exceptions, null, HttpStatus.METHOD_NOT_ALLOWED);
   }
}