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
 * The persistent class for the MedicalJobSeekerSurveys database table.
 *
 * @author mmeena
 */
//@formatter:off
@LogAuditInfo
@NamedQueries({
         @NamedQuery(name = "MedicalJobSeekerSurveyDTO.findAll", query = "SELECT s"
                  + " FROM MedicalJobSeekerSurveyDTO s" + " WHERE s.userDTO.id=:jobSeekerUserId", hints = {
                           @QueryHint(name = "org.hibernate.cacheable", value = "true") }),
         @NamedQuery(name = "MedicalJobSeekerSurveyDTO.findByJobPostingId", query = "SELECT s"
                  + " FROM MedicalJobSeekerSurveyDTO s" + " WHERE s.userDTO.id=:jobSeekerUserId"
                  + " AND s.medicalEmployerJobPostingDTO.id=:jobPostingId", hints = {
                           @QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
@Entity
@Table(name = "MedicalJobSeekerSurveys")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "MedicalJobSeekerSurveyId", nullable = false))})
//@formatter:on
public class MedicalJobSeekerSurveyDTO extends BaseSetupDTO implements Serializable {
   
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;
   
   private UserDTO userDTO;
   
   private MedicalEmployerJobPostingDTO medicalEmployerJobPostingDTO;
   
   private Integer satisfactionScore;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalJobSeekerUserId", nullable = false)
   public UserDTO getUserDTO() {
      return this.userDTO;
   }

   public void setUserDTO(final UserDTO medicalJobSeekerUserDTO) {
      this.userDTO = medicalJobSeekerUserDTO;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MedicalEmployerJobPostingId", nullable = false)
   public MedicalEmployerJobPostingDTO getMedicalEmployerJobPostingDTO() {
      return this.medicalEmployerJobPostingDTO;
   }

   public void setMedicalEmployerJobPostingDTO(final MedicalEmployerJobPostingDTO medicalEmployerJobPostingDTO) {
      this.medicalEmployerJobPostingDTO = medicalEmployerJobPostingDTO;
   }

   public Integer getSatisfactionScore() {
      return this.satisfactionScore;
   }

   public void setSatisfactionScore(final Integer satisfactionScore) {
      this.satisfactionScore = satisfactionScore;
   }
}
