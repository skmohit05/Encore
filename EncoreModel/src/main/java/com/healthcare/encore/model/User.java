/**
 *
 */
package com.healthcare.encore.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author ckumar
 *
 */
public class User extends BaseSetup {

   /**
    * 
    */
   private Integer userId;

   /**
    * 
    */
   private UserTypeEnum userType;

   /**
    * 
    */
   @NotBlank(message = "email cannot be blank or null")
   @Email(message = "email not in valid format")
   private String email;

   /**
    * 
    */
   private String firstName;

   /**
    * 
    */
   private String lastName;

   /**
    * 
    */
   private String password;

   /**
    * 
    */
   private UserStatusTypeEnum status;

   /**
    * 
    */
   private FieldTypeEnum fieldType;

   /**
    * 
    */
   private String subDomainId;

   /**
    * 
    */
   private LocalDate registrationDate;

   /**
    * 
    */
   private LocalDate removeRequestedDate;

   /**
    * 
    */
   private Organization organization;

   /**
    * 
    * @return
    */
   public Integer getUserId() {
      return this.userId;
   }

   /**
    * 
    * @param userId
    */
   public void setUserId(final Integer userId) {
      this.userId = userId;
   }

   /**
    * 
    * @return
    */
   public UserTypeEnum getUserType() {
      return this.userType;
   }

   /**
    * 
    * @param userType
    */
   public void setUserType(final UserTypeEnum userType) {
      this.userType = userType;
   }

   /**
    * 
    * @return
    */
   public String getEmail() {
      return this.email;
   }

   /**
    * 
    * @param email
    */
   public void setEmail(final String email) {
      this.email = email;
   }

   /**
    * 
    * @return
    */
   public String getFirstName() {
      return this.firstName;
   }

   /**
    * 
    * @param firstName
    */
   public void setFirstName(final String firstName) {
      this.firstName = firstName;
   }

   /**
    * 
    * @return
    */
   public String getLastName() {
      return this.lastName;
   }

   /**
    * 
    * @param lastName
    */
   public void setLastName(final String lastName) {
      this.lastName = lastName;
   }

   /**
    * 
    * @return
    */
   public String getPassword() {
      return this.password;
   }

   /**
    * 
    * @param password
    */
   public void setPassword(final String password) {
      this.password = password;
   }

   /**
    * 
    * @return
    */
   public UserStatusTypeEnum getStatus() {
      return this.status;
   }

   /**
    * 
    * @param statusType
    */
   public void setStatus(final UserStatusTypeEnum status) {
      this.status = status;
   }

   /**
    * 
    * @return
    */
   public FieldTypeEnum getFieldType() {
      return this.fieldType;
   }

   /**
    * 
    * @param fieldType
    */
   public void setFieldType(final FieldTypeEnum fieldType) {
      this.fieldType = fieldType;
   }

   /**
    * 
    * @return
    */
   public String getSubDomainId() {
      return this.subDomainId;
   }

   /**
    * 
    * @param subDomainId
    */
   public void setSubDomainId(final String subDomainId) {
      this.subDomainId = subDomainId;
   }

   /**
    * 
    * @return
    */
   public LocalDate getRegistrationDate() {
      return this.registrationDate;
   }

   /**
    * 
    * @param registrationDate
    */
   public void setRegistrationDate(final LocalDate registrationDate) {
      this.registrationDate = registrationDate;
   }

   /**
    * 
    * @return
    */
   public LocalDate getRemoveRequestedDate() {
      return this.removeRequestedDate;
   }

   /**
    * 
    * @param removeRequestedDate
    */
   public void setRemoveRequestedDate(final LocalDate removeRequestedDate) {
      this.removeRequestedDate = removeRequestedDate;
   }

   /**
    * 
    * @return
    */
   public Organization getOrganization() {
      return this.organization;
   }

   /**
    * 
    * @param organization
    */
   public void setOrganization(final Organization organization) {
      this.organization = organization;
   }
}
