package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wha.spring.model.Compte.CompteBuilder;
import com.wha.spring.model.enums.TypeRequest;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "DemandeClient")
public class DemandeClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDemande;

	@ManyToOne()
	private Client client;

	@Enumerated(EnumType.STRING)
	@Column(length = 12)
	private TypeRequest type;

	@Column(name = "MESSAGE", nullable = false)
	private String message;

	@Column(name = "NUMEROCOMPTE", nullable = false)
	private int numeroCompte;

	

}
