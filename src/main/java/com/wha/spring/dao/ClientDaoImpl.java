package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;


@Repository("clientDao")
@Transactional
public class ClientDaoImpl extends AbstractDao implements ClientDao {

	
	@Override
	public Client creationClient(Client client) {
		em.persist(client);
		return client;
	}
	
			
	//recherche d'un client par son identifiant
	@Override
	public Client findByIdentifiant(int id) {
		//Appel de la méthod init de la class Logger
		return  em.find(Client.class, id);
	}
	
	//suppression d'un client par son identifiant
	@Override
	public void deleteClient(int identifiant) {
		em.remove(findByIdentifiant(identifiant));
		
	}


	@Override
	public List<Client> findAllClients() {
		return em.createQuery("From Client").getResultList();
	}
	
	@Override
	public void updateClient(Client client) {
		em.merge(client);
	}


	
	
}
