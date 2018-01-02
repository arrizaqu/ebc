package com.arrsoft.ebc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.MateriDao;
import com.arrsoft.ebc.model.Materi;

@Service
@Transactional
public class MateriService {

	@Autowired
	private MateriDao materiDao;

	public List<Materi> getMateriByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		List<Materi> listMateri = materiDao.getMateriByPage(page, pageSize);
		return null;
	}
	
	public int getCountMateri(){
		return materiDao.getCountMateri();
	
	}

}
