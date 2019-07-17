package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.DemandeOuverture;

public interface DemandeOuvertureDAO {
	
	DemandeOuverture createDemandeOuverture();
	List<DemandeOuverture> getDemandeOuverture();
	List<DemandeOuverture> getDemandeOuvertureNonTraitees();
	void updateDemandeOuverture(DemandeOuverture demandeOuverture);
	 DemandeOuverture findById(int id);


}
