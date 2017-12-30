package com.bankmega.traning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankmega.traning.dao.RoleDao;
import com.bankmega.traning.dao.UserDao;
import com.bankmega.traning.model.Employee;
import com.bankmega.traning.model.Role;
import com.bankmega.traning.model.User;

@Service
@Transactional
public class UserAccountService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		/*Employee employee = new Employee();
		employee.setId(id);
		Integer idDept = null;*/
		
		User user = userDao.getUserById(id);
		List<Role> roles = new ArrayList();
		if(user.getRoles() != null){
			for(Role role : user.getRoles()){
				Role dRole = roleDao.getRoleById(role.getId());
				roles.add(dRole);
			}
		}
		user.setRoles(roles);
		
		return userDao.getUserById(id);
	}

	public void updateUserRole(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserRole(user);
	}
	
	public String getPassword(int id){
		String oldPassword = userDao.getPasswordByUser(id);
		return oldPassword;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

}
