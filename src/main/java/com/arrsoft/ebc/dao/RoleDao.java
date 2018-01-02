package com.arrsoft.ebc.dao;

import java.util.List;

import com.arrsoft.ebc.model.Role;
import com.arrsoft.ebc.model.User;

public interface RoleDao {

	List<Role> getAllUserRoles();

	void save(Role role);

	List<Role> getRoleByUser(User user);

	Role getRoleById(int id);

}
