package com.wha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdminDao;
import com.wha.spring.idao.UserDao;
import com.wha.spring.iservice.AdminService;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.User;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDAO;
	
	@Override
	public Conseiller creationConseiller() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void supprimerConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reaffectationClient(Client client, Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void affectationDemandeOuverture(DemandeOuverture demande,
			Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void creationAdmin(User user) {
		adminDAO.creationAdmin(user);
	}
	
	
    

}
