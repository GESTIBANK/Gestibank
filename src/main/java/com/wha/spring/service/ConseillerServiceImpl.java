package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wha.spring.idao.ClientDao;
import com.wha.spring.idao.CompteDao;
import com.wha.spring.idao.ConseillerDao;
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
	@Autowired
	ConseillerDao conseillerDao;
	
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
		//Compte compte = new Compte();
		Client client= new Client(0, demandeOuverture.getClientPotentiel().getNom(), demandeOuverture.getClientPotentiel().getPrenom(), demandeOuverture.getClientPotentiel().getEmail(),"pseeudo", "mdp", "", "");
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

	@Override
	public Compte creerCompteClient(Client client) {
		//{"numeroCompte" : 0,"client" : null,"rib" : 25,"solde" : 50,"decouvert" : 60,"montantAgios" : 30,"seuilRemuneration" : 300,    "typeCompte" : "cheque","gele" : false}
		
		Compte compte = new Compte(0, client, 2111616, 150, 1000, 1,(float) 300.00 , "remuneration", false);
		compteDao.createCompte(compte);
		return compte;
	}

	@Override
	public void setClientList(List<Client> client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conseiller findById(int id) {
		return (Conseiller) conseillerDao.findById(id);
	}

	@Override
	public List<Conseiller> findAll() {
		return conseillerDao.findAll();
	}

	
	
}
