package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdminDao;
import com.wha.spring.model.Admin;
import com.wha.spring.model.User;

@Repository("adminDao")
@Transactional
public class AdminDaoImpl extends AbstractDao implements AdminDao {
	

	@Override
	public void creationAdmin(Admin administrateur) {
		em.persist(administrateur);
	}

	

}
