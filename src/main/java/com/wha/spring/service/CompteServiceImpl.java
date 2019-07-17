package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.idao.TransactionDao;
import com.wha.spring.iservice.ClientIService;
import com.wha.spring.iservice.CompteService;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Transaction;

@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService{
	
	@Autowired
	CompteDao compteDAO;
	@Autowired
	ClientIService clientService;
	
	@Autowired
	TransactionDao transactionDAO;
	
	@Override
	public Compte createCompte(Compte compte) {
		return compteDAO.createCompte(compte);
	}

	@Override
	public Compte findById(int id) {
		return compteDAO.findById(id);
	}

	@Override
	public void updateCompte(Compte compte) {
		compteDAO.updateCompte(compte);
		
	}

	@Override
	public List<Compte> findAllComptes() {
		return compteDAO.findAllComptes();
	}

	@Override
	public void deleteCompte(int id) {
		compteDAO.deleteCompte(id);		
	}

	@Override
	public void createTransaction(Transaction transaction) {
		transactionDAO.creationTransaction(transaction);
		
	}

	@Override
	public List<Compte> findCompteByClient(int id) {
		return compteDAO.findCompteByClient(clientService.findById(id));	}


}