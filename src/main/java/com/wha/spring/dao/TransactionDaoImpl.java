package com.wha.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.TransactionDao;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Transaction;

@Repository("transactionDao")
@Transactional
public class TransactionDaoImpl extends AbstractDao implements TransactionDao{

	public void creationTransaction(Transaction transaction){
		em.persist(transaction);
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return em.createQuery("From Transaction").getResultList();	
		}

	@Override
	public List<Transaction> getTransactionByCompte(int numCompte) {
		return em.createQuery("From Transaction  where numero_compte=:numCompte").setParameter("numCompte", numCompte).getResultList();	
	}

}