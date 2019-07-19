package com.wha.spring.idao;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.User;

public interface AdminDao {

	void creationAdmin(Admin administrateur);
	void creationConseiller(Conseiller conseiller);
	User findById(int id);
	/*void suppressionConseiller(Conseiller conseiller);*/
}