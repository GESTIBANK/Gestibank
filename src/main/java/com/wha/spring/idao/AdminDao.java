package com.wha.spring.idao;

import com.wha.spring.model.Admin;
import com.wha.spring.model.Conseiller;

public interface AdminDao {

	void creationAdmin(Admin administrateur);
	void creationConseiller(Conseiller conseiller);
}