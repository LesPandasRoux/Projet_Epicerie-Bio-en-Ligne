package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.model.Role;
import com.fr.adaming.model.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	/**
	 * Get User
	 * 
	 * @param int
	 *            User Id
	 * @return User
	 */
	public User getUserById(int id) {
		User User = (User) getSessionFactory().getCurrentSession().get(User.class, id);

		return User;
	}

	public User getUserByEmail(String email) {
		// Query query = sessionFactory.getCurrentSession().createQuery("from User where
		// email=:email");
		// query.setParameter("email", email);
		// User user = (User) query.uniqueResult();
		// return user;
		Object crit= getSessionFactory().getCurrentSession().createCriteria(User.class).add(Restrictions.like("email",email)).uniqueResult();
		if (crit!= null) {
		return (User) crit;
		    } else {
		        return null;
		    }
	}

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers() {
		 List list = getSessionFactory().getCurrentSession().createQuery("from User").list();
		 return list;
	}

	@Override 
	public List<Role> getUserRoles(String email) {
		// List list = getSessionFactory().getCurrentSession().createQuery("from Role
		// where email = ?").list();
		// return list;
		Object crit = getSessionFactory().getCurrentSession().createCriteria(User.class)
				.add(Restrictions.like("email", email)).uniqueResult();
		User crit1 = (User) crit;
		if (crit1 != null) {
			return crit1.getRoles();
		} else {
			return null;
		}
	}

}
