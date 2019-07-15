package com.wha.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

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

@OneToMany(mappedBy = "conseiller")
private List<Client> listeClients;
@OneToMany(mappedBy = "conseiller")
private List<DemandeClient> listeDemandeClient;
@OneToMany(mappedBy = "conseiller")
private List<DemandeOuverture> listeDemandeOuvertureAValider;


}
