package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Compte;
import com.wha.spring.model.Transaction;

public interface TransactionService {
	Transaction creationTransaction(Transaction transaction);
	
	List<Transaction> getAllTransaction();

	List<Transaction> getTransactionByCompte(int numCompte);
}
