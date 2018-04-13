package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.User;
import com.fr.adaming.service.ICommandeService;
import com.fr.adaming.service.IPanierService;
import com.fr.adaming.service.IUserService;
import com.fr.adaming.model.Commande;
import com.fr.adaming.model.Panier;

//IL MANQUE LE USER!!!

@Controller(value = "commandeMB")
@SessionScoped
public class CommandeManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	ICommandeService commandeService;

	@Autowired
	IPanierService panierService;

	@Autowired
	IUserService userService;

	private Long refCMD;
	private User owner;

	private String dateCMD;
	private String etatCommande;

	List<Commande> commandeList = new ArrayList<>();

	private int idPanier;

	public void addCommande() {
		try {
			Commande commande = new Commande();
			commande.setRefCMD(getRefCMD());
			;
			commande.setOwner(getOwner());
			commande.setDateCMD(getDateCMD());
			commande.setEtatCommande(getEtatCommande());
			commandeService.addCommande(commande);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

	public void reset() {
		this.setRefCMD(null);
		this.setOwner(null);
		this.setDateCMD(null);
		this.setEtatCommande(null);
	}

	public void recupID(ActionEvent event) {
		idPanier = (Integer) event.getComponent().getAttributes().get("idPanier");
		int idUser = Integer.parseInt(event.getComponent().getAttributes().get("id"));
		setOwner(userService.getUserById(idUser));
//		System.out.println(idPanier);
	}

	public String validerCommande() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		Panier panier = panierService.getPanierById(idPanier);
		Commande commande = new Commande(getOwner(), dtf.format(localDate), "en cours de préparation",
				panier);
		commandeService.addCommande(commande);

		panierService.getPanierById(idPanier).setCommande(commande);
		commandeList.add(commande);
		return "goToCommande";
	}

	public List<Commande> getCommandeList() {
		// commandeList = new ArrayList<Commande>();
		// commandeList.addAll(getCommandeService().getCommandes());
		return commandeList;
	}

	public Long getRefCMD() {
		return refCMD;
	}

	public ICommandeService getCommandeService() {
		return commandeService;
	}

	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	public void setCommandeList(List<Commande> commandeList) {
		this.commandeList = commandeList;
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

}