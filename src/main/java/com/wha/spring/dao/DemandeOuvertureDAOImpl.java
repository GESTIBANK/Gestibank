package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.model.DemandeOuverture;

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

}
