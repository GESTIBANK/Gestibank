package com.wha.spring.idao;



import com.mysql.fabric.xmlrpc.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.User;


public interface ConseillerDao  {
void modificationDecouvert(Compte compte, int montant);
void modificationRemuneration(Compte compte, float montant);
void validerDemandeChequier(Compte compte);
void validationDemandeOuverture();
void gelerCompte(Compte compte);
void rechercheParClient(String identifient);
void rechercheParCompte(String numcompte);
Compte aficherDetail(Compte compte);
Client afficherDetail(Client client);
public User findById(int id);
public void deleteUser(int id);
}
