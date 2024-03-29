package com.wha.spring.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wha.spring.model.Admin.AdminBuilder;

import java.util.List;

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
@Table(name = "Compte")
public class Compte implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="numero_compte")
	private int numeroCompte;

	@ManyToOne()
	private Client client;
	
	@Column(name="rib")
	private int rib;
	
	@Column(name="solde")
	private float solde;
	
	@JsonIgnore
	@OneToMany(mappedBy="compte", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Transaction> transactions;
	
	@Column(name="decouvert")
	private int decouvert;
	
	@Column(name="montant_agios")
	private int montantAgios;
	
	@Column(name="seuil_remuneration")
	private float seuilRemuneration;

	@Column(name="type_compte")
	private String typeCompte;
	
	@Column(name="gele")
	private Boolean gele;
	@JsonIgnore
	@OneToMany(mappedBy="compte", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Notification> notifications;


	@Builder
	public Compte(int numeroCompte, Client client, int rib, float solde,
			int decouvert, int montantAgios, float seuilRemuneration,
			String typeCompte, Boolean gele) {
		
		super();
		this.numeroCompte = numeroCompte;
		this.client = client;
		this.rib = rib;
		this.solde = solde;
		this.decouvert = decouvert;
		this.montantAgios = montantAgios;
		this.seuilRemuneration = seuilRemuneration;
		this.typeCompte = typeCompte;
		this.gele = gele;
	}
	
}

