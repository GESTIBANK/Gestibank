package com.wha.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.TransactionDao;
import com.wha.spring.model.Transaction;

@Repository("transactionDao")
@Transactional
public class TransactionDaoImpl extends AbstractDao implements TransactionDao{

	public void creationTransaction(Transaction transaction){
		em.persist(transaction);
	}

}