package com.lee.dao.impl;

import java.io.Serializable;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lee.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public void save(Object obj) {
		Session session = getSession();

		try {
			session.save(obj);

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
		}
	}

	public void update(Object obj) {
		Session session = getSession();


		try {
			session.update(obj);

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
		}
	}

	public void remove(Object obj) {
		Session session = getSession();


		try {
			session.delete(obj);

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
		}
	}

	public Object get(Class<?> cls, Serializable id) {
		Session session = getSession();

		try {
			return session.get(cls, id);
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
		}
		return null;
	}

	
	public List<Object> list(String hql) {
		Session session = getSession();

		try {
			Query q = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Object> list = q.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
		}
		return null;
	}


	@Override
	public List<?> execQuery(String hql, Integer start, Integer pageSize) {
		Session session = getSession();
		try {
			final Query q = session.createQuery(hql);
			q.setFirstResult(start); // 从第start条开始
			q.setMaxResults(pageSize); // 取出pageSize条
			final List<?> list = q.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
		}
		return null;
	}


	@Override
	public Integer execQuery(String hql) {
		Session session = getSession();
		try {
			final Query q = session.createQuery(hql);
			int count = ((Number)q.uniqueResult()).intValue();
			return count;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
