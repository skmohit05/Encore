package com.healthcare.encore.db.dao.hibernate.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*
 * Global converter for storing Instant as UTC value in database
 * and converting it back to Instant after reading from database
 */
/**
 * 
 * @author ckumar
 *
 */
@Converter(autoApply = true)
public class InstantUTCConverter implements AttributeConverter<Instant, Timestamp> {

   /**
    * 
    */
   @Override
   public Timestamp convertToDatabaseColumn(final Instant attribute) {
      if (attribute == null) {
         return null;
      }
      return Timestamp.valueOf(LocalDateTime.ofInstant(attribute, ZoneOffset.UTC));
   }

   /**
    * 
    */
   @Override
   public Instant convertToEntityAttribute(final Timestamp dbData) {
      if (dbData == null) {
         return null;
      }
      return dbData.toLocalDateTime().toInstant(ZoneOffset.UTC);
   }
}
