package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@Table(name = "DemandeOuverture")
public class DemandeOuverture implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(mappedBy = "demandeOuverture")
	private ClientPotentiel clientPotentiel;
	boolean valide;
	@ManyToOne()
	private Admin admin;
	
	@ManyToOne()
	private Conseiller conseiller;

}
