package com.wha.spring.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction")
public class Transaction {
	@Id
	@Column(name="numero_transaction")
	private int numeroTransaction;

	@ManyToOne()
    private Compte compte;
	
	@Column(name="libelle")
	private String libelle;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date date;
}
