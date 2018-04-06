package com.fr.adaming.managed.bean;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.annotation.SessionAttributesHandler;

import com.fr.adaming.model.Administrateur;
import com.fr.adaming.model.User;
import com.fr.adaming.service.IUserService;

@Controller(value = "sessionMB")
@SessionScoped
public class SessionManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "panier";
	private static final String ERROR1 = "connexion";
	private static final String SUCCESSAD = "administrateur";
	
	@Autowired
	IUserService userService;

	User user;
	Administrateur admin;
	private String pw;
	private String email;
	
	public String verifUser() {
		User user = getUserService().findbyEmail(email);
		if (user !=null) {
			if (user.getPw().equals(pw)) {
				return SUCCESS;
			}
		}
		return ERROR1;
		
	}
	
	public String verifAdmin() {
		if(email.equals("admin") && pw.equals("admin")) {
			return SUCCESSAD;
		}
		else return ERROR1;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	


}
