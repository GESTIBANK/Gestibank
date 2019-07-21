package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;

import com.wha.spring.iservice.ClientIService;
import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;

@Service("clientIService")
@Transactional
public class ClientIServiceImpl implements ClientIService {

	@Autowired
	ClientDao clientDao;

	public Client creationClient(Client client) {
		clientDao.creationClient(client);
		return client;
	}

	@Override
	public void deleteClient(int identifiant) {
		clientDao.deleteClient(identifiant);
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return clientDao.findAllClients();
	}

	@Override
	public Client findById(int id) {
		return clientDao.findByIdentifiant(id);
	}

	@Override
	public void updateClient(Client client) {
		
		clientDao.updateClient(client);
	}

	@Override
	public Conseiller getConseillerByClient(int id) {
		return clientDao.findByIdentifiant(id).getConseiller();
	}




}
