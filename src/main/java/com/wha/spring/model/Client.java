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

import lombok.AllArgsConstructor;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(unique=true, nullable=true)
	private int identifiant;

	@OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	private List<Compte> comptes;
	
	@Column(name = "REVENUMENS", nullable = true)
	private double revenuMens;
	
	@Column(name = "PIECESJUSTIF", nullable = true)
	private boolean piecesJustif;
	
	@ManyToOne()
	private  Conseiller conseiller;
	
	@OneToMany(mappedBy = "client")
	private  List<DemandeClient> demandeClient;
	
}

