package com.wha.spring.idao;

import com.wha.spring.model.User;

public interface LoginDao {
	
	User login(String username, String password);

}
