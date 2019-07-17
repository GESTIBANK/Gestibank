package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.DemandeOuverture;

public interface DemandeOuvertureDAO {
	
	DemandeOuverture createDemandeOuverture();
	List<DemandeOuverture> getDemandeOuverture();
	void updateDemandeOuverture(DemandeOuverture demandeOuverture);


}
