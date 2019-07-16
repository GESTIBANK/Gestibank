package com.wha.spring.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

@Service("conseillerService")
@Transactional
public class ConseillerServiceImpl implements ConseillerService{

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client validationDemandeOuverture(DemandeOuverture demandeOuverture) {
		demandeOuverture.setValide(true);		
		Client client= new Client(0, demandeOuverture.getClientPotentiel().getNom(), demandeOuverture.getClientPotentiel().getPrenome(), demandeOuverture.getClientPotentiel().getEmail(), "", "", "", "");
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
	public void afficherDetail(Client client) {
		// TODO Auto-generated method stub
		
	}

	
	
}
