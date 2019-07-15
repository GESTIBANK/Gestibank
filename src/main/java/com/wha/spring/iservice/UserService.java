package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.User;

public interface UserService {
	User saveUser(User user);

	User findById(int id);

	void updateUser(User user);

	public List<User> findAllUsers();

	public void deleteUser(int id);
}
