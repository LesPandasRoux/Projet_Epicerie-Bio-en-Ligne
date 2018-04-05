package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Produit;
import com.fr.adaming.model.Panier;
import com.fr.adaming.service.IPanierService;
import com.fr.adaming.service.IProduitService;

/**
 * 
 * User Managed Bean
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */

@Controller(value = "panierMB")
@SessionScoped
public class PanierManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	IPanierService panierService;
	
	@Autowired
	IProduitService produitService;

	List<Panier> panierList;

	private int id;
	private int pid;
	private List<Produit> produitsDuPanier;

	public void validerPanierById() {
		try {
			Panier panier = new Panier();
			panier.setIdPanier(getId());
			panier.setProduits(getProduits());
			panierService.addPanier(panier);
			// if user connecte then payement
			// else se connecter/s'inscrire
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void addProductToCartByPID() {
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	    pid =  Integer.parseInt(params.get("username"));
		Produit prod = getProductByProductID(pid);
		produitsDuPanier.add(prod);
	}

	private Produit getProductByProductID(int pid) {
		Produit produit = new Produit();
		List<Produit> prods = produitService.getProduits();
		for (Produit prod : prods) {
			if (prod.getIdProduit() == pid) {
				produit = prod;
				break;
			}
		}
		return produit;
	}

//	private void addToCart(Produit product) {
//		produitsDuPanier.add(product);
//	}

	public void removeProductByPID(int pid) {
		Produit prod = getProductByProductID(pid);
		produitsDuPanier.remove(prod);
	}

	void printCartItems() {
		for (Produit prod : produitsDuPanier)
			System.out.println(prod.getLibelle());
	}

	public List<Produit> getProduits() {
		return produitsDuPanier;
	}

	public void setProduits(List<Produit> produits) {
		this.produitsDuPanier = produits;
	}

	public List<Panier> getPanierList() {
		return panierList;
	}

	public void setPanierList(List<Panier> panierList) {
		this.panierList = panierList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}