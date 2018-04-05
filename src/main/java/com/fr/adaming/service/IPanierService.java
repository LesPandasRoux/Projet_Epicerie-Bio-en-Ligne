package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.model.Panier;
import com.fr.adaming.model.Produit;

/**
 * 
 * Panier Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface IPanierService {
	
	public void addPanier(Panier panier);
	
	public void updatePanier(Panier panier);

	public void deletePanier(Panier panier);
	
	public Panier getPanierById(int id);
	
	public List<Panier> getPaniers();
}
