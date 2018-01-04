package com.arrsoft.ebc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.MyClassDao;
import com.arrsoft.ebc.model.MyClass;

@Service
@Transactional
public class MyClassService {

	@Autowired
	private MyClassDao materiDao;

	public List<MyClass> getMateriByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		List<MyClass> listMateri = materiDao.getMateriByPage(page, pageSize);
		return listMateri;
	}
	
	public List<MyClass> getMateriByPageAndLg(int page, int pageSize, String lg) {
		// TODO Auto-generated method stub
		List<MyClass> listMateri = materiDao.getMateriByPageByLg(page, pageSize, lg);
		return listMateri;
	}
	
	public int getCountMateri(){
		return materiDao.getCountMateri();
	}

	public void save(MyClass materi) {
		// TODO Auto-generated method stub
		materiDao.save(materi);
	}


}
