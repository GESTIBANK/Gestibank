package com.wha.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.model.Compte;

@Repository("compteDao")
@Transactional
public class CompteDaoImpl extends AbstractDao implements CompteDao {
	@Override
	public void creationCompte(Compte compte) {
		em.persist(compte);
	}
}
