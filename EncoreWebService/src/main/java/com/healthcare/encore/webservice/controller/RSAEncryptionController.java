
package com.healthcare.encore.webservice.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.encore.commons.rsa.RSAUtil;
import com.healthcare.encore.webservice.commons.RSAEncryptionRequest;

/**
 * 
 * @author ckumar
 *
 */
@RestController
@RequestMapping(value = "api/encrypt")
public class RSAEncryptionController {

   /**
    * Returns the encrypted text for the passed in text
    *
    * @param plainText
    * @return Encrypted text
    */
   //@formatter:off
   @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   //@formatter:off
   public String getEncryptedText(@RequestBody final RSAEncryptionRequest request) {
      if (StringUtils.isBlank(request.getPlainText())) {
         throw new IllegalArgumentException("Text cannot be null or empty");
      }
      return RSAUtil.encrypt(request.getPlainText());
   }
}
