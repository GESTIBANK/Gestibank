package com.wha.spring.iservice;

import com.wha.spring.model.Client;

public interface ClientIService {
	Client creationClient(Client client);

	Client findByIdentifiant(int identifiant);


	public void deleteClient(int identifiant);

}
