package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Epicerie;
import com.fr.adaming.model.Produit;
import com.fr.adaming.model.ProduitFrais;
import com.fr.adaming.service.IProduitService;

import javafx.scene.control.TreeTableColumn.CellEditEvent;

@Controller(value = "produitMB")
@SessionScoped
public class ProduitManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	IProduitService produitService;

	List<Produit> produitList;

	private Long id;

	private String libelle;

	private int prix;

	private int qteStock;
	
	private int poids;
	
	private int dureeValidite;

	private String urlimg;
	
	private String[] types;

	// Ajout 05/04/2018
	@PostConstruct
	public void init() {
		produitList = produitService.getProduits();
	}

	public void onRowEdit(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Le produit suivant a été édité:",
				((Produit) event.getObject()).getLibelle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		getProduitService().updateProduit((Produit) event.getObject());

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edition annulé",
				((Produit) event.getObject()).getLibelle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
//		getProduitService().deleteProduit((Produit) event.getObject());
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	
	public String[] getTypes() {
		return types;
		}
	
	public void setTypes(String[] types) {
        this.types = types;
    }


	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getDureeValidite() {
		return dureeValidite;
	}

	public void setDureeValidite(int dureeValidite) {
		this.dureeValidite = dureeValidite;
	}
	

	//
	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public List<Produit> getProduitList() {
		// produitList = new ArrayList<Produit>();
		// produitList.addAll(getProduitService().getProduits());
		return produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}

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

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public void addProduit() {
		try {
			if (getTypes()[0].equals("ProduitFrais")) {
			ProduitFrais produit = new ProduitFrais(getLibelle(), getPrix(), getQteStock(), getUrlimg(), getDureeValidite());
			produitService.addProduit(produit);
			
			}
			
			if (getTypes()[0].equals("Epicerie")) {
				Epicerie produit = new Epicerie(getLibelle(), getPrix(), getQteStock(), getUrlimg(), getPoids());
				produitService.addProduit(produit);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		finally {
			//Pour mettre Ã  jour la datatable, mettre Ã  jour la liste
			produitList = produitService.getProduits();
		}
	}

	public void reset() {
		this.setId(0l);
		this.setLibelle("produit");
		this.setQteStock(0);
		this.setPrix(0);
	}

}
