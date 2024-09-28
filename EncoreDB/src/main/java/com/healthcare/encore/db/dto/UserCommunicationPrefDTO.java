package com.healthcare.encore.db.dto;

import java.io.Serializable;

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
 * The persistent class for the UserCommunicationPref database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "UserCommunicationPrefDTO.findAll",
            query = "SELECT ucf"
                     + " FROM UserCommunicationPrefDTO ucf"
                     + " LEFT JOIN FETCH ucf.userDTO"
                     + " WHERE ucf.userDTO.id=:userId",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
           name = "UserCommunicationPrefDTO.findByChannelType",
           query = "SELECT ucf"
                    + " FROM UserCommunicationPrefDTO ucf"
                    + " LEFT JOIN FETCH ucf.userDTO"
                    + " LEFT JOIN FETCH ucf.communicationChannelTypeDTO"
                    + " WHERE ucf.userDTO.id=:userId"
                    + " AND ucf.communicationChannelTypeDTO.id=:channelTypeId",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Table(name = "UserCommunicationPref")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "UserCommunicationPrefId", nullable = false))})
//@formatter:on
public class UserCommunicationPrefDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private UserDTO userDTO;
   
   private EnumCommunicationChannelTypeDTO communicationChannelTypeDTO;

   private boolean jobSubscription;
   
   private boolean candidateSubscription;
   
   private boolean siteFeatureSubscription;
   
   private boolean marketingSubscription;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "UserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO userDTO) {
      this.userDTO = userDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CommunicationChannelTypeId", nullable = false)
   public EnumCommunicationChannelTypeDTO getCommunicationChannelTypeDTO() {
      return this.communicationChannelTypeDTO;
   }

   public void setCommunicationChannelTypeDTO(final EnumCommunicationChannelTypeDTO communicationChannelTypeDTO) {
      this.communicationChannelTypeDTO = communicationChannelTypeDTO;
   }

   @Column(name = "JobSubscription")
   public boolean isJobSubscription() {
      return this.jobSubscription;
   }

   public void setJobSubscription(final boolean jobSubscription) {
      this.jobSubscription = jobSubscription;
   }

   @Column(name = "CandidateSubscription")
   public boolean isCandidateSubscription() {
      return this.candidateSubscription;
   }

   public void setCandidateSubscription(final boolean candidateSubscription) {
      this.candidateSubscription = candidateSubscription;
   }

   @Column(name = "SiteFeatureSubscription")
   public boolean isSiteFeatureSubscription() {
      return this.siteFeatureSubscription;
   }

   public void setSiteFeatureSubscription(final boolean siteFeatureSubscription) {
      this.siteFeatureSubscription = siteFeatureSubscription;
   }

   @Column(name = "MarketingSubscription")
   public boolean isMarketingSubscription() {
      return this.marketingSubscription;
   }

   public void setMarketingSubscription(final boolean marketingSubscription) {
      this.marketingSubscription = marketingSubscription;
   }
}
