//package com.fr.adaming.oldclass;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fr.adaming.model.User;
//
//
////@Repository
////@Transactional
//public class ImplDAO<T, pk> implements InterfaceDAO<T, pk> {
//	
//	Class<T> entityClass = (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass())
//			.getActualTypeArguments()[0];
//	
//	@Autowired
//	protected SessionFactory sessionFactory;
//	
//	
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//	
//	@Override
//	public void add(T p) {
//		getSessionFactory().getCurrentSession().save(p);
//	}
//
//	@Override
//	public void update(T p) { 
//		getSessionFactory().getCurrentSession().update(p);
//	}
//
//	@Override
//	public void delete(T p) {
//		getSessionFactory().getCurrentSession().delete(p);
//	}
//
//	@Override
//	public T getById(pk id) {
//		T p = (T) getSessionFactory().getCurrentSession().get(entityClass, (Serializable) id);
//		
//        return p;
//	}
//	
//	@Override
//	public List<T> findAll() {
//		List list = getSessionFactory().getCurrentSession().createCriteria(entityClass).list();
//		return list;
//	}
//}