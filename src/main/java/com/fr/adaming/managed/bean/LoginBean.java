package com.fr.adaming.managed.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String email = null;
	private String password = null;

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;

	public String login() throws Exception {
		FacesMessage message = null;
		try {
			System.err.println(
					"\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - Authentication request - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			Authentication request = new UsernamePasswordAuthenticationToken(this.getEmail(), this.getPassword());
			System.err.println(
					"\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - Authentication result - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			Authentication result = authenticationManager.authenticate(request);
			System.err.println(
					"\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - SecurityContextHolder - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			SecurityContextHolder.getContext().setAuthentication(result);
			System.err.println(
					"\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - Login Succes - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		} catch (AuthenticationException e) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.err.println(
					"\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - Login Error - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			return "incorrect";
		}
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", this.getEmail());
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "correct";
	}

	public String cancel() {
		return null;
	}

	public String signUp() {
		return "success";
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		return "loggedout";
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String userName) {
		this.email = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
