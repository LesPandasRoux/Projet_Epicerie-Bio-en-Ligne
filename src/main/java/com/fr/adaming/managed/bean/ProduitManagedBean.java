package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Produit;
import com.fr.adaming.model.User;
import com.fr.adaming.service.IProduitService;

@Controller(value = "produitMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	IProduitService produitService;

	List<Produit> produitList;

	private Long id;

	private String libelle;

	private int prix;

	private int qteStock;

	private String type;

	public void addProduit() {
		try {
			Produit produit = new Produit();
			produit.setIdProduit(getId());
			produit.setLibelle(getLibelle());
			produit.setPrix(getPrix());
			produit.setQteStock(getQteStock());
			produitService.addProduit(produit);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		this.setId(0l);
		this.setLibelle("produit");
		this.setQteStock(0);
		this.setPrix(0);
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public List<Produit> getProduitList() {
//		produitList = new ArrayList<Produit>();
//		produitList.addAll(getProduitService().getProduits());
		return produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}
	
//	public String getLibelleProduitById(int id) {
//		Produit prod = new Produit();
//		
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
