package com.wha.spring.controller;

import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.iservice.AdminService;
import com.wha.spring.iservice.ClientIService;
import com.wha.spring.iservice.ClientPotentielService;
import com.wha.spring.iservice.CompteService;
import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.iservice.DemandClientService;
import com.wha.spring.iservice.DemandeOuvertureService;
import com.wha.spring.iservice.TransactionService;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.ClientPotentiel;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.Credit;
import com.wha.spring.model.Debit;
import com.wha.spring.model.DemandeClient;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.Transaction;
import com.wha.spring.model.User;

@RestController
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ClientPotentielService clientPService;

	@Autowired
	DemandeOuvertureDAO demandeOuvertureDAO;
	@Autowired
	DemandeOuvertureService demandeOuvertureService;

	@Autowired
	ConseillerDao conseillerDao;

	@Autowired
	ConseillerService conseillerService;

	@Autowired
	ClientDao clientDao;

	@Autowired
	AdminService adminService;

	@Autowired
	CompteService compteService;

	@Autowired
	DemandClientService demandClientService;

	@Autowired
	TransactionService transactionService;

	@Autowired
	ClientIService clientService;

//***************************Admin***********************************************
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void dummy() {
		Admin admin = new Admin(0, "admin", "admin", "admin@admin.com", "1 rue admin", "0000000000", "admin", "admin",
				null, null);
		adminService.createAdmin(admin);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/admin/demandeOuverture", method = RequestMethod.GET)
	public ResponseEntity<List<DemandeOuverture>> getDemandeOuverture() {

		return new ResponseEntity<List<DemandeOuverture>>(demandeOuvertureDAO.getDemandeOuvertureNonTraitees(),
				HttpStatus.OK);

	}

//**************** Compte *******************************************************
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("client/compte")
	public Compte createCompte(@RequestBody Compte compte) {
		return compteService.createCompte(compte);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "client/{id}/compte", method = RequestMethod.GET)
	public List<Compte> createCompte(@PathVariable("id")int id) {
				
		return compteService.findCompteByClient(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("client/compte/demandeOuverture")
	public DemandeOuverture demandeOuvertureCompte(@RequestBody ClientPotentiel clientp) {
		DemandeOuverture d = demandeOuvertureDAO.createDemandeOuverture();
		System.out.println(d);
		clientp.setDemandeOuverture(d);
		clientPService.addClientP(clientp);
		return d;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("conseiller/compte/{id}/modificationDecouvert")
	public void modificationDecouvert(@RequestBody int montant, @PathVariable("id") int id) {
		conseillerDao.modificationDecouvert(compteService.findById(id), montant);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "conseiller/compte/{compteId}/geler", method = RequestMethod.GET)
	public Compte gelerCompte(@PathVariable int compteId) {
		Compte compte = compteService.findById(compteId);
		System.out.println(compte);

		compte.setGele(!compte.getGele());
		compteService.updateCompte(compte);
		// Boolean geleornot = compte.getGele();
		// System.out.println(geleornot);

		return compte;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("client/compte/{id}/transaction/debit")
	public Debit newDebitTransaction(@RequestBody Debit debit, @PathVariable("id") int id) {
		debit.setCompte(compteService.findById(id));
		compteService.createTransaction(debit);
		return debit;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("client/compte/{id}/transaction/credit")
	public Credit newCreditTransaction(@RequestBody Credit credit, @PathVariable("id") int id) {
		credit.setCompte(compteService.findById(id));
		compteService.createTransaction(credit);
		return credit;
	}

//******************************Conseiller*********************************************	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "admin/conseiller")
	public Conseiller createConseiller(@RequestBody Conseiller conseiller) {
		adminService.creationConseiller(conseiller);
		return conseiller;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "admin/conseiller/{id}/affectationDemande")
	public void affectationConseillerDemande(@RequestBody List<DemandeOuverture> demandeOuvertureList,
			@PathVariable("id") int id) {
		adminService.affectationDemandeOuverture(demandeOuvertureList, id);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "conseiller/demandeOuverture/{id}/validation")
	public void validationDemandeOuverture(@PathVariable("id") int id) {

		conseillerService
				.creerCompteClient(conseillerService.validationDemandeOuverture(demandeOuvertureDAO.findById(id)));

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("admin/conseiller/{id}")
	public String suppressionConseiller(@PathVariable("id") int id) {
		try {
			adminService.supprimerConseiller((Conseiller) conseillerDao.findById(id));
			return "Suppression ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "Not possible to delete Conseiller";

		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping( "admin/conseiller/{id}/affectationClient")
	public String affectationConseillerClient(@RequestBody List<Client> clientList, @PathVariable("id") int id) {
		adminService.affectationClient(clientList, id);
		return "ok";

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "conseiller/validationDemandeOuverture")
	public Client validationDemandeOuverture(@RequestBody DemandeOuverture demandeOuverture) {
		return clientDao.creationClient(conseillerService.validationDemandeOuverture(demandeOuverture));

	}

//********************************Client******************************************
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "afficherClient/{id}", method = RequestMethod.GET)
	public Client afficherClient(@PathVariable("id") int id) {

		return conseillerService.afficherDetail(id);
	}

	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("client/compte/{id}/demande")
	public DemandeClient createDemande(@RequestBody DemandeClient demandeClient, @PathVariable("id")int id) {
		
		demandeClient.setNumeroCompte(id);
	
		demandClientService.createDemande(demandeClient);
		return demandeClient;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "conseiller/client", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAllClient() {

		List<Client> resultat = clientService.findAllClients();
		return new ResponseEntity<List<Client>>(resultat, HttpStatus.OK);
	}
	
	
	
//*************************Service pour la creation des entity**********************
// { "nom":"pascal", "prenome":"frerebeau", "email":"pascal@lyon.com","adresse":"adress1", "mdp":"mdp1", "pseudo":"pseudo1", "telephone":"0151515151511","identifiant":???}
	//@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("entity/client")
		public Client createEntityClient(@RequestBody Client client) {
			
			return clientService.creationClient(client);
		}
		
		
//{ "nom":"fabio", "prenome":"leotta", "email":"email","adresse":"adress", "mdp":"mdp", "pseudo":"pseudo", "telephone":"01515151"}		
		//@CrossOrigin(origins = "http://localhost:4200")
				@PostMapping("entity/conseiller")
				public Conseiller createEntityConseiller(@RequestBody Conseiller conseiller) {
					
					 adminService.creationConseiller(conseiller);
					 return conseiller;
				}



}
