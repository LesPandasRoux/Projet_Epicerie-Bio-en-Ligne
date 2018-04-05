package com.fr.adaming.dao;

import java.util.List;

import com.fr.adaming.model.Panier;


public interface IPanierDAO {

	public void addPanier(Panier panier);

	public void updatePanier(Panier panier);
	
	public void deletePanier(Panier panier);
	
	public Panier getPanierById(int id);
	
	public List<Panier> getPaniers();
}
