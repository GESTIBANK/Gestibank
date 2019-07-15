package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.UserDao;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDAO;

	public User saveUser(User user) {
		userDAO.saveUser(user);
		return user;

	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(id);
	}

	public User findById(int id) {
		return userDAO.findById(id);
	}

}
