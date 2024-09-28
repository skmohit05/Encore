/**
 *
 */
package com.healthcare.encore.db.dao;

import java.io.Serializable;

/**
 * @author ckumar
 * @param <T> Type
 * @param <I> Index of the type
 *
 */
public interface BaseDAO<T, I extends Serializable> {

   /**
    *
    * @param entityId entityId
    * @return entity
    */
   T findById(I entityId);

   /**
    *
    * @param entity
    * @return id of the entity
    */
   I makeNewEntityPersistent(final T entity);

   /**
    *
    * @param entity entity
    * @return entity
    */
   T makePersistent(T entity);

   /**
    *
    * @param entityId entityId
    */
   void makeTransient(I entityId);

   /**
    *
    * @param entity entity
    */
   void makeTransient(T entity);

   /**
    *
    * @param entityId entityId
    */
   void makeTransientWithoutFlush(I entityId);

   /**
    *
    * @param entity entity
    */
   void makeTransientWithoutFlush(T entity);

   /**
    *
    * @param entity
    * @param readOnly
    */
   void setReadOnly(T entity, boolean readOnly);

   /**
    * Pushes the changes to the database
    */
   void flush();

   /**
    * Removes data objects from session
    */
   void clear();
}
