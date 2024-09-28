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
 * The persistent class for the UserAuthentication database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
           name = "UserAuthenticationDTO.findByUserId",
           query = "SELECT ua"
                    + " FROM UserAuthenticationDTO ua"
                    + " LEFT JOIN FETCH ua.userDTO"
                    + " WHERE ua.userDTO.id=:userId",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Table(name = "UserAuthentication")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "UserAuthenticationId", nullable = false))})
//@formatter:on
public class UserAuthenticationDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private UserDTO userDTO;
   
   private LocalDate lastSigninDate;
   
   private Boolean mfaPassed;
   
   private EnumMFATypeDTO mfaTypeDTO;
   
   private Boolean rememberMe;
   
   private String trustedDeviceId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "UserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO userDTO) {
      this.userDTO = userDTO;
   }

   @Column(name = "LastSignInDate")
   public LocalDate getLastSigninDate() {
      return this.lastSigninDate;
   }

   public void setLastSigninDate(final LocalDate lastSigninDate) {
      this.lastSigninDate = lastSigninDate;
   }

   @Column(name = "MFAPassed")
   public Boolean isMfaPassed() {
      return this.mfaPassed;
   }

   public void setMfaPassed(final Boolean mfaPassed) {
      this.mfaPassed = mfaPassed;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MFATypeId", nullable = false)
   public EnumMFATypeDTO getMfaTypeDTO() {
      return this.mfaTypeDTO;
   }

   public void setMfaTypeDTO(final EnumMFATypeDTO mfaTypeDTO) {
      this.mfaTypeDTO = mfaTypeDTO;
   }

   @Column(name = "RememberMe")
   public Boolean isRememberMe() {
      return this.rememberMe;
   }

   public void setRememberMe(final Boolean rememberMe) {
      this.rememberMe = rememberMe;
   }

   @Column(name = "TrustedDeviceId")
   public String getTrustedDeviceId() {
      return this.trustedDeviceId;
   }

   public void setTrustedDeviceId(final String trustedDeviceId) {
      this.trustedDeviceId = trustedDeviceId;
   }
}
