package com.wha.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdminDao;
import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.idao.UserDao;
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
	
	@Autowired
	ConseillerDao conseillerDAO;
	@Autowired
	DemandeOuvertureDAO demandeOuvertureDao;
	
	@Override
	public Conseiller creationConseiller(int id) {
		Conseiller conseiller = (Conseiller) conseillerDAO.findById(id);
		return conseiller;
	}
	@Override
	public void supprimerConseiller(Conseiller conseiller) {
		
		conseillerDAO.deleteUser(conseiller.getId());
		
	}
	@Override
	public void reaffectationClient(Client client, Conseiller conseiller) {
		
		List<Client> listeClients = new ArrayList<Client>();
		listeClients = conseiller.getListeClients();
		listeClients.add(client);
		conseiller.setListeClients(listeClients);
		conseillerDAO.saveUser(conseiller);
		
	}
	@Override
	public void affectationDemandeOuverture(Conseiller conseiller) {
		
		List<DemandeOuverture> nouvelleListeDemandesOuverture = demandeOuvertureDao.getDemandeOuverture();
		List<DemandeOuverture> listeDemandesOuverture = conseiller.getDemandeOuvertureAValider();
		listeDemandesOuverture.addAll(nouvelleListeDemandesOuverture);
		conseiller.setDemandeOuvertureAValider(listeDemandesOuverture);
		conseillerDAO.saveUser(conseiller);
		
	}
    

}
