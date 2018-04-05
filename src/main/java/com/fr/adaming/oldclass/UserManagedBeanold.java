//package com.fr.adaming.oldclass;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Controller;
//
//import com.fr.adaming.model.User;
//import com.fr.adaming.oldclass.IUserServiceold;
//
///**
// * 
// * User Managed Bean
// * 
// * @author onlinetechvision.com
// * @since 25 Mar 2012
// * @version 1.0.0
// *
// */
////@ManagedBean(name="userMB")
//@Controller(value="userMBold")
//@RequestScoped
//public class UserManagedBeanold implements Serializable {
//	
//	private static final long serialVersionUID = 1L;
//	private static final String SUCCESS = "success";
//	private static final String ERROR   = "error";
//	
//	//Spring User Service is injected...
////	@ManagedProperty(value="#{UserService}")
//	@Autowired
//	IUserServiceold userService;
//	
//	List<User> userList;
//	
//	private int id;
//	private String name;
//	private String surname;
//	
//	/**
//	 * Add User
//	 * 
//	 * @return String - Response Message
//	 */
//	public String addUser() {
//		try {
//			User user = new User();
//			user.setIdUser(getId());
//			user.setNom(getName());
//			user.setPrenom(getSurname());
//			userService.addUser(user);
//			return SUCCESS;
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		} 	
//		
//		return ERROR;
//	}
//	
//	/**
//	 * Reset Fields
//	 * 
//	 */
//	public void reset() {
//		this.setId(0);
//		this.setName("");
//		this.setSurname("");
//	}
//	
//	/**
//	 * Get User List
//	 * 
//	 * @return List - User List
//	 */
//	public List<User> getUserList() {
//		userList = new ArrayList<User>();
//		userList.addAll(getUserService().getUsers());
//		return userList;
//	}
//	
//	/**
//	 * Get User Service
//	 * 
//	 * @return IUserService - User Service
//	 */
//	public IUserServiceold getUserService() {
//		return userService;
//	}
//
//	/**
//	 * Set User Service
//	 * 
//	 * @param IUserService - User Service
//	 */
//	public void setUserService(IUserServiceold userService) {
//		this.userService = userService;
//	}
//	
//	/**
//	 * Set User List
//	 * 
//	 * @param List - User List
//	 */
//	public void setUserList(List<User> userList) {
//		this.userList = userList;
//	}
//	
//	/**
//	 * Get User Id
//	 * 
//	 * @return int - User Id
//	 */
//	public int getId() {
//		return id;
//	}
//
//	/**
//	 * Set User Id
//	 * 
//	 * @param int - User Id
//	 */
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	/**
//	 * Get User Name
//	 * 
//	 * @return String - User Name
//	 */
//	public String getName() {
//		return name;
//	}
//	
//	/**
//	 * Set User Name
//	 * 
//	 * @param String - User Name
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	/**
//	 * Get User Surname
//	 * 
//	 * @return String - User Surname
//	 */
//	public String getSurname() {
//		return surname;
//	}
//	
//	/**
//	 * Set User Surname
//	 * 
//	 * @param String - User Surname
//	 */
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}
//	
//}