package com.arrsoft.ebc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.DepartmentDao;
import com.arrsoft.ebc.model.Department;


@Service
@Transactional
public class DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.getAllDepartments();
	}
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		departmentDao.delete(id);
	}
	

}
