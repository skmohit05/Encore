package com.healthcare.encore.db.dto;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.healthcare.encore.db.core.EncoreDBCoreVersionConstants;


/**
 * The persistent class for the EnumAssignmentType database table.
 *
 * @author mmeena
 *
 */
//@formatter:off
//@LogAuditInfo
@NamedQueries({
   @NamedQuery(
            name = "EnumAssignmentTypeDTO.findAll",
            query = "SELECT e"
                     + " FROM EnumAssignmentTypeDTO e"
                     + " WHERE (:applyActiveFilter=false OR e.active=true)",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
   @NamedQuery(
            name = "EnumAssignmentTypeDTO.findByName",
            query = "SELECT e FROM EnumAssignmentTypeDTO e WHERE e.name=:name",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}) })
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "EnumAssignmentType")
@AttributeOverrides({
   @AttributeOverride(name = "id", column = @Column(name = "AssignmentTypeId", nullable = false)),
   @AttributeOverride(name = "name", column = @Column(name = "AssignmentTypeName", length = 128, nullable = false)),
   @AttributeOverride(name = "desc", column = @Column(name = "AssignmentTypeDesc", length = 512)) })
@NaturalIdCache
//@formatter:on
public class EnumAssignmentTypeDTO extends EnumBaseSetupDTO implements Serializable {
   /**
    *
    */
   private static final long serialVersionUID = EncoreDBCoreVersionConstants.SERIAL_VERSION_UID;

}
