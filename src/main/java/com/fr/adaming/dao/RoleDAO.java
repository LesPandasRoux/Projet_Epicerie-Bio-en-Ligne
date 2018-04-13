package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.model.Role;

@Repository
@Transactional
public class RoleDAO implements IRoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addRole(Role role) {
		getSessionFactory().getCurrentSession().save(role);

	}

	@Override
	public void updateRole(Role role) {
		getSessionFactory().getCurrentSession().update(role);

	}

	@Override
	public void deleteRole(Role role) {
		getSessionFactory().getCurrentSession().delete(role);

	}

	@Override
	public Role getRoleById(int id) {
		Role role = (Role) getSessionFactory().getCurrentSession().get(Role.class, id);
		return role;
	}

	@Override
	public List<Role> getRoles() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Role").list();
		return list;
	}

}