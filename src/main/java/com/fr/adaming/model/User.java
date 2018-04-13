package com.fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;

	private String nom;

	private String prenom;

	private String pw;

	private String email;

	private boolean editable;

	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Commande> commande;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLE_USERS", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "idUser"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "idRole"))
	private List<Role> roles;

	public User() {
		super();
	}

	public User(int idUser, String prenom, String nom, String pw, String email) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.pw = pw;
		this.email = email;
	}

	public User(String prenom, String nom, String pw, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pw = pw;
		this.email = email;
	}

	public User(String nom, String prenom, String pw, String email, List<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pw = pw;
		this.email = email;
		this.roles = roles;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (editable != other.editable)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUser != other.idUser)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", pw=" + pw + ", email=" + email
				+ "]";
	}

}
