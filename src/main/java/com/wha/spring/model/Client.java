package com.wha.spring.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/


/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/

@Entity
@DiscriminatorValue("Client")
@Table(name = "Client")

public class Client extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;

	@Column(name = "LISTECOMPTES", nullable = false)
	private List<Compte> comptes;
	
	@Column(name = "REVENUMENS", nullable = false)
	private double revenuMens;
	
	@Column(name = "PIECESJUSTIF", nullable = false)
	private boolean piecesJustif;
	
	@Column(name = "CONSEILLER", nullable = false)
	private  int matricule;
	
	@Column(name = "requeteclient", nullable = false)
	private  List<DemandeClient> demandeClient;
	
}

