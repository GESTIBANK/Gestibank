package com.wha.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.context.annotation.Description;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="UserType", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM", nullable = false)
	private String nom;
	
	@Column(name = "PRENOME", nullable = false)
	private String prenome;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "ADRESSE", nullable = false)
	private String adresse;
	
	@Column(name = "TELEPHONE", nullable = false)
	private String telephone;
	
	@Column(name = "PSEUDO", nullable = false)
	private String pseudo;
	@Column(name = "MDP", nullable = false)
	private String mdp;
}
