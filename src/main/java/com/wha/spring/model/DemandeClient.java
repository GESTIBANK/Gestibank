package com.wha.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "DemandeClient")
public class DemandeClient implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
	private DemandeClientPK idDemenande; 
	
	@Column(name = "MESSAGE", nullable = false)
    private String message;
	
	@Column(name = "TYPEREQUETE", nullable = false)
	@Enumerated(EnumType.STRING)
    private Typerequete typeRequete;

}
