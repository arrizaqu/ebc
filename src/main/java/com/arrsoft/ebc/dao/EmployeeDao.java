package com.arrsoft.ebc.dao;


import java.util.List;

import com.arrsoft.ebc.model.Employee;

public interface EmployeeDao {

	public void save(Employee employee);

	public List<Employee> getAllEmployee();

	public void delete(Employee employee);

	public Employee getEmployeeById(int id);

}
