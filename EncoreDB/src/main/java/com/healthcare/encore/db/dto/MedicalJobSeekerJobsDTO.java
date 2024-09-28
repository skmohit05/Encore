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
 * The persistent class for the MedicalJobSeekerJobs database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "MedicalJobSeekerJobsDTO.findAll",
            query = "SELECT jobs"
                     + " FROM MedicalJobSeekerJobsDTO jobs"
                     + " LEFT JOIN FETCH jobs.userDTO"
                     + " WHERE jobs.userDTO.id=:userId",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
            name = "MedicalJobSeekerJobsDTO.findByJobInfoId",
           query = "SELECT jobs"
                    + " FROM MedicalJobSeekerJobsDTO jobs"
                    + " LEFT JOIN FETCH jobs.userDTO"
                    + " LEFT JOIN FETCH jobs.medicalJobSeekerJobInfoDTO"
                    + " WHERE jobs.userDTO.id=:userId"
                    + " AND jobs.medicalJobSeekerJobInfoDTO.id=:jobInfoId",
           hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Table(name = "MedicalJobSeekerJobs")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalJobSeekerJobId", nullable = false))})
//@formatter:on
public class MedicalJobSeekerJobsDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private UserDTO userDTO;
   
   private MedicalJobSeekerJobInfoDTO medicalJobSeekerJobInfoDTO;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalJobSeekerUserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO userDTO) {
      this.userDTO = userDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalJobSeekerJobInfoId", nullable = false)
   public MedicalJobSeekerJobInfoDTO getMedicalJobSeekerJobInfoDTO() {
      return this.medicalJobSeekerJobInfoDTO;
   }

   public void setMedicalJobSeekerJobInfoDTO(final MedicalJobSeekerJobInfoDTO medicalJobSeekerJobInfoDTO) {
      this.medicalJobSeekerJobInfoDTO = medicalJobSeekerJobInfoDTO;
   }
}
