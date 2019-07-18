package com.wha.spring.iservice;

import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;

public interface DemandeOuvertureService {

	void updateDemandeOuverture(DemandeOuverture demandeOuverture);
	DemandeOuverture findById(int id);
	
}
