package com.wha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.LoginDao;
import com.wha.spring.model.User;

@Service("oginService")
@Transactional
public class LoginServiceImpl implements com.wha.spring.iservice.LoginService {

	@Autowired
	LoginDao loginDao;
	@Override
	public User login(String username, String password) {
		return loginDao.login(username, password);
	}

}
