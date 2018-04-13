package com.fr.adaming.managed.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.fr.adaming.model.Commande;
import com.fr.adaming.model.Role;
import com.fr.adaming.model.User;
import com.fr.adaming.service.IRoleService;


@Controller(value="roleMB")
@SessionScoped
public class RoleManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
@Autowired
IRoleService roleService;

private int idRole;

private String role;

private List<User> users;

public void addRole() {
	try {
		Role role = new Role();
		role.setIdRole(getIdRole());
		role.setRoleName(getRole());
		role.setUsers(getUsers());
		roleService.addRole(role);
	} catch (DataAccessException e) {
		e.printStackTrace();
	} 	
	
}

public IRoleService getRoleService() {
	return roleService;
}

public void setRoleService(IRoleService roleService) {
	this.roleService = roleService;
}

public int getIdRole() {
	return idRole;
}

public void setIdRole(int idRole) {
	this.idRole = idRole;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public List<User> getUsers() {
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
}



	

}
