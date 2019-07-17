package com.wha.spring.controller;

import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.wha.spring.model.DemandeClient;
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

	@RequestMapping(value = "/createAdmin", method = RequestMethod.GET)
	public void dummy() {
		Admin admin = new Admin(0, "admin", "admin", "admin@admin.com",
				"1 rue admin", "0000000000", "admin", "admin", null, null);
		adminService.createAdmin(admin);
	}

	@RequestMapping(value = "/createCompte", method = RequestMethod.GET)
	public Compte dummyAccount() {
		Compte compte = new Compte(0, null, 100, 122, 10223, 200, 8, "cheque",
				false);
		compteService.createCompte(compte);
		return compte;
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

	// @CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/demandeOuvertureCompte")
	public DemandeOuverture demandeOuvertureCompte(
			@RequestBody ClientPotentiel clientp) {
		DemandeOuverture d = demandeOuvertureDAO.createDemandeOuverture();
		System.out.println(d);
		clientp.setDemandeOuverture(d);
		clientPService.addClientP(clientp);
		return d;
	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/modificationDecouvert", method = RequestMethod.GET)
	public void modificationDecouvert() {
		Compte cp = new Compte();
		conseillerDao.modificationDecouvert(cp, 500);

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/createConseiller")
	public Conseiller createConseiller(@RequestBody Conseiller conseiller) {
		adminService.creationConseiller(conseiller);
		return conseiller;

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/createClient")
	public Client createClient(@RequestBody DemandeOuverture demandeOuverture) {
		
		

		return clientDao.creationClient(conseillerService
				.validationDemandeOuverture(demandeOuverture));

	}

	@PostMapping(value = "/validationDemandeOuverture/{id}")
	public void validationDemandeOuverture(
			@PathVariable("id") int id) {
		System.out.println("*************************" +demandeOuvertureDAO.findById(id));
		conseillerService.validationDemandeOuverture(demandeOuvertureDAO.findById(id));

			}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/affectationConseillerDemande/{id}")
	public void affectationConseillerDemande(
			@RequestBody List<DemandeOuverture> demandeOuvertureList,
			@PathVariable("id") int id) {
		adminService.affectationDemandeOuverture(demandeOuvertureList, id);

			}

	@RequestMapping(value = "/getDemandeOuverture", method = RequestMethod.GET)
	public ResponseEntity<List<DemandeOuverture>> getDemandeOuverture() {

		return new ResponseEntity<List<DemandeOuverture>>(
				demandeOuvertureDAO.getDemandeOuvertureNonTraitees(), HttpStatus.OK);

	}
	
	
	// @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/deleteConseiller", method = RequestMethod.GET)
	public void suppressionConseiller(){
		
	}
	
	// @CrossOrigin(origins = "http://localhost:4200")
		@RequestMapping(value = "/afficherClient/{id}", method = RequestMethod.GET)
		public Client afficherClient(@PathVariable("id")int id){
			
			return conseillerService.afficherDetail(id);
		}
		
		@PostMapping( "/createCompte")
	    public Compte dummyAccount(@RequestBody Compte compte) {
	         compteService.createCompte(compte);
	         return compte;
	    }
        // @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/deleteConseiller/{id}")
    public String suppressionConseiller(@PathVariable("id") int id){
        try{
            adminService.supprimerConseiller((Conseiller)conseillerDao.findById(id));
            return "Suppression ok";
        }
        catch(Exception e){
            e.printStackTrace();
            return "Not possible to delete Conseiller";
            
        }
    }
        // @CrossOrigin(origins = "http://localhost:4200")
        @PostMapping(value = "/affectationConseillerClient/{id}")
        public void affectationConseillerClient(
                @RequestBody List<Client>clientList,
                @PathVariable("id") int id) {
            adminService.affectationClient(clientList, id);

                }

   
    
    @RequestMapping(value = "/gelerCompte/{compteId}", method = RequestMethod.GET)
   public Compte gelerCompte(@PathVariable int compteId) {
       Compte compte = compteService.findById(compteId);
       System.out.println(compte);

       compte.setGele(!compte.getGele());
       compteService.updateCompte(compte);
       Boolean geleornot = compte.getGele();
       System.out.println(geleornot);

       return compte;
   }
    
    @PostMapping( "/createTransaction")
    public Transaction dummyTransaction(@RequestBody Transaction transaction) {
        transactionService.creationTransaction(transaction);
        return transaction;
    }
        
        
    
    @PostMapping(value = "/createDemande")
    public DemandeClient createDemande(@RequestBody DemandeClient demandeClient) {
        System.out.println("******************************"+demandeClient);
        demandClientService.createDemande(demandeClient);
        return demandeClient;

    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get/allClient", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAllClient() {
        System.out.println("******************************");
        List<Client> resultat = clientService.findAllClients();
        return new ResponseEntity<List<Client>>(resultat, HttpStatus.OK);
    }

}
