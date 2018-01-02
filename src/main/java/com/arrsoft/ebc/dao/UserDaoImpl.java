package com.arrsoft.ebc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arrsoft.ebc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createCriteria(User.class).list(); 
		
		return users;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	public void updateUserRole(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User newUser = (User)session.merge(user);
		session.saveOrUpdate(newUser);
		session.flush();
	}

	public String getPasswordByUser(int i) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User us = session.get(User.class, i);
		return us.getPassword();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
	}
	

}
