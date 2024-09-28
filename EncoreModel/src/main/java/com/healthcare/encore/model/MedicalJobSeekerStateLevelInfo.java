/**
 *
 */
package com.healthcare.encore.model;

import java.time.LocalDate;

/**
 * 
 * @author mmeena
 *
 */
public class MedicalJobSeekerStateLevelInfo {

   private LocalDate licenseExpirationDate;

   private Boolean prescriptionAuthority;

   public LocalDate getLicenseExpirationDate() {
      return this.licenseExpirationDate;
   }

   public void setLicenseExpirationDate(final LocalDate licenseExpirationDate) {
      this.licenseExpirationDate = licenseExpirationDate;
   }

   public Boolean isPrescriptionAuthority() {
      return this.prescriptionAuthority;
   }

   public void setPrescriptionAuthority(final Boolean prescriptionAuthority) {
      this.prescriptionAuthority = prescriptionAuthority;
   }

}
