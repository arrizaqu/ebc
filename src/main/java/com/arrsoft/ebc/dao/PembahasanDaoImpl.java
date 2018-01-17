package com.arrsoft.ebc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arrsoft.ebc.model.MyClass;
import com.arrsoft.ebc.model.Pembahasan;

@Repository
public class PembahasanDaoImpl implements PembahasanDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Pembahasan pembahasan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		pembahasan.setMyClass(pembahasan.getMyClass());
		session.save(pembahasan);
		session.flush();
	}
	
	public void update(Pembahasan pembahasan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		pembahasan.setMyClass(pembahasan.getMyClass());
		session.update(pembahasan);
		session.flush();
	}

	public List<Pembahasan> getPembahasanByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Pembahasan");
		query.setFirstResult(page*pageSize);
		query.setMaxResults(pageSize);
		List<Pembahasan> list = query.list();
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	public List<Pembahasan> getPembahasanByPageClassId(int page, int pageSize, String classid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Pembahasan p where p.myClass.id = :cid");
		query.setParameter("cid", classid);
		query.setFirstResult(page*pageSize);
		query.setMaxResults(pageSize);
		List<Pembahasan> list = query.list();
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	public List<Pembahasan> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Pembahasan.class).list();
	}

	public void delete(Pembahasan pembahasan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(pembahasan);
		session.flush();
	}

	public Pembahasan getPembahasanById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Pembahasan pembahasan= session.get(Pembahasan.class, id);
		return pembahasan;
	}
	
}
