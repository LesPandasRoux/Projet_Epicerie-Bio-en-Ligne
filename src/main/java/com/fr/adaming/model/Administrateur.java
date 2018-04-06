package com.fr.adaming.model;

public class Administrateur {

	private String email = "admin@admin";
	private String pw = "admin";

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return email;
	}

	public void setLogin(String login) {
		this.email = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
