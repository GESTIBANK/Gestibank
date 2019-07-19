package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;

public interface AdminService {
	
	Conseiller creationConseiller(Conseiller conseiller);
	
	void supprimerConseiller(Conseiller conseiller);
	
	void createAdmin(Admin administrateur);
	
	void affectationClient(List<Client> clientList, int id);
	
	void affectationDemandeOuverture(List<DemandeOuverture> demandeOuvertureList,int id);
	Conseiller findById(int id);

}
