package com.wha.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wha.spring.model.enums.TypeRequest;

@Entity
@Table(name = "DemandeClient")
public class DemandeClient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDemande;
	
	@ManyToOne()
	private Client client;
	
	@Enumerated(EnumType.STRING)
	@Column(length=12)
	private TypeRequest  type;
	
	@Column(name = "MESSAGE", nullable = false)
    private String message;
	
	@Column(name = "IDENTIFIANT", nullable = false)
	private int identifiant; /*id du client*/
	

	@Column(name = "NUMEROCOMPTE", nullable = false)
	private int numeroCompte; /*id du compte du client*/
	
	
}
