/**
 *
 */
package com.healthcare.encore.model;

import java.time.Instant;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author ckumar
 *
 */
public final class AuditInfo {

   /**
    *
    */
   private final Instant lud;

   /**
    *
    */
   private final String lubLoginId;

   /**
    *
    * @param lud
    * @param lubLoginId
    */
   @JsonCreator
   public AuditInfo(@JsonProperty("lud") final Instant lud, @JsonProperty("lubLoginId") final String lubLoginId) {
      this.lud = lud;
      this.lubLoginId = lubLoginId;
   }

   /**
    * @return the lud
    */
   public Instant getLud() {
      return this.lud;
   }

   /**
    * @return the lubLoginId
    */
   public String getLubLoginId() {
      return this.lubLoginId;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean equals(final Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if (!(this.getClass().equals(obj.getClass()))) {
         return false;
      }
      AuditInfo rhs = (AuditInfo) obj;
      //@formatter:off
      return new EqualsBuilder().append(this.getLud(), rhs.getLud())
               .append(StringUtils.upperCase(this.getLubLoginId()), StringUtils.upperCase(rhs.getLubLoginId())).isEquals();
      //@formatter:on
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public int hashCode() {
      //@formatter:off
      return new HashCodeBuilder(13, 211).append(this.getLud()).append(StringUtils.upperCase(this.getLubLoginId())).toHashCode();
      //@formatter:on
   }
}
