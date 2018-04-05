package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.model.Administrateur;


@Repository
@Transactional
public class AdminDAO implements IAdminDAO{
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
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/**
	 * Add Admin
	 * 
	 * @param  Administrateur admin
	 */
	@Override
	public void addAdmin(Administrateur admin) {
		getSessionFactory().getCurrentSession().save(admin);
	}

	/**
	 * Delete Admin
	 * 
	 * @param  Administrateur admin
	 */
	@Override
	public void deleteAdmin(Administrateur admin) {
		getSessionFactory().getCurrentSession().delete(admin);
	}

	/**
	 * Update Admin
	 * 
	 * @param  Administrateur admin
	 */
	public void updateAdmin(Administrateur admin) {
		getSessionFactory().getCurrentSession().update(admin);
	}

	/**
	 * Get Admin
	 * 
	 * @param  int Admin Id
	 * @return Administrateur 
	 */
	@Override
	public Administrateur getAdminById(int id) {
		Administrateur admin = (Administrateur) getSessionFactory().getCurrentSession().get(Administrateur.class, id);
		
        return admin;
	}

	/**
	 * Get Admin List
	 * 
	 * @return List - Admin list
	 */
	@Override
	public List<Administrateur> getAdmins() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Administrateur").list();
		return list;
	}


}
