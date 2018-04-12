package com.fr.adaming.model;

import java.util.List;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long refCMD;

	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	private User owner;

	private String dateCMD;
	private String etatCommande;

	@OneToOne
	@JoinColumn(name="fk_panier",referencedColumnName="idPanier")
	private Panier panier;
	
	

	public Commande() {
		super();
	}

	public Commande(User owner, String dateCMD, String etatCommande, Panier panier) {
		super();
		this.owner = owner;
		this.dateCMD = dateCMD;
		this.etatCommande = etatCommande;
		this.panier = panier;
	}

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

	public String getDateCMD() {
		return dateCMD;
	}

	public void setDateCMD(String dateCMD) {
		this.dateCMD = dateCMD;
	}


	public String getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	

}
