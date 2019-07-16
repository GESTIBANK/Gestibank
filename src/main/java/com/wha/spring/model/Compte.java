package com.wha.spring.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Compte")
public class Compte implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="numero_compte")
	private int numeroCompte;

	@ManyToOne()
	private Client client;
	
	@Column(name="rib")
	private int rib;
	
	@Column(name="solde")
	private float solde;
	
	
	@OneToMany(mappedBy="compte", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Transaction> transactions;
	
	@Column(name="decouvert")
	private int decouvert;
	
	@Column(name="montant_agios")
	private int montantAgios;
	
	@Column(name="seuil_remuneration")
	private float seuilRemuneration;

	@Column(name="montant_remuneration")
	private String typeCompte;
	
	
	@OneToMany(mappedBy="compte", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Notification> notifications;
}

