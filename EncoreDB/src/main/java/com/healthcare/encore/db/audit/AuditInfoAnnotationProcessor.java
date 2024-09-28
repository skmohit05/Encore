/**
 *
 */
package com.healthcare.encore.db.audit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

/**
 * Identifies DTO classes that have been annotated with LogAuditInfo
 * *
 * @author ckumar
 */
@Component
public class AuditInfoAnnotationProcessor {

   /**
    *
    */
   private final List<Class<?>> auditInfoClasses = new ArrayList<Class<?>>();

   /**
    * Identifies classes that have LogAuditInfo annotation set
    * 
    * @throws IOException
    * @throws ClassNotFoundException
    * @throws LinkageError
    */
   @PostConstruct
   public void init() throws IOException, ClassNotFoundException, LinkageError {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      SimpleMetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory();
      Resource[] resources =
               new PathMatchingResourcePatternResolver().getResources("classpath:com/healthcare/encore/db/dto/*");
      for (Resource resource : resources) {
         MetadataReader reader = readerFactory.getMetadataReader(resource);
         Class<?> clazz = ClassUtils.forName(reader.getClassMetadata().getClassName(), loader);
         if (clazz.isAnnotationPresent(LogAuditInfo.class)) {
            this.auditInfoClasses.add(clazz);
         }
      }
   }

   /**
    * 
    * @param object
    * @return true, if audit logging is enables
    */
   public boolean isAuditInfoLoggable(final Object object) {
      return this.auditInfoClasses.contains(object.getClass());
   }
}
