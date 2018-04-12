package com.fr.adaming.bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fr.adaming.dao.IUserDAO;
import com.fr.adaming.model.Role;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUserDAO UserDAO;
	
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		// get user by username
		String password = UserDAO.getUserByEmail(email).getPw();
		if (null == password) {
			throw new UsernameNotFoundException("User " + email + " not exists");
		}
		// get user roles and build user authorities
		List<Role> roles = UserDAO.getUserRoles(email);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
		}
		// instanciate Spring Security class User
		return new UserDetailsImpl(email, password, authorities);
	}
}
