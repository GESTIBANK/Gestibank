package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable{
	
	
	@OneToMany(mappedBy="admin", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Conseiller> listeConseillers;
	@OneToMany(mappedBy="admin")
	private List<DemandeOuverture> listeDemandeOuverture;

}
