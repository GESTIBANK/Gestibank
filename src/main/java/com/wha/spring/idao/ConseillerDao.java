package com.wha.spring.idao;




import java.util.List;

import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;


 public interface ConseillerDao  {
void modificationDecouvert(Compte compte, int montant);
void modificationRemuneration(Compte compte, float montant);
void validerDemandeChequier(Compte compte);
Client validationDemandeOuverture(DemandeOuverture demandeOuverture, Conseiller conseiller);
void gelerCompte(Compte compte);
void rechercheParClient(String identifient);
void rechercheParCompte(String numcompte);
Compte aficherDetailCompte(Compte compte);
Client afficherDetailClient(Client client);
 User findById(int id);
 List<Conseiller>  findAll();
 void deleteUser(int id);
 void update(Conseiller conseiller);

}
