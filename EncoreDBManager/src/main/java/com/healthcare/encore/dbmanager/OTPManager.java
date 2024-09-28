package com.healthcare.encore.dbmanager;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.healthcare.encore.model.OTPRequestTypeEnum;

/**
 * 
 * @author ckumar
 *
 */
@Validated
public interface OTPManager {

   /**
    * 
    * @param emailId
    */
   void generateOTP(
            @NotBlank(message = "emailId cannot be blank or null")
            String emailId,
            OTPRequestTypeEnum requestType);
}
