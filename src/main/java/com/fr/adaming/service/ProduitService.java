package com.fr.adaming.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.dao.IProduitDAO;
import com.fr.adaming.model.Epicerie;
import com.fr.adaming.model.Produit;
import com.fr.adaming.model.ProduitFrais;
import com.fr.adaming.model.User;

@Transactional(readOnly = true)
@Service
public class ProduitService implements IProduitService {

	@Autowired
	IProduitDAO produitDAO;
	
	@Transactional(readOnly = false)
	@Override
	public void addProduit(Produit produit) {
		getProduitDAO().addProduit(produit);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteProduit(Produit produit) {
		getProduitDAO().deleteProduit(produit);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void updateProduit(Produit produit) {
		getProduitDAO().updateProduit(produit);
	}
	
	@Override
	public Produit getProduitById(int id) {
		return getProduitDAO().getProduitById(id);
	}

	@Override
	public List<Produit> getProduits() {	
		return getProduitDAO().getProduits();
	}

	public IProduitDAO getProduitDAO() {
		return produitDAO;
	}

	public void setProduitDAO(IProduitDAO produitDAO) {
		this.produitDAO = produitDAO;
	}
	
	private long i=1l;
	@PostConstruct
	private void initProduit() {
		addProduit(new Produit(i++, "banane", 1, 50));
		addProduit(new Produit(i++, "kiwi", 2, 50));
	}

}
