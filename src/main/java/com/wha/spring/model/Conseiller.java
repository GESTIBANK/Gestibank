package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Conseiller")
public class Conseiller extends User implements Serializable{

@Column(unique=true, nullable=true)
private int matricule;

@JsonIgnore
@OneToMany(mappedBy = "conseiller")
@JsonIgnore
private List<Client> listeClients;

@ManyToOne()
private Admin admin;


@JsonIgnore
@OneToMany(mappedBy = "conseiller")
private List<DemandeOuverture> demandeOuvertureList;



@Builder
public Conseiller(int id, String nom, String prenome, String email, String adresse, String telephone, int matricule,
		String mdp, String pseudo, List<Client> listeClients, Admin admin, List<DemandeOuverture> demandeOuvertureList) {
	super(id, nom, prenome, email, adresse, telephone, pseudo, mdp);
	this.matricule = matricule;
	this.listeClients = listeClients;
	this.admin = admin;
	this.demandeOuvertureList = demandeOuvertureList;
}



}
