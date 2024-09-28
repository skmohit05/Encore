package com.healthcare.encore.db.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import com.healthcare.encore.db.audit.LogAuditInfo;
import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;

/**
 * The persistent class for the Users database table.
 *
 * @author ckumar
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "UserDTO.findAll",
            query = "SELECT u"
                     + " FROM UserDTO u"
                     + " WHERE (:applyActiveFilter=false OR u.statusTypeDTO.id=1)",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
           name = "UserDTO.findByEmailId",
           query = "SELECT u FROM UserDTO u WHERE u.email=:emailId",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Table(name = "Users")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "UserId", nullable = false)) })
//@formatter:on
public class UserDTO extends BaseSetupDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

   /**
   * 
   */
   private EnumUserTypeDTO userTypeDTO;

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
   private String email;

   /**
   * 
   */
   private String password;

   /**
   * 
   */
   private EnumUserStatusTypeDTO statusTypeDTO;

   /**
   * 
   */
   private EnumFieldTypeDTO fieldTypeDTO;

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
   private OrganizationDTO organizationDTO;

   /**
    * 
    * @return
    */
   @Column(name = "FirstName")
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
   @Column(name = "LastName")
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
    * @return the Email
    */
   @Column(name = "Email", length = 64, nullable = false)
   public String getEmail() {
      return this.email;
   }

   /**
    * @param email the userEmail to set
    */
   public void setEmail(final String email) {
      this.email = email;
   }

   /**
    * @return the password
    */
   @Column(name = "Password", length = 128, nullable = false)
   public String getPassword() {
      return this.password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(final String password) {
      this.password = password;
   }

   /**
    *
    * @return the statusTypeDTO
    */
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "StatusTypeId", nullable = false)
   public EnumUserStatusTypeDTO getStatusTypeDTO() {
      return this.statusTypeDTO;
   }

   /**
    *
    * @param statusTypeDTO
    */
   public void setStatusTypeDTO(final EnumUserStatusTypeDTO statusTypeDTO) {
      this.statusTypeDTO = statusTypeDTO;
   }

   /**
    * 
    * @return
    */
   @Column(name = "RegistrationDate", nullable = true)
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
   @Column(name = "RemoveRequestedDate", nullable = true)
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
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "OrganizationId")
   public OrganizationDTO getOrganizationDTO() {
      return this.organizationDTO;
   }

   /**
    * 
    * @param organizationDTO
    */
   public void setOrganizationDTO(final OrganizationDTO organizationDTO) {
      this.organizationDTO = organizationDTO;
   }

   /**
    * 
    * @return
    */
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "UserTypeId")
   public EnumUserTypeDTO getUserTypeDTO() {
      return this.userTypeDTO;
   }

   /**
    * 
    * @param userTypeDTO
    */
   public void setUserTypeDTO(final EnumUserTypeDTO userTypeDTO) {
      this.userTypeDTO = userTypeDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FieldTypeId")
   public EnumFieldTypeDTO getFieldTypeDTO() {
      return this.fieldTypeDTO;
   }

   /**
    * 
    * @param fieldTypeDTO
    */
   public void setFieldTypeDTO(final EnumFieldTypeDTO fieldTypeDTO) {
      this.fieldTypeDTO = fieldTypeDTO;
   }
}
