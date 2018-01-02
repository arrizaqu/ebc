package com.arrsoft.ebc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.RoleDao;
import com.arrsoft.ebc.dao.UserDao;
import com.arrsoft.ebc.model.Employee;
import com.arrsoft.ebc.model.Role;
import com.arrsoft.ebc.model.User;

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
