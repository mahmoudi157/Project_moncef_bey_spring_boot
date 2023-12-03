package com.Mencef.bey.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mencef.bey.document.Category;
import com.Mencef.bey.document.Produit;
import com.Mencef.bey.dto.AccDto;
import com.Mencef.bey.service.CategoryService;
import com.Mencef.bey.service.ProduitService;


@RestController
@Validated
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
CategoryService categoryService;
	@PostMapping("/add")
	public ResponseEntity<Category>  Createcategory(@RequestBody @Validated  Category cat) {
		 return ResponseEntity.ok(categoryService.CreateCategory(cat.getName(), cat.getDescp(), cat.getParantkey(), cat.getImg(), cat.getPrice(), cat.getCov1(), cat.getCov2(), cat.getCov3(), cat.getCov4(), cat.getQrcode(), cat.getAdress(), cat.getLat(), cat.getLng(), cat.getMin(), cat.getProvider())) ;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategory() {
		return ResponseEntity.ok( categoryService.getAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> getCategory(@PathVariable @Validated  String id) {
		return ResponseEntity.ok( categoryService.getCategory(id));
	}
	
	
	@GetMapping("/user/{parentkey}")
	public ResponseEntity<List<Category>> getCategoryByparentKey(@PathVariable @Validated  String parentkey) {
		return ResponseEntity.ok( categoryService.UserlisteCategory(parentkey));
	}
	

	
	
	
	
	
	@DeleteMapping("/delet")
	public ResponseEntity<Boolean> deletCategory(@RequestBody @Validated AccDto dtodelet) {
		if (categoryService.getCategory(dtodelet.getId()).orElseThrow().getParantkey().equals(dtodelet.getUserid())) {
			return ResponseEntity.ok(categoryService.deletCategorybyid(dtodelet.getId())) ;
			
		}else {
			
			
		}
		return ResponseEntity.ok(false);
		
	}
	
	
	
	
	
}
