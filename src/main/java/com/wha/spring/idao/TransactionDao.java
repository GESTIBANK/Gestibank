package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Transaction;

public interface TransactionDao {
	public void creationTransaction(Transaction transaction);

	public List<Transaction> getAllTransaction();

	public List<Transaction> getTransactionByCompte(int numCompte);

//	public void deleteOperation(Integer numeroOperation);
//
//	public Operation updateOperation(Operation operation);
//
//	public Operation getOperation(int numeroOperation);

}
