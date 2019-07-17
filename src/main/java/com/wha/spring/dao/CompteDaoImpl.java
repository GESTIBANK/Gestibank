package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.model.Compte;

@Repository("compteDao")
@Transactional
public class CompteDaoImpl extends AbstractDao implements CompteDao {
	@Override
	public Compte createCompte(Compte compte) {
		em.persist(compte);
		return compte;
	}

	@Override
	public void updateCompte(Compte compte) {
		// TODO Auto-generated method stub
		em.merge(compte);
	}

	@Override
	public List<Compte> findAllComptes() {
		// TODO Auto-generated method stub
		return em.createQuery("From Compte").getResultList();	
		}

	@Override
	public Compte findById(int id) {
		// TODO Auto-generated method stub
		return (Compte) em.find(Compte.class, id);
	}

	@Override
	public void deleteCompte(int id) {
		// TODO Auto-generated method stub
		em.remove(findById(id));
	}

}
