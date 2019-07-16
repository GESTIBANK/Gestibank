package com.wha.spring.idao;

import com.wha.spring.model.Client;


public interface ClientDao {
	Client creationClient(Client client);
	
	Client findByIdentifiant(int identifiant);
	
	
	void deleteClient(int identifiant);
	
}
