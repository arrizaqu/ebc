package com.arrsoft.ebc.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.DepartmentDao;
import com.arrsoft.ebc.dao.EmployeeDao;
import com.arrsoft.ebc.model.Department;
import com.arrsoft.ebc.model.Employee;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;
	
	public void save(Employee employee){
		//Department dept = departmentDao.getDepartmentById(employee.getDepartment().getId());
		//employee.setDepartment(dept);
		employeeDao.save(employee);
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(id);
		employeeDao.delete(employee);
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.getEmployeeById(id);
		Integer idDept = null;
		try{
			idDept = employee.getDepartment().getId();
		}catch(Exception e){}
		
		Department dept = departmentDao.getDepartmentById(
				idDept = (idDept == null) ? 0 : idDept);
		employee.setDepartment(dept);
		
		return employee;
	}

	
}
