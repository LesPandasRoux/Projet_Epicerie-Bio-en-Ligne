package com.fr.adaming.dao;

import java.util.List;

import com.fr.adaming.model.Commande;


public interface ICommandeDAO {

	public void addCommande(Commande commande);

	public void updateCommande(Commande commande);
	
	public void deleteCommande(Commande commande);
	
	public Commande getCommandeById(int id);
	
	public List<Commande> getCommandes();
}
