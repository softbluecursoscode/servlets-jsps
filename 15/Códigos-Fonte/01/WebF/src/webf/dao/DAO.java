package webf.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import webf.util.HibernateUtil;

public abstract class DAO<T> {
	
	private Session session;
	private Class<T> clazz;
	
	protected DAO(Class<T> clazz) {
		session = HibernateUtil.getSession();
		this.clazz = clazz;
	}
	
	public T load(Serializable id) throws DAOException {
		try {
			return (T) session.load(clazz, id);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	public void save(T obj) throws DAOException {
		try {
			session.save(obj);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	public void delete(T obj) throws DAOException {
		try {
			session.delete(obj);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	public void update(T obj) throws DAOException {
		try {
			session.update(obj);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	protected List<T> list(String hql) throws DAOException {
		try {
			Query<T> q = query(hql);
			return q.getResultList();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	protected <O> List<O> list(String hql, Class<O> clazz) throws DAOException {
		try {
			Query<O> q = query(hql, clazz);
			return q.getResultList();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected T result(String hql, Class<T> clazz) throws DAOException {
		List<?> results = list(hql);
		if (results.size() == 0) {
			return null;
		}
		return (T) results.get(0);
	}
	
	protected Query<T> query(String hql) throws DAOException {
		try {
			return session.createQuery(hql, clazz);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	protected <O> Query<O> query(String hql, Class<O> clazz) throws DAOException {
		try {
			return session.createQuery(hql, clazz);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
}
