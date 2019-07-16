package com.wha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdminDao;
import com.wha.spring.iservice.AdminService;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;


@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao adminDAO;
	public void createAdmin(Admin admin){
		adminDAO.creationAdmin(admin);
	}
	
	
	/*@Autowired
	AdminDao adminDAO;
	@Autowired
	UserDao conseillerDAO;*/
	
	/*@Override
	public Conseiller creationConseiller() {
		Conseiller conseiller = new Conseiller();
		conseiller.setNom(user.getNom());
		conseiller.setPrenom(user.getPrenom());
		conseiller.setEmail(user.getEmail());
		conseiller.setAdresse(user.getAdresse());
		conseiller.setTelephone(user.getTelephone());
		conseiller.setPseudo(user.getPseudo());
		conseiller.setMdp(user.getMdp());
		return conseiller;
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
	/**@Override
	public void creationAdmin(User user) {
		adminDAO.creationAdmin(user);
	}
	@Override
	public void creationAdmin(Admin administrateur) {
		adminDAO.creationAdmin(administrateur);
		
	}**/
	
	
    

}
