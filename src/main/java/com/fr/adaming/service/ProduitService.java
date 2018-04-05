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
		addProduit(new ProduitFrais(i++, "pain", 1, 50,"pain.jpg", 1));
		addProduit(new ProduitFrais(i++, "banane", 0.3f ,100,"banane.jpg", 10));
		addProduit(new ProduitFrais(i++, "kiwi", 0.5f ,100,"kiwi.jpg", 10));
		addProduit(new ProduitFrais(i++, "pommeVerte", 0.2f ,100,"pommeVerte.jpg", 10));
		addProduit(new ProduitFrais(i++, "pommeRouge", 0.2f ,100,"pommeRouge.jpg", 10));
		addProduit(new Epicerie(i++, "noix", 1, 50,"noix.jpg",100));
		addProduit(new Epicerie(i++, "chocolat", 1.2f, 100,"chocolat.jpg",100));
	}


}
