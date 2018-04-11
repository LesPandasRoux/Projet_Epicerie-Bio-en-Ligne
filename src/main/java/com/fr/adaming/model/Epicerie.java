package com.fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class Epicerie extends Produit {

	private int poids;

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public Epicerie(int idProduit, String libelle, float prix, int qteStock, int poids) {
		super(idProduit, libelle, prix, qteStock);
		this.poids = poids;
		this.type = "Epicerie";
	}
	

	public Epicerie(String libelle, float prix, int qteStock, String urlimg, int poids) {
		super(libelle, prix, qteStock, urlimg);
		this.poids = poids;
		this.type = "Epicerie";
	}

	public Epicerie(int idProduit, String libelle, float prix, int qteStock, String urlimg, int poids) {
		super(idProduit, libelle, prix, qteStock, urlimg);
		this.poids = poids;
		this.type = "Epicerie";
	}

	public Epicerie() {
		super();
		this.type = "Epicerie";
	}

	public Epicerie(String libelle, float prix, int qteStock, String urlimg, int qtePanier, int poids) {
		super(libelle, prix, qteStock, urlimg, qtePanier);
		this.poids = poids;
	}
	
	
}
