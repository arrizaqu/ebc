package com.bankmega.traning.dao;

import java.util.List;

import com.bankmega.traning.model.Role;
import com.bankmega.traning.model.User;

public interface RoleDao {

	List<Role> getAllUserRoles();

	void save(Role role);

	List<Role> getRoleByUser(User user);

	Role getRoleById(int id);

}
