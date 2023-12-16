package com.Mencef.bey.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mencef.bey.document.Category;
import com.Mencef.bey.document.Order;
import com.Mencef.bey.document.Produit;
import com.Mencef.bey.repository.CategoryRepo;
import com.Mencef.bey.repository.OrderRepo;




@Service
public class OrderService {
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategoryService categoryService;
	
public Order CreateOrder(String prodid,  String toid, String adress,
		String phone, String fromid, String quntite) {
	Produit produit=produitService.getProduit(prodid);
	if (produit == null) {
		return null;
    }else {
	return orderRepo.save(new Order(produitService.getProduit(prodid), toid,new Date(),adress,
		phone, fromid, quntite, "0", "0"));
	}
	}
 



	
	public Optional<Order> getOrder(String id) {
		
		return orderRepo.findById(id);
	}
	
	

	
	
	
	
	public List<Order> listeRecevidOrder(String userId) {
		return orderRepo.findByToid(userId);
	}
	
	
	public List<Order> listeSentOrder(String userId) {
		return orderRepo.findByFromid(userId);
	}
	
	
	
	
	public boolean deletOrderbyid(String id) {
		if (orderRepo.existsById(id)) {
			orderRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	public Order orderacpte(String id) {
		if (orderRepo.existsById(id)) {
			Order order=orderRepo.findById(id).orElseThrow();
			order.setAcp("1");
			return orderRepo.save(order);
		}else {
			return null;
		}
		
		
	}
	
	public Order orderRecived(String id,float rating ) {
		if (orderRepo.existsById(id)) {
			Order order=orderRepo.findById(id).orElseThrow();
			order.setRec("1");
			categoryService.addNbrvente(order.getProduit().getKeycate());
			categoryService.changeRating(id, rating);
		return orderRepo.save(order);
		}else {
			return null;
		}
		
		
	}
	
	
	

}
