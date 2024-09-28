package com.healthcare.encore.db.dao.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ckumar
 * @param <T> type
 * @param <I> index
 *
 */
public class BaseDAOImpl<T, I extends Serializable> {

   /**
    *
    */
   private Class<T> clazz;

   /**
    *
    */
   @Autowired
   private SessionFactory sessionFactory;

   /**
    *
    * @param clazz Class
    */
   public BaseDAOImpl(final Class<T> clazz) {
      this.clazz = clazz;
   }

   /**
    * @return the clazz
    */
   public Class<T> getClazz() {
      return this.clazz;
   }

   /**
    * @param clazz the clazz to set
    */
   public void setClazz(final Class<T> clazz) {
      this.clazz = clazz;
   }

   /**
    *
    * @return sessionFactory
    */
   public SessionFactory getSessionFactory() {
      return this.sessionFactory;
   }

   /**
    *
    * @param sessionFactory SessionFactory
    */
   public void setSessionFactory(final SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   /**
    *
    * @return currentSession
    */
   public Session getCurrentSession() {
      return this.getSessionFactory().getCurrentSession();
   }

   /**
    *
    * @param queryName
    * @return List
    */
   public List<T> list(final String queryName) {
      return this.list(queryName, null);
   }

   /**
    *
    * @param queryName queryName
    * @param paramNames string array of parameter names
    * @param values array of values
    * @return List
    */
   @SuppressWarnings("unchecked")
   public List<T> list(final String queryName, final String[] paramNames, final Object... values) {
      Query<T> query = (Query<T>) this.createQuery(queryName, paramNames, values);
      return query.list();
   }

   /**
    *
    * @param queryName
    * @return List
    */
   public List<T> listUnique(final String queryName) {
      return this.listUnique(queryName, null);
   }

   /**
    *
    * @param queryName queryName
    * @param paramNames string array of parameter names
    * @param values array of values
    * @return List
    */
   @SuppressWarnings({ "unchecked", "deprecation" })
   public List<T> listUnique(final String queryName, final String[] paramNames, final Object... values) {
      Query<T> query = (Query<T>) this.createQuery(queryName, paramNames, values);
      query = query.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
      return query.list();
   }

   /**
    *
    * @param queryName queryName
    * @return List
    */
   public List<Object> listObject(final String queryName) {
      return this.listObject(queryName, null);
   }

   /**
    *
    * @param queryName queryName
    * @param paramNames string array of parameter names
    * @param values array of values
    * @return List
    */
   @SuppressWarnings("unchecked")
   public List<Object> listObject(final String queryName, final String[] paramNames, final Object... values) {
      Query<Object> query = (Query<Object>) this.createQuery(queryName, paramNames, values);
      return query.list();
   }

   /**
   *
   * @param queryName queryName
   * @param paramNames string array of parameter names
   * @param values array of values
   * @return List
   */
   @SuppressWarnings("unchecked")
   public List<Object> listObjectWithLimit(final String queryName, final Integer limit, final String[] paramNames, final Object... values) {
      Query<Object> query = (Query<Object>) this.createQuery(queryName, paramNames, values);
      if (limit != null) {
         query.setMaxResults(limit);
      }
      return query.list();
   }

   /**
    *
    * @param queryName
    * @param paramNames
    * @param values
    * @return List all rows without transformation
    */
   @SuppressWarnings("unchecked")
   public List<Object[]> listAll(final String queryName, final String[] paramNames, final Object... values) {
      Query<Object[]> query = (Query<Object[]>) this.createQuery(queryName, paramNames, values);
      return query.list();
   }

   /**
    *
    * @param queryName
    * @param limit
    * @param paramNames
    * @param values
    * @return List limited rows without transformation
    */
   @SuppressWarnings("unchecked")
   public List<Object[]> listAllWithLimit(final String queryName, final Integer limit, final String[] paramNames,
            final Object... values) {
      Query<Object[]> query = (Query<Object[]>) this.createQuery(queryName, paramNames, values);
      if (limit != null) {
         query.setMaxResults(limit);
      }
      return query.list();
   }

   /**
    *
    * @param clazz
    * @param queryName
    * @param paramNames
    * @param values
    * @return Stream
    */
   @SuppressWarnings("unchecked")
   public <R> Stream<R> createStream(final Class<R> clazz, final String queryName, final String[] paramNames, final Object... values) {
      Query<R> query = (Query<R>) this.createQuery(queryName, paramNames, values);
      return query.stream();
   }

   /**
    *
    * @param <R>
    * @param returnType
    * @param queryName
    * @param paramNames
    * @param values
    * @return db row
    */
   @SuppressWarnings("unchecked")
   public <R> R findUniqueWithReturnType(final Class<R> clazz, final String queryName, final String[] paramNames, final Object... values) {
      Query<R> query = (Query<R>) this.createQuery(queryName, paramNames, values);
      return (R) query.uniqueResult();
   }

   /**
    *
    * @param queryName queryName
    * @param paramNames
    * @param values array of values
    * @return value
    */
   @SuppressWarnings("unchecked")
   public T findUnique(final String queryName, final String[] paramNames, final Object... values) {
      Query<T> query = (Query<T>) this.createQuery(queryName, paramNames, values);
      return (T) query.uniqueResult();
   }

   /**
    *
    * @param id Entity Id
    * @return Entity
    */
   public T findById(final I id) {
      return this.getCurrentSession().byId(this.clazz).load(id);
   }

   /**
    *
    * @param id Entity Id
    * @return Entity
    */
   public T getReferenceById(final I id) {
      return this.getCurrentSession().load(this.clazz, id);
   }

   /**
    *
    * @param naturalId Natural Id
    * @return Entity
    */
   public T findByNaturalId(final Serializable naturalId) {
      return this.getCurrentSession().bySimpleNaturalId(this.clazz).load(naturalId);
   }

   /**
    *
    * @param naturalId Natural Id
    * @return Entity
    */
   public T getReferenceByNaturalId(final Serializable naturalId) {
      return this.getCurrentSession().bySimpleNaturalId(this.clazz).getReference(naturalId);
   }

   /**
    * @param <V> Natural Id value
    * @param naturalId Natural Id
    * @return Entity
    */
   public <V> T findByNaturalId(final Map<String, V> naturalId) {
      NaturalIdLoadAccess<T> naturalIdLoad = this.getCurrentSession().byNaturalId(this.clazz);
      for (Map.Entry<String, V> naturalIdEntry : naturalId.entrySet()) {
         naturalIdLoad.using(naturalIdEntry.getKey(), naturalIdEntry.getValue());
      }
      return naturalIdLoad.load();
   }

   /**
    *
    * @param naturalIds Natural Ids
    * @return Entity
    */
   public T getReferenceByNaturalId(final Map<String, Object> naturalIds) {
      NaturalIdLoadAccess<T> naturalIdLoad = this.getCurrentSession().byNaturalId(this.clazz);
      for (Map.Entry<String, Object> naturalId : naturalIds.entrySet()) {
         naturalIdLoad.using(naturalId.getKey(), naturalId.getValue());
      }
      return naturalIdLoad.getReference();
   }

   /**
    *
    * @param queryName queryName
    * @param paramNames
    * @param values array of values
    * @return value
    */
   public int executeUpdate(final String queryName, final String[] paramNames, final Object... values) {
      Query<?> query = this.createQuery(queryName, paramNames, values);
      return query.executeUpdate();
   }

   /**
    *
    * @param entity Entity
    * @return Entity Id
    */
   @SuppressWarnings("unchecked")
   public I makeNewEntityPersistent(final T entity) {
      this.getCurrentSession().persist(entity);
      return (I) this.getCurrentSession().getIdentifier(entity);
   }

   /**
    *
    * @param entity
    * @return Merged entity
    */
   @SuppressWarnings("unchecked")
   public T makePersistent(final T entity) {
      T mergedEntity = (T) this.getCurrentSession().merge(entity);
      return mergedEntity;
   }

   /**
    *
    * @param entityId Entity Id
    */
   public void makeTransient(final I entityId) {
      T entity = this.findById(entityId);
      if (entity != null) {
         this.getCurrentSession().delete(entity);
         this.getCurrentSession().flush();
      }
   }

   /**
    *
    * @param entity Entity
    */
   public void makeTransient(final T entity) {
      this.getCurrentSession().delete(entity);
      this.getCurrentSession().flush();
   }

   /**
    *
    * @param entityId Entity Id
    */
   public void makeTransientWithoutFlush(final I entityId) {
      T entity = this.findById(entityId);
      if (entity != null) {
         this.getCurrentSession().delete(entity);
      }
   }

   /**
    *
    * @param entity Entity
    */
   public void makeTransientWithoutFlush(final T entity) {
      this.getCurrentSession().delete(entity);
   }

   /**
    *
    * @param entity
    * @return identifier
    */
   @SuppressWarnings("unchecked")
   public I getIdentifier(final T entity) {
      return (I) this.getCurrentSession().getIdentifier(entity);
   }

   /**
    *
    * @param entity
    * @param readOnly
    */
   public void setReadOnly(final T entity, final boolean readOnly) {
      this.getCurrentSession().setReadOnly(entity, readOnly);
   }

   /**
    *
    */
   public void flush() {
      this.getCurrentSession().flush();

   }

   /**
    *
    */
   public void clear() {
      this.getCurrentSession().clear();
   }

   /**
    *
    * @param nativeQuery
    * @param paramNames
    * @param values
    * @return List<?>
    */
   public List<?> executeNativeQuery(final String nativeQuery, final String[] paramNames, final Object... values) {
      Query<?> query = this.getCurrentSession().createNativeQuery(nativeQuery);
      for (int i = 0; i < values.length; i++) {
         if (values[i] instanceof Collection) {
            query.setParameterList(paramNames[i], (Collection<?>) values[i]);
         } else if (values[i] instanceof Instant) {
            Timestamp timestamp = values[i] != null ? Timestamp.valueOf(LocalDateTime.ofInstant((Instant) values[i], ZoneOffset.UTC))
                     : null;
            query.setParameter(paramNames[i], timestamp);
         }else {
            query.setParameter(paramNames[i], values[i]);
         }
      }
      return query.list();
   }

   /**
    *
    * @param queryName
    * @param paramNames
    * @param values
    * @return
    */
   private Query<?> createQuery(final String queryName, final String[] paramNames, final Object... values) {
      Query<?> query = this.getCurrentSession().getNamedQuery(queryName);
      for (int i = 0; i < values.length; i++) {
         if (values[i] instanceof Collection) {
            query.setParameterList(paramNames[i], (Collection<?>) values[i]);
         } else {
            query.setParameter(paramNames[i], values[i]);
         }
      }
      return query;
   }
}
