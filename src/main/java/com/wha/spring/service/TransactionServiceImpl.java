package com.wha.spring.service;

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
}