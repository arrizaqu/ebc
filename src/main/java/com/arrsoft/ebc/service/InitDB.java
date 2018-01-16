package com.arrsoft.ebc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arrsoft.ebc.model.Employee;
import com.arrsoft.ebc.model.Role;
import com.arrsoft.ebc.model.User;

@Component
public class InitDB {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserAccountService userService;
	
	@PostConstruct
	public void init(){
		/*Role roleAdmin = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
		Role roleStaff = new Role();
		roleStaff.setRoleName("ROLE_STAFF");
		Role roleOpera = new Role();
		roleOpera.setRoleName("root");
		
		roleService.save(roleAdmin);
		roleService.save(roleStaff);
		roleService.save(roleOpera);
		System.out.println("success saving");
		
		//insert user
		User userAdmin = new User();
		userAdmin.setEmail("root@arrsoft.com");
		userAdmin.setUsername("root@arrsoft.com");
		userAdmin.setPassword(encodePassword("12345"));
		userAdmin.setEnabled(1);
		List<Role> rolesAdmin = new ArrayList();
		rolesAdmin.add(roleAdmin);
		rolesAdmin.add(roleOpera);
		rolesAdmin.add(roleStaff);
		userAdmin.setRoles(rolesAdmin);
		userService.save(userAdmin);
		
		//insert user opera
		User opera = new User();
		opera.setEmail("opera@yahoo.com");
		opera.setPassword(encodePassword("opera"));
		opera.setUsername("opera");
		opera.setEnabled(1);
		
		List<Role> rolesOpera = new ArrayList();
		rolesOpera.add(roleOpera);
		opera.setRoles(rolesOpera);
		
		userService.save(opera);*/
	}
	
	public String encodePassword(String pass){
		BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
		String thePassword = passwordEncode.encode(pass);
		
		return thePassword;
	}
	
}
