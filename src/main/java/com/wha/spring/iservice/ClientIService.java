package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.User;

public interface ClientIService {

	// creation
	Client creationClient(Client client);

	// suppression
	public void deleteClient(int identifiant);
	
	//affichage de tous les clients
	List<Client> findAllClients();
	Client findById(int id);
	
	void updateClient(Client client);
	
	

	
}
