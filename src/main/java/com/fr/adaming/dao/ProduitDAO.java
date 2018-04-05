package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.model.Produit;
import com.fr.adaming.model.Produit;
@Repository
@Transactional
public class ProduitDAO implements IProduitDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addProduit(Produit produit) {
		getSessionFactory().getCurrentSession().save(produit);
		
	}

	@Override
	public void updateProduit(Produit produit) {
		getSessionFactory().getCurrentSession().update(produit);
		
	}

	@Override
	public void deleteProduit(Produit produit) {
		getSessionFactory().getCurrentSession().delete(produit);
		
	}

	@Override
	public Produit getProduitById(int id) {
		Produit produit = (Produit) getSessionFactory().getCurrentSession().get(Produit.class, id);
        return produit;
	}

	@Override
	public List<Produit> getProduits() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Produit").list();
		return list;
	}

}
