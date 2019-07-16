package com.wha.spring.iservice;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

public interface AdminService {
	
	Conseiller creationConseiller(int id);
	
	void supprimerConseiller(Conseiller conseiller);
	
	void createAdmin(Admin administrateur);
	
	void reaffectationClient(Client client, Conseiller conseiller);
	
	void affectationDemandeOuverture(Conseiller conseiller);

}
