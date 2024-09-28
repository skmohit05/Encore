package com.healthcare.encore.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration {
   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(final CorsRegistry registry) {
            registry
               .addMapping("/**")
               .allowedOrigins("*")
               .allowedMethods("PATCH", "POST", "PUT", "GET", "OPTIONS", "DELETE", "HEAD")
               .allowCredentials(false);
         }
      };
   }
}
