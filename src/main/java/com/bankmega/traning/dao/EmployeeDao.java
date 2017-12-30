package com.bankmega.traning.dao;


import java.util.List;

import com.bankmega.traning.model.Employee;

public interface EmployeeDao {

	public void save(Employee employee);

	public List<Employee> getAllEmployee();

	public void delete(Employee employee);

	public Employee getEmployeeById(int id);

}
