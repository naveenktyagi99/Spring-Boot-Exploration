/**
 * 
 */
package com.springboot.exploration.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Naveen Tyagi
 *
 * @param <PK>
 * @param <T>
 */

public abstract class AbstractDAOTemplate<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDAOTemplate() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public T getByKeyString(String email) {
		return (T) getSession().get(persistentClass, email);
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> T saveEntity(T entity) {
		return (T) getSession().merge(entity);
	}

	public void updateEntity(T entity) {
		getSession().merge(entity);
	}

	public void deleteEntity(T entity) {
		getSession().delete(entity);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	protected Query createEntityQuery(String queryString) {
		return getSession().createQuery(queryString);
	}

	protected Query createSqlQuery(String queryString) {
		return getSession().createSQLQuery(queryString);
	}

	protected Criteria createEntityCriteria(String classAlias) {
		return getSession().createCriteria(persistentClass, classAlias);
	}

	protected Criteria createEntityCriteria(Class<?> class1) {
		return getSession().createCriteria(class1);
	}
}