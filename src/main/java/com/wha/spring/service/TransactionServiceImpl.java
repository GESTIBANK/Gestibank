package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.TransactionDao;
import com.wha.spring.iservice.TransactionService;
import com.wha.spring.model.Transaction;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionDao transactionDao;
//	public void createTransaction(Transaction transaction){
//		 transactionDao.creationTransaction(transaction);
//	}
	@Override
	public Transaction creationTransaction(Transaction transaction) {
		transactionDao.creationTransaction(transaction);
		return transaction;
		
	}
	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionDao.getAllTransaction();
	}
	@Override
	public List<Transaction> getTransactionByCompte(int numCompte) {
		// TODO Auto-generated method stub
		return transactionDao.getTransactionByCompte(numCompte);
	}
}