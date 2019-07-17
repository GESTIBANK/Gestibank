package com.wha.spring.iservice;


import java.util.List;

import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;


public interface ConseillerService {
	void modificationDecouvert(Compte compte, double montant);
	void modificationRemuneration(Compte compte, double montant);
	void validerDemandeChequier(Compte compte);
	Client validationDemandeOuverture(DemandeOuverture demandeOuverture);
	void gelerCompte(Compte compte);
	void rechercheParClient(String identifient);
	void rechercheParCompte(String numcompte);
	void aficherDetail(Compte compte);
	Client afficherDetail(int id);
	Compte creerCompteClient(Client client);
	void setClientList(List<Client> client);
	Conseiller findById(int id);

}
