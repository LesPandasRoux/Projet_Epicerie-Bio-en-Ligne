package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.dao.IPanierDAO;
import com.fr.adaming.model.Panier;

@Transactional(readOnly = true)
@Service
public class PanierService implements IPanierService {

	@Autowired
	IPanierDAO panierDAO;
	
	@Transactional(readOnly = false)
	public void addPanier(Panier panier) {
		getPanierDAO().addPanier(panier);
	}

	@Transactional(readOnly = false)
	public void deletePanier(Panier panier) {
		getPanierDAO().deletePanier(panier);
	}
	
	@Transactional(readOnly = false)
	public void updatePanier(Panier panier) {
		getPanierDAO().updatePanier(panier);
	}
	
	public Panier getPanierById(int id) {
		return getPanierDAO().getPanierById(id);
	}

	public List<Panier> getPaniers() {	
		return getPanierDAO().getPaniers();
	}

	public IPanierDAO getPanierDAO() {
		return panierDAO;
	}

	public void setCommandeDAO(IPanierDAO panierDAO) {
		this.panierDAO = panierDAO;
	}

}
