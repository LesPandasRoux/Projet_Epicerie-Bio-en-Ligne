package com.fr.adaming.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.dao.IUserDAO;
import com.fr.adaming.model.User;

/**
 * 
 * User Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
@Service
public class UserService implements IUserService {

	// UserDAO is injected...
	@Autowired
	IUserDAO userDAO;

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	
	@Transactional(readOnly = false)
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	/**
	 * Get User
	 * 
	 * @param int
	 *            User Id
	 */
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 * 
	 */
	public List<User> getUsers() {
		return getUserDAO().getUsers();
	}

	/**
	 * Get User DAO
	 * 
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 * 
	 * @param IUserDAOold
	 *            - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@PostConstruct
	private void init() {
		addUser(new User("Didier", "Pelat", "DP001", "didier.pelat@gmailcom"));
		addUser(new User("Laure", "Bourgois", "LB002", "laure.bourgois@gmailcom"));
		addUser(new User("Sylvain", "Henry", "SH003", "sylvain.henry@gmail.com"));
		addUser(new User("Jim", "Alec", "JA004", "jim.alec@gmail.com"));
	}

	public User findbyEmail(String email) {
		return getUserDAO().getUserByEmail(email);
	}
	
}
