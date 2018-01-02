package com.arrsoft.ebc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.RoleDao;
import com.arrsoft.ebc.model.Role;

@Transactional
@Service
public class RoleService {

	@Autowired
	RoleDao roleDao;
	
	public List<Role> getAllUserRoles() {
		// TODO Auto-generated method stub
		return roleDao.getAllUserRoles();
	}

	public void save(Role role) {
		// TODO Auto-generated method stub
		roleDao.save(role);
	}

}
