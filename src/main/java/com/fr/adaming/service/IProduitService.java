package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.model.Produit;

/**
 * 
 * Produit Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface IProduitService {
	
	public void addProduit(Produit produit);
	
	public void updateProduit(Produit produit);

	public void deleteProduit(Produit produit);
	
	public Produit getProduitById(int id);
	
	public List<Produit> getProduits();
}
