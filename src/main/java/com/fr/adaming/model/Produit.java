package com.fr.adaming.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="typeproduit",
		discriminatorType=DiscriminatorType.STRING)
public class Produit {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
    private Long idProduit;

	private String libelle;
	
	private float prix;
	
	private int qteStock;
	
	private String urlimg;
	
	
	@ManyToMany(mappedBy="produits")
	private List<Commande> commandes;
	
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
	

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public Produit(Long idProduit, String libelle, float prix, int qteStock) {
		super();
		this.idProduit = idProduit;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
	}

	public Produit(Long idProduit, String libelle, float prix, int qteStock, String urlimg) {
		super();
		this.idProduit = idProduit;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.urlimg = urlimg;
	}

	public Produit() {
		super();
	}


	public Produit(String libelle, float prix, int qteStock, String urlimg) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.urlimg = urlimg;
	}
	
	

	
	
}
