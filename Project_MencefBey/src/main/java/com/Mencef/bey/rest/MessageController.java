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

import com.Mencef.bey.document.Message;
import com.Mencef.bey.document.Order;
import com.Mencef.bey.dto.AccDto;
import com.Mencef.bey.dto.GetConvDto;
import com.Mencef.bey.dto.MessageDto;
import com.Mencef.bey.dto.OrderDto;
import com.Mencef.bey.dto.ReciDto;
import com.Mencef.bey.service.MessageService;
import com.Mencef.bey.service.OrderService;

@RestController
@Validated
@RequestMapping("/api/message")
public class MessageController {
	@Autowired
MessageService messageService;
	
	@PostMapping("/add")
	public ResponseEntity<Message>  CreateMessage(@RequestBody @Validated  MessageDto messageDto) {
	
			return ResponseEntity.ok(messageService.CreateMessage(messageDto.getToid(), messageDto.getFromid(), messageDto.getImg(), messageDto.getMsg())) ;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Message>> getMessage(@PathVariable @Validated  String id) {
		return ResponseEntity.ok( messageService.getmessage(id));
	}
	
	
	@GetMapping("/chatliste/{userid}")
	public ResponseEntity<List<String>> listeRecevidMessage(@PathVariable @Validated  String userid) {
		return ResponseEntity.ok( messageService.listeRecevidMessage(userid));
	}
	
	
	@GetMapping("/conversion")
	public ResponseEntity<List<Message>> getConversion(@RequestBody @Validated  GetConvDto convDto) {
		return ResponseEntity.ok( messageService.conversion(convDto.getId(),convDto.getAutre()));
	}
	

	
	
	
	
	
	@DeleteMapping("/delet")
	public ResponseEntity<Boolean> deletCategory(@RequestBody @Validated AccDto dtodelet) {
		if (messageService.getmessage(dtodelet.getId()).orElseThrow().getFromid().equals(dtodelet.getUserid())) {
			return ResponseEntity.ok(messageService.deletMessagebyid(dtodelet.getId()))	;
			
		}else {
			
			
		}
		return ResponseEntity.ok(false);
		
	}
	
	@PutMapping("/viewed")
	public Message viewed(@RequestBody @Validated AccDto dtodelet) {
		if	(messageService.getmessage(dtodelet.getId()).orElseThrow().getToid().equals(dtodelet.getUserid()))
		{
			return	messageService.messageviewd(dtodelet.getId());
			
		}else {
			
			
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
