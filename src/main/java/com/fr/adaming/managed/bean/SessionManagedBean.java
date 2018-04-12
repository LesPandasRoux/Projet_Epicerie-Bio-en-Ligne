package com.fr.adaming.managed.bean;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Administrateur;
import com.fr.adaming.model.User;
import com.fr.adaming.service.IAdminService;
import com.fr.adaming.service.IUserService;

@Controller(value = "sessionMB")
@SessionScoped
public class SessionManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PANIER = "panier";
	private static final String CONNEXION = "connexion";
	private static final String ADMIN = "administrateur";

	@Autowired
	IUserService userService;

	@Autowired
	IAdminService adminService;

	User user;
	Administrateur admin;
	private String pw;
	private String email;

	public String verifUser() {
		User user = getUserService().findbyEmail(getEmail());
		System.out.println(user);
		if (user != null) {
			if (user.getPw().equals(getPw())) {
				System.out.println(user.getPw());
				return PANIER;
			}
		}
		return CONNEXION;

	}

	public String verifAdmin() {
		if (email.equals("admin@admin") && pw.equals("admin")) {
			return ADMIN;
		} else
			return CONNEXION;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
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
}
