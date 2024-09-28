package com.healthcare.encore.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * 
 * @author ckumar
 *
 */
@Configuration
public class PathMatchConfiguration implements WebMvcConfigurer {

   /**
    * Set urlDecode to false, this will provide the encoded
    * value in the path variable after controller path matching is done. 
    * Without this setting the URL decoding happens 
    * before path matching occurs, leading to incorrect matching
    * resulting in 404 or 400 response codes
    * 
    * setUseRegisteredSuffixPatternMatch - Spring by default matches
    * period(.) in the URL for file names. To disable this feature
    * and let Spring pass the period to URL mapping
    * setUseRegisteredSuffixPatternMatch is set to true
    * 
    * AntPathMatcher set for case insensitive URL mapping
    */
   @Override
   public void configurePathMatch(final PathMatchConfigurer configurer) {
      UrlPathHelper urlPathHelper = new UrlPathHelper();
      urlPathHelper.setUrlDecode(false);
      configurer.setUrlPathHelper(urlPathHelper);

      AntPathMatcher matcher = new AntPathMatcher();
      matcher.setCaseSensitive(false);
      configurer.setPathMatcher(matcher);
   }
}
