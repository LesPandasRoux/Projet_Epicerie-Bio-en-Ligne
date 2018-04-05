package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.User;
import com.fr.adaming.service.IUserService;

/**
 * 
 * User Managed Bean
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */

@Controller(value = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "panier";
	private static final String ERROR1 = "connexion";
	private static final String ERROR = "creationCompte";

	@Autowired
	IUserService userService;

	List<User> userList;

	private int id;
	private String name;
	private String surname;
	private String login;
	private String pw;
	private String email;

	public String addUser() {
		try {
			User user = new User();
			user.setIdUser(getId());
			user.setNom(getName());
			user.setPrenom(getSurname());
			user.setEmail(getEmail());
			user.setLogin(getLogin());
			user.setPw(getPw());
			userService.addUser(user);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}
	
	public String verifUser() {
		User user = getUserService().findbyEmail(email);
		if (user !=null) {
			if (user.getPw().equals(pw)) {
				return SUCCESS;
			}
		}
		return ERROR1;
		
	}
	
	public String editUser(User user) {
		user.setEditable(true);
		return null;
	}

	public String saveAction() { 
		//get all existing value but set "editable" to false    
		for (User u : userService.getUsers()){    
			u.setEditable(false);   
			}   
		//return to current page   
		return null;  
	}

	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSurname("");
		this.setEmail("");
		this.setLogin("");
		this.setPw("");
	}

	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

}
