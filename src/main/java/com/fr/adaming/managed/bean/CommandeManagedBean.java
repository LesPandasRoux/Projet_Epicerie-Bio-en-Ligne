package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.dao.ICommandeDAO;
import com.fr.adaming.model.Produit;
import com.fr.adaming.model.User;
import com.fr.adaming.service.ICommandeService;
import com.fr.adaming.model.Commande;

@Controller(value="commandeMB")
@RequestScoped
public class CommandeManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
@Autowired
ICommandeService commandeService;

	private Long refCMD;
	private User owner;

	private Date dateCMD;
	private String etatCommande;
	
	List<Commande> commandeList;
	
	public String addCommande() {
		try {
			Commande commande = new Commande();
			commande.setRefCMD(getRefCMD());;
			commande.setOwner(getOwner());
			commande.setDateCMD(getDateCMD());
			commande.setEtatCommande(getEtatCommande());
			commandeService.addCommande(commande);
			return null;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		return null;
	}
	

	public void reset() {
		this.setRefCMD(null);
		this.setOwner(null);
		this.setDateCMD(null);
		this.setEtatCommande(null);
	}

	public List<Commande> getCommandeList() {
//		commandeList = new ArrayList<Commande>();
//		commandeList.addAll(getCommandeService().getCommandes());
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
	public Date getDateCMD() {
		return dateCMD;
	}
	public void setDateCMD(Date dateCMD) {
		this.dateCMD = dateCMD;
	}
	public String getEtatCommande() {
		return etatCommande;
	}
	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}
	
	

}
