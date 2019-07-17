package com.wha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.iservice.AdminService;
import com.wha.spring.iservice.ClientPotentielService;
import com.wha.spring.iservice.CompteService;
import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.iservice.TransactionService;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.ClientPotentiel;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.Transaction;
import com.wha.spring.model.User;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ClientPotentielService clientPService;

	@Autowired
	DemandeOuvertureDAO demandeOuvertureDAO;

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
	TransactionService transactionService;
	
	@RequestMapping(value = "/createAdmin", method = RequestMethod.GET)
	public void dummy() {
		 Admin admin = new Admin(0, "admin", "admin","admin@admin.com","1 rue admin", "0000000000","admin","admin",null,null);
		 adminService.createAdmin(admin);
	}
	
	@RequestMapping(value = "/createCompte", method = RequestMethod.GET)
	public Compte dummyAccount() {
		 Compte compte = new Compte(0, null, 200, 222, 510223, 2200,18,"epargne",false);
		 compteService.createCompte(compte);
		 return compte;
	}
	
	@RequestMapping(value = "/createTransaction", method = RequestMethod.GET)
	public Compte dummyTransaction() {
		Transaction transaction = new Transaction(0, null, "test",200, 'December 17, 1995 03:24:00';
		 transactionService.creationTransaction(transaction);
		 return transaction;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> resultat = userService.findAllUsers();
		return new ResponseEntity<List<User>>(resultat, HttpStatus.OK);
	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return newUser;
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/demandeOuvertureCompte")
	public DemandeOuverture demandeOuvertureCompte(@RequestBody ClientPotentiel clientp) {
		DemandeOuverture d = demandeOuvertureDAO.createDemandeOuverture();
		System.out.println(d);
		clientp.setDemandeOuverture(d);
		clientPService.addClientP(clientp);
		return d;
	}


	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/modificationDecouvert", method = RequestMethod.GET)
	public void  modificationDecouvert() {
		Compte cp = new Compte();
		conseillerDao.modificationDecouvert(cp, 500);
		
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/createConseiller")
	public Conseiller createConseiller(@RequestBody Conseiller conseiller) {
		adminService.creationConseiller(conseiller);
		return conseiller;
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping(value = "/createClient")
		public Client createClient(@RequestBody DemandeOuverture demandeOuverture) {
			
			return clientDao.creationClient(conseillerService.validationDemandeOuverture(demandeOuverture));
			
		}
	
	

}
