package com.fr.adaming.dao;

import java.util.List;

import com.fr.adaming.model.Administrateur;
import com.fr.adaming.model.Produit;


public interface IProduitDAO {

	public void addProduit(Produit produit);

	public void updateProduit(Produit produit);
	
	public void deleteProduit(Produit produit);
	
	public Produit getProduitById(int id);
	
	public List<Produit> getProduits();

}
