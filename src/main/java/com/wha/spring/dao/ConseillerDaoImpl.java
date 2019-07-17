package com.wha.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.model.Client;
import com.wha.spring.model.ClientPotentiel;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;



@Repository("conseillerDao")
@Transactional
public class ConseillerDaoImpl extends AbstractDao implements ConseillerDao{
	

	@Override
	public void modificationDecouvert(Compte compte, int montant) {
		
		compte.setDecouvert(montant);
		em.merge(compte);
	}

	@Override
	public void modificationRemuneration(Compte compte, float montant) {
		compte.setSeuilRemuneration(montant);
		
	}

	@Override
	public void validerDemandeChequier(Compte compte) {
		//compte.getClient().getDemandeClient().set(index, element)
		
	}

	@Override
	public Client validationDemandeOuverture(DemandeOuverture demandeOuverture, Conseiller conseiller) {
		demandeOuverture.setValide(true);
		demandeOuverture.setConseiller(conseiller);
		Client client= new Client(0, demandeOuverture.getClientPotentiel().getNom(), demandeOuverture.getClientPotentiel().getPrenom(), demandeOuverture.getClientPotentiel().getEmail(), "", "", "", "");
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
		
		
	}	


	@Override
	public User findById(int id) {
		return (User) em.find(User.class, id);
	}

	@Override
	public void deleteUser(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public Compte aficherDetailCompte(Compte compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client afficherDetailClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Conseiller conseiller) {
		
		em.merge(conseiller);
		
	}


	

	

}
