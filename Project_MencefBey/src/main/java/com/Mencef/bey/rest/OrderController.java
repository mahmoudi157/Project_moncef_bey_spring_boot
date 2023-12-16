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
import com.Mencef.bey.document.Order;
import com.Mencef.bey.dto.AccDto;
import com.Mencef.bey.dto.OrderDto;
import com.Mencef.bey.dto.ReciDto;
import com.Mencef.bey.service.OrderService;

@RestController
@Validated
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
OrderService orderService;
	
	@PostMapping("/add")
	public ResponseEntity<Order>  Createorder(@RequestBody @Validated  OrderDto orderDto) {
	
			return ResponseEntity.ok(orderService.CreateOrder(orderDto.getProdid(),  orderDto.getToid(), orderDto.getAdress(), orderDto.getPhone(), orderDto.getFromid(), orderDto.getQuntite())) ;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Order>> getOrder(@PathVariable @Validated  String id) {
		return ResponseEntity.ok( orderService.getOrder(id));
	}
	
	
	@GetMapping("/recived/{userid}")
	public ResponseEntity<List<Order>> getrecivedOrder(@PathVariable @Validated  String userid) {
		return ResponseEntity.ok( orderService.listeRecevidOrder(userid));
	}
	
	
	@GetMapping("/sentd/{userid}")
	public ResponseEntity<List<Order>> getsentOrder(@PathVariable @Validated  String userid) {
		return ResponseEntity.ok( orderService.listeSentOrder(userid));
	}
	

	
	
	
	
	
	@DeleteMapping("/delet")
	public ResponseEntity<Boolean> deletCategory(@RequestBody @Validated AccDto dtodelet) {
		if (orderService.getOrder(dtodelet.getId()).orElseThrow().getFromid().equals(dtodelet.getUserid())) {
			return ResponseEntity.ok(orderService.deletOrderbyid(dtodelet.getId()))	;
			
		}else {
			
			
		}
		return ResponseEntity.ok(false);
		
	}
	
	@PutMapping("/acpted")
	public Boolean acepted(@RequestBody @Validated AccDto dtodelet) {
		if	(orderService.getOrder(dtodelet.getId()).orElseThrow().getProduit().getParent().equals(dtodelet.getUserid()))
		{
			orderService.orderacpte(dtodelet.getId());
			return  true;
		}else {
			
			
		}
		return false;
		
	}
	
	
	@PutMapping("/reci")
	public Boolean reci(@RequestBody @Validated ReciDto dto) {
		if	(orderService.getOrder(dto.getId()).orElseThrow().getFromid().equals(dto.getUserid()))
		{
			orderService.orderRecived(dto.getId(),dto.getRating());
			return  true;
		}else {
			
			
		}
		return false;
		
	}
	
	
	
	
	
	
	
	
}
