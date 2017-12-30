package com.bankmega.traning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankmega.traning.dao.RoleDao;
import com.bankmega.traning.model.Role;

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
