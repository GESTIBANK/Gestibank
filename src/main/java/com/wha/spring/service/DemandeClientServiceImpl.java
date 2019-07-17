package com.wha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeClientDao;
import com.wha.spring.iservice.DemandClientService;
import com.wha.spring.model.DemandeClient;

@Service("demandeClientServiceImpl")
@Transactional
public class DemandeClientServiceImpl implements DemandClientService{
	@Autowired
	DemandeClientDao demandeClientDao;
	
	@Override
	public void createDemande(DemandeClient demandeClient) {
		demandeClientDao.createDemande(demandeClient);
		
	}
	

}
