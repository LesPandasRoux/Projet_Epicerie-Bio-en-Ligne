//package com.fr.adaming.oldclass;
//
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fr.adaming.dao.InterfaceDAO;
//import com.fr.adaming.dao.UserDAO;
//import com.fr.adaming.model.User;
//
//public class ImplService<T,pk> implements  InterfaceService<T, pk>{
//	Class<T> entityClass = (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass())
//			.getActualTypeArguments()[0];
//	
//	@Autowired	
//    InterfaceDAO<T,pk> IDAO;
//
//	@Transactional(readOnly = false)
//	public void add(T p) {
//		getIDAO().add(p);
//	}
//
//	@Transactional(readOnly = false)
//	public void delete(T p) {
//		getIDAO().delete(p);
//	}
//	
//	@Transactional(readOnly = false)
//	public void update(T p) {
//		getIDAO().update(p);
//	}
//	
//	public T getById(pk id) {
//		return (T) getIDAO().getById(id);
//	}
//
//	public List<T> getAll() {	
//		return getIDAO().findAll();
//	}
//
//	public InterfaceDAO getIDAO() {
//		return IDAO;
//	}
//
//	public void setIDAO(InterfaceDAO iDAO) {
//		IDAO = iDAO;
//	}
//	
//	
//
//}
