package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.model.Commande;
import com.fr.adaming.model.User;
@Repository
@Transactional
public class CommandeDAO implements ICommandeDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addCommande(Commande commande) {
		getSessionFactory().getCurrentSession().save(commande);
		
	}

	@Override
	public void updateCommande(Commande commande) {
		getSessionFactory().getCurrentSession().update(commande);
		
	}

	@Override
	public void deleteCommande(Commande commande) {
		getSessionFactory().getCurrentSession().delete(commande);
		
	}

	@Override
	public Commande getCommandeById(int id) {
		Commande commande = (Commande) getSessionFactory().getCurrentSession().get(Commande.class, id);
        return commande;
	}

	@Override
	public List<Commande> getCommandes() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Commande").list();
		return list;
	}

}
