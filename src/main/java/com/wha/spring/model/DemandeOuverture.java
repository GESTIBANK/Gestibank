package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToOne(mappedBy = "demandeOuverture")
	private ClientPotentiel clientPotentiel;
	
	@Column()
	private boolean aTraiter=false;
	@Column()
	boolean valide=false;
	@ManyToOne()
	private Admin admin;
	
	@ManyToOne()
	private Conseiller conseiller;

}
