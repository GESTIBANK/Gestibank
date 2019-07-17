package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;

@Repository("demandeOuvertureDao")
@Transactional
public class DemandeOuvertureDAOImpl extends AbstractDao implements DemandeOuvertureDAO {

	@Override
	public DemandeOuverture createDemandeOuverture() {
		DemandeOuverture d=new DemandeOuverture();
		em.persist(d);
		return d;		
	}

	@Override
	public List<DemandeOuverture> getDemandeOuverture() {
	return em.createQuery("From DemandeOuverture").getResultList();
	}

	@Override
	public void updateDemandeOuverture(DemandeOuverture demandeOuverture) {
		em.merge(demandeOuverture);
		
	}

	@Override
	public List<DemandeOuverture> getDemandeOuvertureNonTraitees() {
		return em.createQuery("From DemandeOuverture do where do.aTraiter = false").getResultList();
	}
	
	@Override
	public DemandeOuverture findById(int id) {
		//Appel de la méthod init de la class Logger
		return (DemandeOuverture) em.find(DemandeOuverture.class, id);
	}

}
