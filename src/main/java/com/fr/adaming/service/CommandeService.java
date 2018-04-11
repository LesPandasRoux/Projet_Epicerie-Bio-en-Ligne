package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.dao.ICommandeDAO;
import com.fr.adaming.model.Commande;

@Transactional(readOnly = true)
@Service
public class CommandeService implements ICommandeService {

	@Autowired
	ICommandeDAO commandeDAO;
	
	@Transactional(readOnly = false)
	public void addCommande(Commande commande) {
		getCommandeDAO().addCommande(commande);
	}

	@Transactional(readOnly = false)
	public void deleteCommande(Commande commande) {
		getCommandeDAO().deleteCommande(commande);
	}
	
	@Transactional(readOnly = false)
	public void updateCommande(Commande commande) {
		getCommandeDAO().updateCommande(commande);
	}
	
	public Commande getCommandeById(int id) {
		return getCommandeDAO().getCommandeById(id);
	}

	public List<Commande> getCommandes() {	
		return getCommandeDAO().getCommandes();
	}

	public ICommandeDAO getCommandeDAO() {
		return commandeDAO;
	}

	public void setCommandeDAO(ICommandeDAO commandeDAO) {
		this.commandeDAO = commandeDAO;
	}

}
