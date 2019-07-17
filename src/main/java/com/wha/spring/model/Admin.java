package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable {

	@OneToMany(mappedBy = "admin", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE })
	private List<Conseiller> listeConseillers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	private List<DemandeOuverture> listeDemandeOuverture;

	@Builder
	public Admin(int id, String nom, String prenome, String email,
			String adresse, String telephone, String pseudo, String mdp,
			List<Conseiller> listeConseillers,
			List<DemandeOuverture> listeDemandeOuverture) {
		super(id, nom, prenome, email, adresse, telephone, pseudo, mdp);
		this.listeConseillers = listeConseillers;
		this.listeDemandeOuverture = listeDemandeOuverture;
	}

}
