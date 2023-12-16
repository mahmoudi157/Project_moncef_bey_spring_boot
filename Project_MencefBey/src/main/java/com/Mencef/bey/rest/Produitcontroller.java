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

import com.Mencef.bey.document.Produit;
import com.Mencef.bey.dto.AccDto;
import com.Mencef.bey.dto.ProduitDto;
import com.Mencef.bey.service.ProduitService;


@RestController
@Validated
@RequestMapping("/api/produit")
public class Produitcontroller {
	@Autowired
ProduitService produitService;
	@PostMapping("/add")
	public ResponseEntity<Produit>  CreateProduit(@RequestBody @Validated  ProduitDto pr) {
		 return ResponseEntity.ok(produitService.CreateProduit(pr.getName(), pr.getParent(), pr.getDescp(), pr.getKeycate(), pr.getPrice(), pr.getImg())) ;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduit(@PathVariable @Validated  String id) {
		return ResponseEntity.ok( produitService.getProduit(id));
	}
	
	
	@GetMapping("/user/{parent}")
	public ResponseEntity<List<Produit>> getProduitbyparent(@PathVariable @Validated  String parent) {
		return ResponseEntity.ok( produitService.userlisteproduit(parent));
	}
	

	@GetMapping("/category/{keycate}")
	public ResponseEntity<List<Produit>> getProduitbycate(@PathVariable @Validated  String keycate) {
		return ResponseEntity.ok( produitService.catelisteproduit(keycate));
	}
	
	
	
	
	@DeleteMapping("/delet")
	public  ResponseEntity<Boolean> deletproduit(@RequestBody @Validated AccDto dtodelet) {
		if (produitService.getProduit(dtodelet.getId()).getParent().equals(dtodelet.getUserid())) {
			return ResponseEntity.ok(produitService.deletproduitbyid(dtodelet.getId()))	;
			
		}else {
			
			
		}
		return ResponseEntity.ok(false);
		
	}
	
	
	
	
	
}
