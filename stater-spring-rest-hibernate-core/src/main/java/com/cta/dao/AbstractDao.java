package com.cta.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public abstract class AbstractDao {

	@PersistenceContext
	private EntityManager em;
	
	protected Session unwrap() {
		return em.unwrap(Session.class);
	}
}
