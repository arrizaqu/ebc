package com.bankmega.traning.dao;

import java.util.List;

import com.bankmega.traning.model.User;

public interface UserDao {

	List<User> getAllUser();

	User getUserById(int id);

	void updateUserRole(User user);

	String getPasswordByUser(int i);

	void save(User user);


}
