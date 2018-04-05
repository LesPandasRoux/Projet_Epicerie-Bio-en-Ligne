package com.fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class ProduitFrais extends Produit {

	private int dureeValidite;

	public int getDureeValidite() {
		return dureeValidite;
	}

	public void setDureeValidite(int dureeValidite) {
		this.dureeValidite = dureeValidite;
	}

	public ProduitFrais(Long idProduit, String libelle, float prix, int qteStock, int dureeValidite) {
		super(idProduit, libelle, prix, qteStock);
		this.dureeValidite = dureeValidite;
	}

	public ProduitFrais(Long idProduit, String libelle, float prix, int qteStock, String urlimg, int dureeValidite) {
		super(idProduit, libelle, prix, qteStock, urlimg);
		this.dureeValidite = dureeValidite;
	}

	public ProduitFrais() {
		super();
	}

	public ProduitFrais( String libelle, float prix, int qteStock,String urlimg, int dureeValidite) {
		super(libelle, prix, qteStock, urlimg);
		this.dureeValidite = dureeValidite;
	}
	
	
	
	
}
