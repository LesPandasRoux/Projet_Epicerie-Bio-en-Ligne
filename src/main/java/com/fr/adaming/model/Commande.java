package com.fr.adaming.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long refCMD;

	@ManyToOne()
	@JoinColumn(name = "OWNER_ID")
	private User owner;

	private Date dateCMD;
	private String etatCommande;


	@ManyToMany
	@JoinTable(
			name = "CMD_PRODUCT", 
			joinColumns = @JoinColumn(name = "CMD_ID", referencedColumnName = "refCMD"), 
			inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
	private List<Produit> produits;
	
	

	public Long getRefCMD() {
		return refCMD;
	}

	public void setRefCMD(Long refCMD) {
		this.refCMD = refCMD;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getDateCMD() {
		return dateCMD;
	}

	public void setDateCMD(Date dateCMD) {
		this.dateCMD = dateCMD;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public String getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}
	
	

}
