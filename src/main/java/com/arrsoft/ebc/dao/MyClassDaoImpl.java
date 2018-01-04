package com.arrsoft.ebc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.arrsoft.ebc.model.MyClass;

@Repository
public class MyClassDaoImpl implements MyClassDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<MyClass> getPopulateMateri(){
		Session session = sessionFactory.getCurrentSession();
		List<MyClass> mList = null;
		return mList;
	}
	
	public int getCountMateri(){
		Session session = sessionFactory.getCurrentSession();
		List<MyClass> listMateri = session.createCriteria(MyClass.class).list();
		if(listMateri.isEmpty()){
			return 0;
		} 
		return listMateri.size();
	}

	public List<MyClass> getMateriByPage(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MyClass");
		query.setFirstResult(startPage*pageSize);
		query.setMaxResults(pageSize);
		List<MyClass> list = query.list();
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	public void save(MyClass materi) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(materi);
		session.flush();
	}

	public List<MyClass> getMateriByPageByLg(int page, int pageSize, String lg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MyClass mc where mc.programmingLanguage = :lg");
		query.setParameter("lg", lg);
		query.setFirstResult(page*pageSize);
		query.setMaxResults(pageSize);
		List<MyClass> list = query.list();
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

}
