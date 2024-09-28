/**
 *
 */
package com.healthcare.encore.model;

/**
 * 
 * @author mmeena
 *
 */
public class UserCommunicationPref extends BaseSetup {

   private boolean jobSubscription;

   private boolean candidateSubscription;

   private boolean siteFeatureSubscription;

   private boolean marketingSubscription;

   public boolean isJobSubscription() {
      return this.jobSubscription;
   }

   public void setJobSubscription(final boolean jobSubscription) {
      this.jobSubscription = jobSubscription;
   }

   public boolean isCandidateSubscription() {
      return this.candidateSubscription;
   }

   public void setCandidateSubscription(final boolean candidateSubscription) {
      this.candidateSubscription = candidateSubscription;
   }

   public boolean isSiteFeatureSubscription() {
      return this.siteFeatureSubscription;
   }

   public void setSiteFeatureSubscription(final boolean siteFeatureSubscription) {
      this.siteFeatureSubscription = siteFeatureSubscription;
   }

   public boolean isMarketingSubscription() {
      return this.marketingSubscription;
   }

   public void setMarketingSubscription(final boolean marketingSubscription) {
      this.marketingSubscription = marketingSubscription;
   }

}
