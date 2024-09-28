/**
 *
 */
package com.healthcare.encore.security;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.healthcare.encore.db.audit.AuditInfoProvider;

/**
 * Authenticates the user and stores the user information internally.
 * Further API calls to other manager validates against the store
 * for valid authorization before proceeding with the call
 *
 * @author ckumar
 *
 */
// @formatter:off
@Validated
public interface SecurityManager extends AuditInfoProvider {
   /**
    * Authenticates the user with the provided loginId and password
    * This method places the authenticated user information in security
    * context, that will be used for processing further requests
    * User has to be be authenticated before making calls to other
    * manager methods
    *
    * @param loginId
    * @param password
    */
   void authenticateUser(@NotBlank(message = "emailId cannot be blank or null") String emailId,
            @NotBlank(message = "password cannot be blank or null") String password);

   /**
    * Checks if the passed in combination of loginId and password
    * is valid
    *
    * @param loginId
    * @param password
    */
   boolean validateUserCredentials(@NotBlank(message = "emailId cannot be blank or null") String emailId,
            @NotBlank(message = "password cannot be blank or null") String password);

   /**
    * Returns the current authenticated user
    * @return Current authenticate user
    */
   UserAccount getAuthenticatedUser();
}
