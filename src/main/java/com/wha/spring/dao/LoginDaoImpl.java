package com.wha.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.LoginDao;
import com.wha.spring.model.Admin;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.User;


@Repository("loginDao")
@Transactional
public class LoginDaoImpl extends AbstractDao implements LoginDao {

	@Override
	public User login(String username, String password) {

		String userType = (String) em.createNativeQuery(
				"select UserType from user  where pseudo=? and mdp=?").setParameter(1, username).setParameter(2, password)
				.getSingleResult();

		switch (userType) {
		case "Admin":
			Admin admin = (Admin) em
					.createQuery(
							"From Admin u where u.pseudo= :username and u.mdp=:password")
					.setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			return (User) admin;
		case "Conseiller":
			Conseiller conseiller = (Conseiller) em
					.createQuery(
							"From Conseiller u where u.pseudo= :username and u.mdp=:password")
					.setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			return (User) conseiller;
		case "Client":
			Client client = (Client) em
					.createQuery(
							"From Client u where u.pseudo= :username and u.mdp=:password")
					.setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			return (User) client;
		default:
			return null;
		}
	}

}
