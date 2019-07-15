package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Conseiller")
public class Conseiller extends User implements Serializable{

@GeneratedValue(strategy=GenerationType.IDENTITY)
private int matricule;


private List<Client> listeClients;
private List<DemandeClient> listeDemandeClient;
private List<DemandeOuverture> listeDemandeOuvertureAValider;





}
