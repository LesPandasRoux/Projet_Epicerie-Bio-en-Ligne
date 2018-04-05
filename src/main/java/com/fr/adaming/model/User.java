package com.fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;

	private String nom;

	private String prenom;

	private String login;

	private String pw;

	private String email;
	
	private boolean editable=false;

	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Commande> commande;
	
	

	public User() {
		super();
	}

	public User(int idUser, String prenom,String nom, String login, String pw, String email) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pw = pw;
		this.email = email;
	}

	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	

}
