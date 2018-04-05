package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.model.Panier;

@Repository
@Transactional
public class PanierDAO implements IPanierDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addPanier(Panier panier) {
		getSessionFactory().getCurrentSession().save(panier);
		
	}

	@Override
	public void updatePanier(Panier panier) {
		getSessionFactory().getCurrentSession().update(panier);
		
	}

	@Override
	public void deletePanier(Panier panier) {
		getSessionFactory().getCurrentSession().delete(panier);
		
	}

	@Override
	public Panier getPanierById(int id) {
		Panier panier = (Panier) getSessionFactory().getCurrentSession().get(Panier.class, id);
        return panier;
	}

	@Override
	public List<Panier> getPaniers() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Panier").list();
		return list;
	}

}
