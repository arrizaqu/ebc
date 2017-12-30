package com.bankmega.traning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankmega.traning.model.Role;
import com.bankmega.traning.model.User;
import com.bankmega.traning.service.RoleService;
import com.bankmega.traning.service.UserAccountService;

@Controller
@RequestMapping("/account")
public class Account {

	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping
	public String index(Model model){
		List<User> users = userAccountService.getAllUser();
		List<Role> roles = roleService.getAllUserRoles();
		model.addAttribute("users", users);
		model.addAttribute("roles", roles);
		
		return "account/account";
	}
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUserById(@PathVariable int id){
		return userAccountService.getUserById(id);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public User save(@RequestBody User user){
		BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
		String thePassword = passwordEncode.encode(user.getPassword());
		user.setPassword(thePassword);
		
		userAccountService.save(user);
		return user;
	}
	
	@RequestMapping(value="/updaterole", method=RequestMethod.PUT)
	@ResponseBody
	public User updateUserRole(@RequestBody User user){
		if(user.getPassword() == null){
			user.setPassword(userAccountService.getPassword(user.getId()));
		}
		userAccountService.updateUserRole(user);
		return user;
	}
	
	@RequestMapping(value = "/addrole", method=RequestMethod.POST)
	@ResponseBody
	public Role addRoleAccount(@RequestBody Role role){
		roleService.save(role);
		return role;
	}
}
