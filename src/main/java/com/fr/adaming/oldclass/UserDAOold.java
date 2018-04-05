//package com.fr.adaming.oldclass;
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fr.adaming.model.User;
//
///**
// * 
// * User DAO
// * 
// * @author onlinetechvision.com
// * @since 25 Mar 2012
// * @version 1.0.0
// *
// */
//
//@Repository
//@Transactional
//public class UserDAOold implements IUserDAOold {
//	
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	/**
//	 * Get Hibernate Session Factory
//	 * 
//	 * @return SessionFactory - Hibernate Session Factory
//	 */
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	/**
//	 * Set Hibernate Session Factory
//	 * 
//	 * @param SessionFactory - Hibernate Session Factory
//	 */
//	public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//	/**
//	 * Add User
//	 * 
//	 * @param  User user
//	 */
//	@Override
//	public void addUser(User user) {
//		getSessionFactory().getCurrentSession().save(user);
//	}
//
//	/**
//	 * Delete User
//	 * 
//	 * @param  User user
//	 */
//	@Override
//	public void deleteUser(User user) {
//		getSessionFactory().getCurrentSession().delete(user);
//	}
//
//	/**
//	 * Update User
//	 * 
//	 * @param  User user
//	 */
//	public void updateUser(User user) {
//		getSessionFactory().getCurrentSession().update(user);
//	}
//
//	/**
//	 * Get User
//	 * 
//	 * @param  int User Id
//	 * @return User 
//	 */
//	public User getUserById(int id) {
//	
//		
//		User User = (User) getSessionFactory().getCurrentSession().get(User.class, id);
//		
//		        return User;
//
//	}
//
//	/**
//	 * Get User List
//	 * 
//	 * @return List - User list
//	 */
//	@Override
//	public List<User> getUsers() {
//		List list = getSessionFactory().getCurrentSession().createQuery("from User").list();
//		return list;
//	}
//
//}
