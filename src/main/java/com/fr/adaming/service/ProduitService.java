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
	
//	@PostConstruct
//	private void initProduit() {
//		addProduit(new ProduitFrais( "pain", 1, 50,"pain.jpg",0, 1));
//		addProduit(new ProduitFrais( "banane", 0.3f ,100,"banane.jpg",0, 10));
//		addProduit(new ProduitFrais( "kiwi", 0.5f ,100,"kiwi.jpg",0, 10));
//		addProduit(new ProduitFrais( "pommeVerte", 0.2f ,100,"pommeVerte.jpg",0, 10));
//		addProduit(new ProduitFrais( "pommeRouge", 0.2f ,100,"pommeRouge.jpg",0, 10));
//		addProduit(new Epicerie( "noix", 1, 50,"noix.jpg",0,100));
//		addProduit(new Epicerie( "chocolat", 1.2f, 100,"chocolat.jpg",0,100));
//	}


}
