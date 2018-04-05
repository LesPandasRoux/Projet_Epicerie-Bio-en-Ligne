package com.fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Panier {

	@Id
	@GeneratedValue
	private int idPanier;

	@OneToMany
	@JoinTable(name = "PANIER_PRODUCT", joinColumns = {
			@JoinColumn(name = "PANIER_ID", referencedColumnName = "idPanier") }, inverseJoinColumns = {
					@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID") })
	private List<Produit> produits;

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

}
