package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.model.Administrateur;

/**
 * 
 * Admin Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface IAdminService {
	
	public void addAdmin(Administrateur admin);
	
	public void updateAdmin(Administrateur admin);

	public void deleteAdmin(Administrateur admin);
	
	public Administrateur getAdminById(int id);
	
	public List<Administrateur> getAdmins();
}
