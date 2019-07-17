package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Compte;
import com.wha.spring.model.Transaction;

public interface CompteService {
	Compte createCompte(Compte compte);
	
	Compte findById(int id);

	void updateCompte(Compte compte);

	 List<Compte> findAllComptes();

	 void deleteCompte(int id);
	 void createTransaction(Transaction transaction);
	 
	 List<Compte> findCompteByClient(int id);
	

}
