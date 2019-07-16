package com.wha.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.Client;
import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
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
	public void validationDemandeOuverture() {
		// TODO Auto-generated method stub
		
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
	public Compte aficherDetail(Compte compte) {
		return compte;
		
	}

	@Override
	public Client afficherDetail(Client client) {
		return client;
		
	}


	@Override
	public User findById(int id) {
		return (User) em.find(User.class, id);
	}

	@Override
	public void deleteUser(int id) {
		em.remove(findById(id));
		
	}

	

}
