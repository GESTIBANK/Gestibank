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
import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.iservice.DemandeOuvertureService;
import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;


@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	DemandeOuvertureDAO demandeOuvertureDao;
	
	@Autowired
	AdminDao adminDAO;
	public void createAdmin(Admin admin){
		adminDAO.creationAdmin(admin);
	}
	
	@Autowired
	ConseillerDao conseillerDAO;
	
	@Override
	public Conseiller creationConseiller(Conseiller conseiller) {
		
		adminDAO.creationConseiller(conseiller);
		return conseiller;
	}
	@Override
	public void supprimerConseiller(Conseiller conseiller) {
		
		conseillerDAO.deleteUser(conseiller.getId());
		
	}
	@Override
	public void affectationClient(List<Client> clientList, int id) {
		
		/*List<Client> listeClients = new ArrayList<Client>();
		listeClients = conseiller.getListeClients();
		listeClients.add(client);
		conseiller.setListeClients(listeClients);*/
		//conseillerDAO.saveUser(conseiller);
		List<Client> listeClients = new ArrayList<Client>();
		listeClients = ((Conseiller)conseillerDAO.findById(id)).getListeClients();
		for(Client client: clientList){
			listeClients.add(client);
			client.setConseiller((Conseiller)conseillerDAO.findById(id));
			System.out.println("********************************************");
			System.out.println(((Conseiller)conseillerDAO.findById(id)).getNom());
			System.out.println(client.getConseiller().getId());
		}
		((Conseiller)conseillerDAO.findById(id)).setListeClients(listeClients);
		
		
	}
	@Override
	public void affectationDemandeOuverture(List<DemandeOuverture> demandeOuvertureList, int id ) {
		
		//List<DemandeOuverture> nouvelleListeDemandesOuverture = demandeOuvertureDao.getDemandeOuverture();
		//List<DemandeOuverture> listeDemandesOuverture = demandeOuvertureDao.getDemandeOuverture();
		//listeDemandesOuverture.addAll(nouvelleListeDemandesOuverture);
		for(DemandeOuverture demande: demandeOuvertureList){
			demande.setATraiter(true);
			demande.setConseiller((Conseiller) conseillerDAO.findById(id));
		}
			
		
		
		Conseiller conseiller =(Conseiller) conseillerDAO.findById(id);
		for(DemandeOuverture demande: demandeOuvertureList){
			demandeOuvertureDao.updateDemandeOuverture(demande);
		}
		
		
		conseiller.getDemandeOuvertureList().addAll(demandeOuvertureList);
		conseillerDAO.update(conseiller);
		
		
		
	}
    

}
