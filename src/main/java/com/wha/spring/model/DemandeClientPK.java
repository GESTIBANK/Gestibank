package com.wha.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DemandeClientPK implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Column(name = "IDENTIFIANT", nullable = false)
	private int identifiant; /*id du client*/
	

	@Column(name = "NUMEROCOMPTE", nullable = false)
	private int numeroCompte; /*id du compte du client*/

}
