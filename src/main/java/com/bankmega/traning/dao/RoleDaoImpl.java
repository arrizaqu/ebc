package com.bankmega.traning.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmega.traning.model.Role;
import com.bankmega.traning.model.User;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SessionFactory sessionFactory;
	public List<Role> getAllUserRoles() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Role> roles = session.createCriteria(Role.class).list();
		return roles;
	}
	
	public void save(Role role){
		Session session = sessionFactory.getCurrentSession();
		session.save(role);
		session.flush();
	}

	public List<Role> getRoleByUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role r where r.users = :user";
		List<Role> roles = session.createQuery(hql).setParameter("user", user).list();
		if(roles.isEmpty()){
			return null;
		}
		return roles;
	}

	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Role.class, id);
	}
	
}
