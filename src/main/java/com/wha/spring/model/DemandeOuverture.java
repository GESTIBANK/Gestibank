package com.wha.spring.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandeOuverture {
	
	ClientPotentiel clienpotentiel;
	boolean valide;
	Conseiller conseiller;
	
	public DemandeOuverture(ClientPotentiel clientpotentiel){
		
	}

}
