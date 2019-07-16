package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.iservice.CompteService;
import com.wha.spring.model.Compte;

@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService{
	
	@Autowired
	CompteDao compteDAO;
	public void createCompte(Compte compte){
		compteDAO.creationCompte(compte);
	}
}