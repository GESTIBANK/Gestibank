package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

public interface AdminService {
	
	Conseiller creationConseiller(Conseiller conseiller);
	
	void supprimerConseiller(Conseiller conseiller);
	
	void createAdmin(Admin administrateur);
	
	void reaffectationClient(Client client, Conseiller conseiller);
	
	void affectationDemandeOuverture(List<DemandeOuverture> demandeOuvertureList,int id);

}
