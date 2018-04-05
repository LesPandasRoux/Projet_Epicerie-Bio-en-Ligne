//package com.fr.adaming.oldclass;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fr.adaming.model.User;
//
///**
// * 
// * User Service
// * 
// * @author onlinetechvision.com
// * @since 25 Mar 2012
// * @version 1.0.0
// *
// */
//@Transactional(readOnly = true)
//@Service
//public class UserServiceold implements IUserServiceold {
//
//	// UserDAO is injected...
//	@Autowired
//	IUserDAOold userDAO;
//	
//	/**
//	 * Add User
//	 * 
//	 * @param  User user
//	 */
//	@Transactional(readOnly = false)
//	@Override
//	public void addUser(User user) {
//		getUserDAO().addUser(user);
//	}
//
//	/**
//	 * Delete User
//	 * 
//	 * @param  User user
//	 */
//	@Transactional(readOnly = false)
//	@Override
//	public void deleteUser(User user) {
//		getUserDAO().deleteUser(user);
//	}
//	
//	/**
//	 * Update User
//	 * 
//	 * @param  User user
//	 */
//	@Transactional(readOnly = false)
//	@Override
//	public void updateUser(User user) {
//		getUserDAO().updateUser(user);
//	}
//	
//	/**
//	 * Get User
//	 * 
//	 * @param  int User Id
//	 */
//	@Override
//	public User getUserById(int id) {
//		return getUserDAO().getUserById(id);
//	}
//
//	/**
//	 * Get User List
//	 * 
//	 */
//	@Override
//	public List<User> getUsers() {	
//		return getUserDAO().getUsers();
//	}
//
//	/**
//	 * Get User DAO
//	 * 
//	 * @return IUserDAO - User DAO
//	 */
//	public IUserDAOold getUserDAO() {
//		return userDAO;
//	}
//
//	/**
//	 * Set User DAO
//	 * 
//	 * @param IUserDAOold - User DAO
//	 */
//	public void setUserDAO(IUserDAOold userDAO) {
//		this.userDAO = userDAO;
//	}
//
//}
