package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;


public interface ClientDao {
	Client creationClient(Client client);
	
	Client findByIdentifiant(int identifiant);
	
	
	void deleteClient(int identifiant);

	List<Client> findAllClients();
	
}
