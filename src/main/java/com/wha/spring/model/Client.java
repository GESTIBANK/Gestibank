package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/


/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Client")
public class Client extends User implements Serializable{
	
	
	
	public Client(int id, String nom, String prenome, String email, String adresse, String telephone, String pseudo,
			String mdp) {
		super(id, nom, prenome, email, adresse, telephone, pseudo, mdp);
		
	}

	@Builder
	public Client(int id, String nom, String prenome, String email, String adresse, String telephone, String pseudo,
			String mdp, int identifiant, double revenuMens, boolean piecesJustif, Conseiller conseiller) {
		super(id, nom, prenome, email, adresse, telephone, pseudo, mdp);
		this.identifiant = identifiant;
		this.revenuMens = revenuMens;
		this.piecesJustif = piecesJustif;
		this.conseiller = conseiller;
	}

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(unique=true, nullable=true)
	private int identifiant;

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	private List<Compte> comptes;
	
	@Column(name = "REVENUMENS", nullable = true)
	private double revenuMens;
	
	@Column(name = "PIECESJUSTIF", nullable = true)
	private boolean piecesJustif;
	
	@ManyToOne()
	private  Conseiller conseiller;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private  List<DemandeClient> demandeClient;
	
	
	
}

