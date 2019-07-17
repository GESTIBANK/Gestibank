package com.wha.spring.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_transaction")
	private int numeroTransaction;
	
	@ManyToOne()
	@JoinColumn(name="numero_compte")
    private Compte compte;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="montant")
	private int montant;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date date;
	
	//@Column(name="type_transaction")
	//private Transaction typeTransaction;
	
	@Builder
	public Transaction(int numeroTransaction, Compte compte, String libelle,
			int montant, Date date
			, Transaction typeTransaction
			) {
		super();
		this.numeroTransaction = numeroTransaction;
		this.compte = compte;
		this.libelle = libelle;
		this.montant = montant;
		this.date = date;
		//this.typeTransaction = typeTransaction;
	}
}
