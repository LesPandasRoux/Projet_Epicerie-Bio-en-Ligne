package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.dao.IAdminDAO;
import com.fr.adaming.model.Administrateur;

@Transactional(readOnly = true)
@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminDAO adminDAO;
	
	@Transactional(readOnly = false)
	@Override
	public void addAdmin(Administrateur admin) {
		getAdminDAO().addAdmin(admin);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteAdmin(Administrateur admin) {
		getAdminDAO().deleteAdmin(admin);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void updateAdmin(Administrateur admin) {
		getAdminDAO().updateAdmin(admin);
	}
	
	@Override
	public Administrateur getAdminById(int id) {
		return getAdminDAO().getAdminById(id);
	}

	@Override
	public List<Administrateur> getAdmins() {	
		return getAdminDAO().getAdmins();
	}

	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

}
