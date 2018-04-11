package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Produit;
import com.fr.adaming.service.IProduitService;

@Controller
@SessionScoped
public class DataScrollerView implements Serializable {
	
	private List<Produit> produits;
	@Autowired
	private IProduitService produitService;

	@PostConstruct
	public void init() {
		produits = produitService.getProduits();
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

}