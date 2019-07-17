package com.wha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.iservice.DemandeOuvertureService;
import com.wha.spring.model.DemandeOuverture;



@Service("demandeOuvertureServiceImpl")
@Transactional
public class DemandeOuvertureServiceImpl implements DemandeOuvertureService{
	@Autowired
	DemandeOuvertureDAO demandeOuvertureDao;

	@Override
	public void updateDemandeOuverture(DemandeOuverture demandeOuverture) {
		
		demandeOuvertureDao.updateDemandeOuverture(demandeOuverture);
	}
	
	

}
