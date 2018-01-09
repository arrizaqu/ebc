package com.arrsoft.ebc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrsoft.ebc.dao.PembahasanDao;
import com.arrsoft.ebc.model.Pembahasan;

@Transactional
@Service
public class PembahasanService {

	@Autowired
	private PembahasanDao pembahasanDao;
	public void save(Pembahasan pembahasan) {
		// TODO Auto-generated method stub
		pembahasanDao.save(pembahasan);
	}
	public List<Pembahasan> getPembahasanByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		List<Pembahasan> listPembahasan= pembahasanDao.getPembahasanByPage(page, pageSize);
		return listPembahasan;
	}
	public List<Pembahasan> getPembahasanByPageClassId(int page, int pageSize, String classid) {
		// TODO Auto-generated method stub
		return pembahasanDao.getPembahasanByPageClassId(page,pageSize, classid);
	}

}
