package com.wha.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeClientDao;
import com.wha.spring.model.DemandeClient;

@Repository("demandeClientDao")
@Transactional
public class DemandeClientDaoImpl extends AbstractDao implements DemandeClientDao{

	@Override
	public void createDemande(DemandeClient demandeClient) {
		em.persist(demandeClient);
		
	}

	

}
