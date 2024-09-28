package com.healthcare.encore.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.healthcare.encore.webservice.jwt.JWTTokenFilter;
import com.healthcare.encore.webservice.jwt.LoginFilter;

/**
 *
 * @author ckumar
 *
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   /**
    * Stateless session and filters configuration
    */
   @Override
   public void configure(final HttpSecurity http) throws Exception { //NOPMD
      //@formatter:off
      http
         .cors().and()         // Allows unauthenticated OPTIONS request to go through filter chain
         .csrf().disable()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .headers().cacheControl().and()
         .and()
         .addFilterBefore(new CaseInsensitiveRequestParamFilter(), UsernamePasswordAuthenticationFilter.class)
//         .addFilterBefore(new SimpleCORSFilter(), UsernamePasswordAuthenticationFilter.class)
         .addFilterBefore(new LoginFilter(), UsernamePasswordAuthenticationFilter.class)
         .addFilterBefore(new JWTTokenFilter(), UsernamePasswordAuthenticationFilter.class);
      //@formatter:on
   }

   /**
    * Remove authentication check for public urls
    */
   @Override
   public void configure(final WebSecurity web) throws Exception { // NOPMD
      web.ignoring().antMatchers(
               "/api/auth/refreshtoken",
               "/api/encrypt",
               "/api/mfa/otp/**",
               "/api/jobs**",
               "/api/candidates**",
               "/api/users/resetPassword**");
   }
}
