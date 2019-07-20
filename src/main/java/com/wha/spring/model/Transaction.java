package com.wha.spring.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wha.spring.model.enums.TypeRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("Transaction")
@DiscriminatorColumn(name="TransactionType", discriminatorType=DiscriminatorType.STRING)
//@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_transaction")
	private int numeroTransaction;
	
	@ManyToOne()
	@JoinColumn(name="numero_compte")
    private Compte compte;
	
	@Enumerated(EnumType.STRING)
	@Column(name="typeMvt")
	private TypeTransaction typeMvt;
	
	@Column(name="montant")
	private int montant;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date date= new Date();
	
	//@Column(name="type_transaction")
	//private Transaction typeTransaction;
	
	@Builder
	public Transaction(int montant, Date date, TypeTransaction typeMvt) {
		super();
		
		this.montant = montant;
		this.date = date;
		this.typeMvt = typeMvt;
	}
}
