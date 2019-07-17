package com.wha.spring.service;


import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.idao.CompteDao;
import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

@Service("conseillerService")
@Transactional
public class ConseillerServiceImpl implements ConseillerService{

	@Autowired
	DemandeOuvertureDAO demandeOuvertureDao;
	@Autowired
	ClientDao clientDao;
	
	@Autowired
	CompteDao compteDao;
	
	@Override
	public void modificationDecouvert(Compte compte, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificationRemuneration(Compte compte, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validerDemandeChequier(Compte compte) {
		
		
	}

	@Override
	public Client validationDemandeOuverture(DemandeOuverture demandeOuverture) {
		demandeOuverture.setValide(true);		
		Client client= new Client(0, demandeOuverture.getClientPotentiel().getNom(), demandeOuverture.getClientPotentiel().getPrenom(), demandeOuverture.getClientPotentiel().getEmail(), "", "", "", "");
		demandeOuvertureDao.updateDemandeOuverture(demandeOuverture);
		clientDao.creationClient(client);
		return client;
	}

	@Override
	public void gelerCompte(Compte compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rechercheParClient(String identifient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rechercheParCompte(String numcompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aficherDetail(Compte compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client afficherDetail(int id) {
		
		return (Client) clientDao.findByIdentifiant(id);
		
	}

	
	
}
