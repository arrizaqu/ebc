package com.arrsoft.ebc.dao;

import java.util.List;

import com.arrsoft.ebc.model.Pembahasan;

public interface PembahasanDao {
	void save(Pembahasan pembahasan);
	List<Pembahasan> getPembahasanByPage(int page, int pageSize);
	List<Pembahasan> getPembahasanByPageClassId(int page, int pageSize, String classid);
}
