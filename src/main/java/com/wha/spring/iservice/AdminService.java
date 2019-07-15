package com.wha.spring.iservice;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

public interface AdminService {
	
	Conseiller creationConseiller();
	
	void supprimerConseiller(Conseiller conseiller);
	
	void creationAdmin(Admin administrateur);
	
	void reaffectationClient(Client client, Conseiller conseiller);
	
	void affectationDemandeOuverture(DemandeOuverture demande, Conseiller conseiller);

}
