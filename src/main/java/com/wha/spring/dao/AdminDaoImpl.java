package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdminDao;
import com.wha.spring.model.Admin;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.User;

@Repository("adminDao")
@Transactional
public class AdminDaoImpl extends AbstractDao implements AdminDao {
	

	@Override
	public void creationAdmin(Admin administrateur) {
		em.persist(administrateur);
	}

	@Override
	public void creationConseiller(Conseiller conseiller) {
		em.persist(conseiller) ;
		
	}

	@Override
	public Conseiller findById(int id) {
		//Appel de la méthod init de la class Logger
		return (Conseiller) em.find(Conseiller.class, id);
	}

	/*@Override
	public void suppressionConseiller(Conseiller conseiller){
		em.remove(conseiller);
	}*/

}
