package com.wha.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String pseudo;
	private String userType;
}
