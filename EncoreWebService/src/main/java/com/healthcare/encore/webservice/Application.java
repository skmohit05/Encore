package com.healthcare.encore.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

/**
 * 
 * @author ckumar
 *
 */
@ComponentScan(basePackages = "com.healthcare.encore.webservice*")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
   HibernateJpaAutoConfiguration.class })
@ImportResource("classpath:spring/config/dbManagerBeans.xml")
public class Application extends SpringBootServletInitializer {

   /**
    * Entry point for the application
    *
    * @param args
    */
   public static void main(final String[] args) {
      SpringApplication application = new SpringApplication(Application.class);
      System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
      System.setProperty("spring.mvc.throw-exception-if-no-handler-found", "true");
      System.setProperty("spring.main.allow-bean-definition-overriding", "true");
      application.run(args);
      System.out.println("Server startup complete");
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
      return builder.sources(Application.class);
   }

   /**
    * Jackson configuration
    *
    * 1. Suppress serialization of null values 2. User ISO format Instant
    * serialization/deserialization and YYYY-MM-DD format for LocalDate
    * serialization/deserialization
    *
    * @return Jackson2ObjectMapperBuilder
    */
   @Bean
   public Jackson2ObjectMapperBuilder jacksonBuilder() {
      // @formatter:off
      return new Jackson2ObjectMapperBuilder().serializationInclusion(JsonInclude.Include.NON_NULL)
               .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).modulesToInstall(new GuavaModule());
      // @formatter:on
   }

}
