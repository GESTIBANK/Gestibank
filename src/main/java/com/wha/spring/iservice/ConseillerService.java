package com.wha.spring.iservice;

import com.mysql.fabric.xmlrpc.Client;
import com.wha.spring.model.Compte;


public interface ConseillerService {
	void modificationDecouvert(Compte compte, double montant);
	void modificationRemuneration(Compte compte, double montant);
	void validerDemandeChequier(Compte compte);
	void validationDemandeOuverture();
	void gelerCompte(Compte compte);
	void rechercheParClient(String identifient);
	void rechercheParCompte(String numcompte);
	void aficherDetail(Compte compte);
	void afficherDetail(Client client);

}
