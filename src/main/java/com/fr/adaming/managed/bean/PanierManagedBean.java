package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
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

	List<Panier> panierList = new ArrayList<>();
	
	private int idPanier;
	private int pid;
	private List<Produit> produitsDuPanier = new ArrayList<>();
	private String type;


	// public void validerPanierById() {
	// try {
	// Panier panier = new Panier();
	// panier.setIdPanier(getId());
	// panier.setProduits(getProduits());
	// panierService.addPanier(panier);
	// // if user connecte then payement
	// // else se connecter/s'inscrire
	// } catch (DataAccessException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void addProductToCartByPID() {
	// FacesContext fc = FacesContext.getCurrentInstance();
	// Map<String,String> params =
	// fc.getExternalContext().getRequestParameterMap();
	// pid = Integer.parseInt(params.get("username"));
	// Produit prod = getProductByProductID(pid);
	// produitsDuPanier.add(prod);
	//
	// }
	//
	// Manon
	public void printID(ActionEvent event) {
		pid = (Integer) event.getComponent().getAttributes().get("pid");
		type = (String) event.getComponent().getAttributes().get("type");
	}
	
	public void addToCart() {
		int i=0;
		boolean trouve = false;
		
		for (Produit p : getProduitsDuPanier()) {
			if(p.getIdProduit()==pid) {
				trouve = true;
				i = getProduitsDuPanier().indexOf(p);
				getProduitsDuPanier().get(i).setQtePanier(getProduitsDuPanier().get(i).getQtePanier()+1);
			}
		}
		if (!trouve) {
			getProduitsDuPanier().add(produitService.getProduitById(pid));
			i = getProduitsDuPanier().size()-1;
			getProduitsDuPanier().get(i).setQtePanier(1);		
			}
		System.out.println(produitsDuPanier);
	}
	
	public void removeFromCart() {
		int i=0;
		boolean trouve = false;
		
		for (Produit p : getProduitsDuPanier()) {
			if(p.getIdProduit()==pid) {
				trouve = true;
				i = getProduitsDuPanier().indexOf(p);
				getProduitsDuPanier().get(i).setQtePanier(getProduitsDuPanier().get(i).getQtePanier()-1);
			}
		}
		if (getProduitsDuPanier().get(i).getQtePanier()==0) {
			getProduitsDuPanier().remove(getProduitsDuPanier().get(i));
		}

		System.out.println(produitsDuPanier);
	}
	

	public void onRowEdit(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Le produit suivant a �t� modifi�:",
				((Produit) event.getObject()).getLibelle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		int idProd = ((Produit) event.getObject()).getIdProduit();
		for (Produit p : getProduitsDuPanier()) {
			if(p.getIdProduit()==idProd) {
				int i = getProduitsDuPanier().indexOf(p);
				getProduitsDuPanier().get(i).setQtePanier(((Produit) event.getObject()).getQtePanier());
			}
		}
		getPanierList().get(getPanierList().size()-1).setProduits(getProduitsDuPanier());
		panierService.updatePanier(getPanierList().get(getPanierList().size()-1));

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edition annul�",
				((Produit) event.getObject()).getLibelle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public int showQuantite() {
		for (Produit p : getProduitsDuPanier()) {
			if(p.getIdProduit()==pid) {
				int i = getProduitsDuPanier().indexOf(p);
				return (getProduitsDuPanier().get(i).getQtePanier());
			}
		}
		return 0;
	}
	
	public Panier affichePanier() {
		System.out.println("/n" +panierList);
		return panierService.getPanierById(1);
	}
	
	
	public String validerPanier(){
		Panier panier = new Panier(produitsDuPanier);
		panierService.addPanier(panier);
		panierList.add(panier);
		idPanier=panierList.size();
		System.out.println("/n" +panierList);
		return "goToPanier";
	}
	
	public Panier panierEnCours() {
		idPanier = getPanierList().size()-1;
		System.out.println("\n" + getPanierList().get(idPanier));
		return getPanierList().get(idPanier);

	}
	
	public void afficheLibelle() {
		System.out.println(produitsDuPanier);
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


	public List<Produit> getProduitsDuPanier() {
		return produitsDuPanier;
	}

	public void setProduitsDuPanier(List<Produit> produitsDuPanier) {
		this.produitsDuPanier = produitsDuPanier;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public IPanierService getPanierService() {
		return panierService;
	}

	public void setPanierService(IPanierService panierService) {
		this.panierService = panierService;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	

}