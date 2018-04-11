package com.fr.adaming.model;

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
    private int idProduit;

	private String libelle;
	
	private float prix;
	
	private int qteStock;
	
	private String urlimg;
	
	protected String type;
	
	private int qtePanier=0;
	
	public int getQtePanier() {
		return qtePanier;
	}

	public void setQtePanier(int qtePanier) {
		this.qtePanier = qtePanier;
	}
	
//	@ManyToMany(mappedBy="produits")
//	protected List<Panier> paniers;

	

	public String getLibelle() {
		return libelle;
	}

//	public List<Panier> getPaniers() {
//		return paniers;
//	}
//
//	public void setPaniers(List<Panier> paniers) {
//		this.paniers = paniers;
//	}

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

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	
	

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public Produit(int idProduit, String libelle, float prix, int qteStock) {
		super();
		this.idProduit = idProduit;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
	}

	public Produit(int idProduit, String libelle, float prix, int qteStock, String urlimg) {
		super();
		this.idProduit = idProduit;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.urlimg = urlimg;
	}
	
	

	public Produit(int idProduit, String libelle, float prix, int qteStock, String urlimg, String type, int qtePanier,
			List<Commande> commandes) {
		super();
		this.idProduit = idProduit;
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.urlimg = urlimg;
		this.type = type;
		this.qtePanier = qtePanier;
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

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", libelle=" + libelle + ", prix=" + prix + ", qteStock=" + qteStock
				+ ", urlimg=" + urlimg + ", type=" + type + ", qtePanier=" + qtePanier
				+ "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Produit(String libelle, float prix, int qteStock, String urlimg, int qtePanier) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.qteStock = qteStock;
		this.urlimg = urlimg;
		this.qtePanier = qtePanier;
	}
	
	

	
	
}
