package com.arrsoft.ebc.dao;

import java.util.List;

import com.arrsoft.ebc.model.Department;
import com.arrsoft.ebc.model.Employee;

public interface DepartmentDao {

	List<Department> getAllDepartments();

	Department getDepartmentById(int id);

	void save(Department department);

	void delete(int id);

}
