package com.wha.spring.service;

import java.util.List;

import com.wha.spring.model.Compte;

public interface CompteService {
	public void createCompte(Compte compte);

	public List<Compte> getAllComptes();

	public void deleteCompte(Integer compteId);

	public Compte getCompte(int compteid);

	public Compte updateCompte(Compte compte);
}