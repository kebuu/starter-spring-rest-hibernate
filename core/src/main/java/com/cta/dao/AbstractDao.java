package com.cta.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

public abstract class AbstractDao {

	@PersistenceContext
	private EntityManager em;
	
	protected Session getHibernateSession() {
		return em.unwrap(Session.class);
	}
	
	protected Criteria createQuery(Class<?> clazz) {
		return getHibernateSession().createCriteria(clazz);
	}
}
