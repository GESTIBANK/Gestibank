package com.wha.spring.iservice;

import com.wha.spring.model.User;

public interface LoginService {
	User login(String username, String password);

}
