package com.fr.adaming.service;

import java.util.ArrayList;
import java.util.HashMap;
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
	@Override
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
	@Override
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
	@Override
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	/**
	 * Get User
	 * 
	 * @param int
	 *            User Id
	 */
	@Override
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 * 
	 */
	@Override
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
	
	private int i=1;
	@PostConstruct
	private void init() {
		addUser(new User(i++, "Didier", "Pelat","DP001","pelat","didier.pelat@gmailcom"));
		addUser(new User(i++, "Laure", "Bourgois","LB002","bougoit","laure.bourgois@gmailcom"));
		addUser(new User(i++, "Sylvain", "Henry","SH003","henry","sylvain.henry@gmail.com"));
		addUser(new User(i++, "Jim", "Alec","JA004","alec","jim.alec@gmail.com"));
	}
	
	public User findbyEmail(String email) {
	
		return getUserDAO().getUserByEmail(email);
	}
	

}
