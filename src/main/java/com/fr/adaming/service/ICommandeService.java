package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.model.Commande;

/**
 * 
 * Commande Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface ICommandeService {
	
	public void addCommande(Commande admin);
	
	public void updateCommande(Commande admin);

	public void deleteCommande(Commande admin);
	
	public Commande getCommandeById(int id);
	
	public List<Commande> getCommandes();
}
