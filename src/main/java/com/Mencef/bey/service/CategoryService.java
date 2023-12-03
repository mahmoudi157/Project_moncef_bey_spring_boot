package com.Mencef.bey.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mencef.bey.document.Category;
import com.Mencef.bey.repository.CategoryRepo;




@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProduitService produitService;
	
public Category CreateCategory(String name, String descp, String parantkey, String img, double price, String cov1, String cov2,
		String cov3, String cov4, String qrcode, String adress, float lat, float lng, float min, String provider) {
	
	return categoryRepo.save(new Category(name, descp, parantkey, img, price, cov1, cov2, cov3, cov4, qrcode, adress, lat, lng, min, provider));
	}
 



	
	public Optional<Category> getCategory(String id) {
		
		return categoryRepo.findById(id);
	}
	
	

	
	
	
	
	public List<Category> UserlisteCategory(String parentkey) {
		return categoryRepo.findByParantkey(parentkey);
	}
	
	
	
	
	public boolean deletCategorybyid(String id) {
		if (categoryRepo.existsById(id)) {
			categoryRepo.deleteById(id);
			produitService.deletproduitbyparent(id);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	public boolean deletCategoryByParentKey(String parentkey) {
		if (categoryRepo.existsByParantkey(parentkey)) {
			categoryRepo.deleteByParantkey(parentkey);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public List<Category> getAll() {
		if (categoryRepo.count()==0) {
			return null;
		}else {
			return categoryRepo.findAll();
		}
		
	}
	
	public boolean addNbrvente(String id) {
		if (categoryRepo.existsById(id)) {
			
			Category cate=categoryRepo.findById(id).orElseThrow();
			cate.setNbrevente(cate.getNbrevente()+1);
			categoryRepo.save(cate);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	public boolean changeRating(String id,float rating) {
		if (categoryRepo.existsById(id)) {
			
			Category cate=categoryRepo.findById(id).orElseThrow();
			cate.setRating(((cate.getRating()*cate.getNbrevente())+rating)/cate.getNbrevente());
			categoryRepo.save(cate);
			return true;
		}else {
			return false;
		}
		
		
	}
	

}
