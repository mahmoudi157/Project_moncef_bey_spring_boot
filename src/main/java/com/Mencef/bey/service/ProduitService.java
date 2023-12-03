package com.Mencef.bey.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mencef.bey.document.Produit;
import com.Mencef.bey.repository.ProduitRepo;




@Service
public class ProduitService {
	@Autowired
	private ProduitRepo produitRepo;
	
public Produit CreateProduit(String name, String parent, String descp, String keycate, double price, String img) {
	
	return produitRepo.save(new Produit(name,parent,descp,keycate,price,img));
	}
 
	
	public Produit getProduit(String id) {
		
		return produitRepo.findById(id).orElseThrow();
	}
	
	

	
	public List<Produit> catelisteproduit(String keycate) {
		return produitRepo.findByKeycate(keycate);
	}
	
	
	public List<Produit> userlisteproduit(String parent) {
		return produitRepo.findByParent(parent);
	}
	
	
	
	
	public boolean deletproduitbyid(String id) {
		if (produitRepo.existsById(id)) {
			produitRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	public boolean deletproduitbyparent(String parent) {
		if (produitRepo.existsByParent(parent)) {
			produitRepo.deleteByParent(parent);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public List<Produit> getAll() {
		if (produitRepo.count()==0) {
			return null;
		}else {
			return produitRepo.findAll();
		}
		
	}
	

}
