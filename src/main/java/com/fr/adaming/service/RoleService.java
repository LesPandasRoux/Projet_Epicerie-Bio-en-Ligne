package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.dao.IRoleDAO;
import com.fr.adaming.model.Role;

@Transactional(readOnly = true)
@Service
public class RoleService implements IRoleService {

	@Autowired
	IRoleDAO roleDAO;
	
	@Transactional(readOnly = false)
	@Override
	public void addRole(Role role) {
		getRoleDAO().addRole(role);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteRole(Role role) {
		getRoleDAO().deleteRole(role);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void updateRole(Role role) {
		getRoleDAO().updateRole(role);
	}
	
	@Override
	public Role getRoleById(int id) {
		return getRoleDAO().getRoleById(id);
	}

	@Override
	public List<Role> getRoles() {	
		return getRoleDAO().getRoles();
	}

	public IRoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

}
