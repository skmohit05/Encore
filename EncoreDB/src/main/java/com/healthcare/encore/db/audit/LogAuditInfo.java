/**
 *
 */
package com.healthcare.encore.db.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to enable automatic logging of Lud and Lub fields in DTO objects
 * 
 * @author ckumar
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LogAuditInfo {
}
