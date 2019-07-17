package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Client;

public interface ClientIService {

	// creation
	Client creationClient(Client client);

	// suppression
	public void deleteClient(int identifiant);
	
	//affichage de tous les clients
	List<Client> findAllClients();

	
}
