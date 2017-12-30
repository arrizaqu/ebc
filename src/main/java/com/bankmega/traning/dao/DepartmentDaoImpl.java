package com.bankmega.traning.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmega.traning.model.Department;
import com.bankmega.traning.model.Employee;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Department> departments = session.createCriteria(Department.class).list();
		return departments;
	}

	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Department deptment = session.get(Department.class, id);
		return deptment;
	}

	public void save(Department department) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(department);
		session.flush();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Department dept = new Department();
		dept.setId(id);
		Session session = sessionFactory.getCurrentSession();
		//session.delete(dept);
		session.delete(session.get(Department.class, id));
		session.flush();
	}

}
