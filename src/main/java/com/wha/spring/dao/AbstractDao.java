package com.wha.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.spring.model.User;

public abstract class AbstractDao {
	@PersistenceContext
	protected EntityManager em;


	protected void persist(Object entity) {
		em.persist(entity);
	}

	protected void delete(Object entity) {
		em.remove(entity);
	}
}
