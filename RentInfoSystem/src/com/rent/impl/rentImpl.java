package com.rent.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.rent.dao.rentDao;
import com.rent.model.Page;
import com.rent.model.Rent_In;
import com.rent.model.Rent_Out;
import com.rent.model.User;
import com.rent.util.SessionAnnotationUtil;

public class rentImpl implements rentDao {

	@Override
	public void save(Object obj) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
	    session.save(obj);//hibernate封装好了添加的sql语句，目的为了增加代码的重用性
	    session.flush();
	    session.getTransaction().commit();
		SessionAnnotationUtil.closeSession();	
	}


	@Override
	public <T> T get(Class<T> clazz, String id) {
		Session session=SessionAnnotationUtil.getSession();
		try {
			session.beginTransaction();
			 T t=(T) session.get(clazz, Integer.parseInt(id));
		   	 session.flush();
		   	 session.getTransaction().commit();
		   	 SessionAnnotationUtil.closeSession();
		   	 return t;
		} catch (Exception e) {
			return null;
		}	
	}

	@Override
	public void update(Object obj) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		session.update(obj);
		 session.getTransaction().commit(); 
		 SessionAnnotationUtil.closeSession();	
	}

	@Override
	public <T> void delete(Class<T> clazz, String id) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		  delete(session.get(clazz, Integer.parseInt(id)));
		  session.getTransaction().commit();
		 SessionAnnotationUtil.closeSession();	
	}

	@Override
	public void delete(Object obj) {
		SessionAnnotationUtil.getSession().delete(obj);
		
	}


	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		List<T> list=session.createCriteria(clazz).list();
		 session.getTransaction().commit();
		 SessionAnnotationUtil.closeSession();
		return list;
	}

	@Override
	public int findAllCount(String sql) {
		int count=0;
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
	     Query q=session.createQuery(sql);
	     count= ((Long) q.setCacheable(true).uniqueResult()).intValue();
		session.getTransaction().commit();
		SessionAnnotationUtil.closeSession();
		return count;
	}

	@Override
	public List findAll(Class calzz, Page page, String sql) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		Query query=session.createQuery(sql);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		List list=query.list();
		if(!list.isEmpty()){
		session.getTransaction().commit();
		SessionAnnotationUtil.closeSession();
		return list;
		}
		SessionAnnotationUtil.closeSession();
		return null;
	}

	@Override
	public List<User> login(String sql) {
		Session session=SessionAnnotationUtil.getSession();
		 session.beginTransaction();
		 List list=session.createQuery(sql).list();
		 if(list.isEmpty()){
			 session.getTransaction().commit();
		     SessionAnnotationUtil.closeSession();
			 return null;
			}
		 session.getTransaction().commit();
		 SessionAnnotationUtil.closeSession();
		return list;
	}

	@Override
	public List<Rent_In> findRentIn(Page page,String sql) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		Query query=session.createQuery(sql);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		List<Rent_In> list=query.list();
		if(!list.isEmpty()){
			for(Rent_In in:list){
				in.getUser().getUserId();
			}
		session.getTransaction().commit();
		SessionAnnotationUtil.closeSession();
		return list;
		}
		SessionAnnotationUtil.closeSession();
		return null;
	}

	@Override
	public void saveRentIn(Rent_In in,int id) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		User user=(User) session.get(User.class, id);
		in.setUser(user);
	    session.save(in);
	    session.flush();
	    session.getTransaction().commit();
		SessionAnnotationUtil.closeSession();
		
	}

	@Override
	public void saveRentOut(Rent_Out out, int id) {
		Session session=SessionAnnotationUtil.getSession();
		session.beginTransaction();
		User user=(User) session.get(User.class, id);
		out.setUser(user);
	    session.save(out);
	    session.flush();
	    session.getTransaction().commit();
		SessionAnnotationUtil.closeSession();
		
	}

	@Override
	public void deleteById(String sql) {
		Session session=SessionAnnotationUtil.getSession();
		try {
			session.beginTransaction();
			Query query=session.createQuery(sql);
			query.executeUpdate();
		   	 session.flush();
		   	 session.getTransaction().commit();
		   	 SessionAnnotationUtil.closeSession();
		} catch (Exception e) {
		}	
		
	}

	@Override
	public boolean checkUserExist(String sql) {
		Session session=SessionAnnotationUtil.getSession();
		 session.beginTransaction();
		 List list=session.createQuery(sql).list();
		 session.getTransaction().commit();
		 if(list.isEmpty()){
		     SessionAnnotationUtil.closeSession();
			 return false;
			}
		
		 SessionAnnotationUtil.closeSession();
		return true;
	}


}
