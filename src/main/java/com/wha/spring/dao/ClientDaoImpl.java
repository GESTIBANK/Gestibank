package com.wha.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.model.Client;


@Repository("clientDao")
@Transactional
public class ClientDaoImpl extends AbstractDao implements ClientDao {

	
	@Override
	public void creationClient(Client client) {
		em.persist(client);
	}
	
			
	//recherche d'un client par son identifiant
	@Override
	public Client findByIdentifiant(int identifiant) {
		//Appel de la méthod init de la class Logger
		return (Client) em.find(Client.class, identifiant);
	}
	
	//suppression d'un client par son identifiant
	@Override
	public void deleteClient(int identifiant) {
		em.remove(findByIdentifiant(identifiant));
		
	}
	
	

}
