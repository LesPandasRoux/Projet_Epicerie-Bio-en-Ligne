package com.fr.adaming.dao;

import java.util.List;

import com.fr.adaming.model.Role;



public interface IRoleDAO {
	public void addRole(Role role);

	public void updateRole(Role role);
	
	public void deleteRole(Role role);
	
	public Role getRoleById(int id);
	
	public List<Role> getRoles();
}
