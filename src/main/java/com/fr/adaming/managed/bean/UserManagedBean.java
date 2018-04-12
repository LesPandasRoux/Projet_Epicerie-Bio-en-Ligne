package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

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
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String PANIER = "panier";
	private static final String CONNEXION = "connexionUser";
//	private static final String CREACOMPTE = "creationCompte";

	@Autowired
	IUserService userService;

	List<User> userList;

	private int id;
	private String name;
	private String surname;
	private String pw;
	private String email;
	
	 @PostConstruct
	    public void init() {
	      userList=userService.getUsers();
	    }
	 
	
	//
	public void onRowEdit(RowEditEvent event) {

        FacesMessage msg = new FacesMessage("Le client suivant a ete edite:",((User) event.getObject()).getNom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		getUserService().updateUser((User)event.getObject());
        
    }
	
	   public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edition annule",((User) event.getObject()).getNom());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
//	        userList.remove((User) event.getObject());
//	        getUserService().deleteUser((User) event.getObject());
	    }
	   
	    
//	    public void onCellEdit(CellEditEvent event) {
//	        Object oldValue = event.getOldValue();
//	        Object newValue = event.getNewValue();
//	        if(newValue != null && !newValue.equals(oldValue)) {
//	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//	            FacesContext.getCurrentInstance().addMessage(null, msg);
//	        }
//	    }
     
    //
	public String addUser() {
		try {
			User user = new User();
			user.setIdUser(getId());
			user.setNom(getName());
			user.setPrenom(getSurname());
			user.setEmail(getEmail());
			user.setPw(getPw());
			userService.addUser(user);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}


	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSurname("");
		this.setEmail("");
		this.setPw("");
	}

	public String verifUser() {
		User user = getUserService().findbyEmail(email);
		if (user !=null) {
			if (user.getPw().equals(pw)) {
				return PANIER;
			}
		}
		return CONNEXION;
		
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
	
	public List<User> getUserList() {
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
