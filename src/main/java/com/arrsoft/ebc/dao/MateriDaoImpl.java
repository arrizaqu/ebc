package com.arrsoft.ebc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.arrsoft.ebc.model.Materi;

@Repository
public class MateriDaoImpl implements MateriDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Materi> getPopulateMateri(){
		Session session = sessionFactory.getCurrentSession();
		List<Materi> mList = null;
		return mList;
	}
	
	public int getCountMateri(){
		Session session = sessionFactory.getCurrentSession();
		List<Materi> listMateri = session.createCriteria(Materi.class).list();
		if(listMateri.isEmpty()){
			return 0;
		} 
		return listMateri.size();
	}

	public List<Materi> getMateriByPage(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Materi");
		query.setFirstResult(startPage*pageSize);
		query.setMaxResults(pageSize);
		List<Materi> list = query.list();
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

}
