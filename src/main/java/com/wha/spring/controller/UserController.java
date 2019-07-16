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

import com.wha.spring.idao.DemandeOuvertureDAO;
import com.wha.spring.iservice.AdminService;
import com.wha.spring.iservice.ClientPotentielService;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Admin;
import com.wha.spring.model.ClientPotentiel;
import com.wha.spring.model.DemandeOuverture;
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
	AdminService adminService;
	
	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public void dummy() {
		 Admin admin = new Admin(0, "admin", "admin","admin@admin.com","1 rue admin", "0000000000","admin","admin",null,null);
		 adminService.createAdmin(admin);
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

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createCompte")
	public ClientPotentiel clientPotentiel(@RequestBody ClientPotentiel clientp) {
		DemandeOuverture d = demandeOuvertureDAO.createDemandeOuverture();
		System.out.println(d);
		clientp.setDemandeOuverture(d);
		clientPService.addClientP(clientp);
		return clientp;
	}
}
