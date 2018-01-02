package com.arrsoft.ebc.dao;

import java.util.List;

import com.arrsoft.ebc.model.User;

public interface UserDao {

	List<User> getAllUser();

	User getUserById(int id);

	void updateUserRole(User user);

	String getPasswordByUser(int i);

	void save(User user);


}
