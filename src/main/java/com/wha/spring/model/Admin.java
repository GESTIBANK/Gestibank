package com.wha.spring.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Admin")
public class Admin extends User{
	
	private List<Conseiller> listeConseillers;
	private List<DemandeOuverture> listeDemandeOuverture;

}
