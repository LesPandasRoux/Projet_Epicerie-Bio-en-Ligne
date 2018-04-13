package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.model.Role;

/**
 * 
 * Role Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface IRoleService {
	
	public void addRole(Role role);
	
	public void updateRole(Role role);

	public void deleteRole(Role role);
	
	public Role getRoleById(int id);
	
	public List<Role> getRoles();
}
