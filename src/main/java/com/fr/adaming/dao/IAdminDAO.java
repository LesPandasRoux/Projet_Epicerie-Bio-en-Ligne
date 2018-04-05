package com.fr.adaming.dao;

import java.util.List;

import com.fr.adaming.model.Administrateur;

public interface IAdminDAO {

	public void addAdmin(Administrateur admin);

	public void updateAdmin(Administrateur admin);
	
	public void deleteAdmin(Administrateur admin);
	
	public Administrateur getAdminById(int id);
	
	public List<Administrateur> getAdmins();
}
