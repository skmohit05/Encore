package com.healthcare.encore.dbmanager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.encore.dbmanager.OTPManager;
import com.healthcare.encore.dbmanager.handler.OTPHandler;
import com.healthcare.encore.model.OTPRequestTypeEnum;

/**
 * 
 * @author ckumar
 *
 */
@Service
public class OTPManagerImpl implements OTPManager {

   /**
    * 
    */
   @Autowired
   private OTPHandler otpHandler;

   /**
    * 
    */
   @Override
   public void generateOTP(final String emailId, final OTPRequestTypeEnum requestType) {
      this.otpHandler.generateOTP(emailId, requestType);
   }
}
