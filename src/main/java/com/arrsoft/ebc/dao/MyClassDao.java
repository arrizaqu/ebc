package com.arrsoft.ebc.dao;

import java.util.List;

import com.arrsoft.ebc.model.MyClass;

public interface MyClassDao {

	List<MyClass> getMateriByPage(int page, int pageSize);
	int getCountMateri();
	void save(MyClass myClass);
	List<MyClass> getMateriByPageByLg(int page, int pageSize, String lg);
	void delete(MyClass myClass);
	List<MyClass> getAll();
	MyClass getMyClassById(String id);
}
