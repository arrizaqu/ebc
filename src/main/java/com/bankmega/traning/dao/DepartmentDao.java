package com.bankmega.traning.dao;

import java.util.List;

import com.bankmega.traning.model.Department;
import com.bankmega.traning.model.Employee;

public interface DepartmentDao {

	List<Department> getAllDepartments();

	Department getDepartmentById(int id);

	void save(Department department);

	void delete(int id);

}
