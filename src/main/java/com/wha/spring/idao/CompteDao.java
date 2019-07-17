package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Compte;

public interface CompteDao {

	Compte createCompte(Compte compte);
	
	void updateCompte(Compte compte);

	public List<Compte> findAllComptes();

	Compte findById(int id);

	void deleteCompte(int id);
}
