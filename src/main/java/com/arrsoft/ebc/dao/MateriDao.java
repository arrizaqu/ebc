package com.arrsoft.ebc.dao;

import java.util.List;

import com.arrsoft.ebc.model.Materi;

public interface MateriDao {

	List<Materi> getMateriByPage(int page, int pageSize);
	int getCountMateri();

}
