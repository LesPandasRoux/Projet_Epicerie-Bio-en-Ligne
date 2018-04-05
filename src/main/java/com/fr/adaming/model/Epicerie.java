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

	public Epicerie(Long idProduit, String libelle, int prix, int qteStock, int poids) {
		super(idProduit, libelle, prix, qteStock);
		this.poids = poids;
	}

	public Epicerie() {
		super();
	}
	
	
}
