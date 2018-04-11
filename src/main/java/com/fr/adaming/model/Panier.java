package com.fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Panier {

	@Id
	@GeneratedValue
	private int idPanier;

	
	@ManyToMany
	@JoinTable(name = "PANIER_PRODUCT",
				joinColumns = {@JoinColumn(name = "PANIER_ID", referencedColumnName = "idPanier") }, 
				inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"), @JoinColumn(name="QTE_PROD", referencedColumnName = "qtePanier") })
	private List<Produit> produits;
	
	@OneToOne(mappedBy="panier")
	private Commande commande;
	

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public Panier() {
		super();
	}

	public Panier(List<Produit> produits) {
		super();
		this.produits = produits;
	}

	
}
