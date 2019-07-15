package com.wha.spring.idao;

import java.io.Serializable;
import java.util.List;

import com.wha.spring.model.User;

public interface UserDao {
	User saveUser(User employee);

	void updateUser(User employee);

	public List<User> findAllUsers();

	User findById(int id);

	void deleteUser(int id);
}
