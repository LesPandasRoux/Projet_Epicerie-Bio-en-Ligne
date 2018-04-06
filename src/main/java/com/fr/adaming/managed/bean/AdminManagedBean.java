package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Administrateur;
import com.fr.adaming.service.IAdminService;


@Controller(value="adminMB")
@RequestScoped
public class AdminManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
//	private static final String SUCCESSAD = "administrateur";
//	private static final String ERRORAD   = "errorad";
	
	@Autowired
	IAdminService adminService;
	
	List<Administrateur> adminList;
	
	private String login;
	private String password;
	
	/**
	 * Add Admin
	 * 
	 * @return String - Response Message
	 */
//	public String addAdmin() {
//		try {
//			Administrateur admin = new Administrateur();
//			admin.setLogin(getLogin());
//			admin.setPw(getPassword());
//			adminService.addAdmin(admin);
//			return SUCCESSAD;
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		} 	
//		
//		return ERRORAD;
//	}
	
//	public String verifAdmin() {
//		if(login.equals("admin") && password.equals("admin")) {
//			return SUCCESSAD;
//		}
//		else return ERRORAD;
//	}
	
	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setLogin("");
		this.setPassword("");
	}
	
	/**
	 * Get Admin List
	 * 
	 * @return List - Admin List
	 */
	public List<Administrateur> getAdminList() {
		adminList = new ArrayList<Administrateur>();
		adminList.addAll(getAdminService().getAdmins());
		return adminList;
	}
	
	/**
	 * Get Admin Service
	 * 
	 * @return IAdminService - Admin Service
	 */
	public IAdminService getAdminService() {
		return adminService;
	}

	/**
	 * Set Admin Service
	 * 
	 * @param IAdminServiceold - Admin Service
	 */
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
