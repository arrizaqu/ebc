package com.arrsoft.ebc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arrsoft.ebc.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
		session.flush();
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = 
		session.createCriteria(Employee.class).list();
		if(employees.isEmpty()){
			return null;
		}
		return employees;
	}

	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employee.setName("*");
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);
		session.flush();
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee emp where emp.id = :data";
		
		List<Employee> employees = 
				session.createQuery(hql)
					.setParameter("data", id).list(); 
		
		if(employees.isEmpty()){
			return null;
		}
		
		return employees.get(0);
	}
}
