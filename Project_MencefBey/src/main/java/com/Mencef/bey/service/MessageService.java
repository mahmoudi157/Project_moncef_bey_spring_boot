package com.Mencef.bey.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Mencef.bey.document.Message;
import com.Mencef.bey.repository.MessageRepo;




@Service
public class MessageService {
	@Autowired
	private MessageRepo messageRepo;
	private List<String> recivedmessage;
	
public Message CreateMessage(String toid,  String fromid,   String img,String msg) {
				return messageRepo.save(new Message(toid, fromid, new Date(), img, msg));
			
		
	}
 



	
	public Optional<Message> getmessage(String id) {
		return messageRepo.findById(id);
	}
	
	

	
	
	
	
	public List<String> listeRecevidMessage(String userId) {
	    List<String> recivedmessage = new ArrayList<>(); 

	    List<Message> messages = messageRepo.findByFromidOrToid(userId, userId);

	    for (Message msg : messages) {
	        if (!recivedmessage.contains(msg.getFromid())) {
	            recivedmessage.add(msg.getFromid());
	        }
	        if (!recivedmessage.contains(msg.getToid())) {
	            recivedmessage.add(msg.getToid());
	        }
	    }

	    return recivedmessage;
	}

	
	
	
	
	
	
	
	public List<Message> conversion(String userId, String autre) {
	    return messageRepo.findByFromidAndToidOrToidAndFromid(userId, autre);
	}
	
	
	
	public boolean deletMessagebyid(String id) {
		if (messageRepo.existsById(id)) {
			messageRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	public Message messageviewd(String id) {
		if (messageRepo.existsById(id)) {
			Message message=messageRepo.findById(id).orElseThrow();
			message.setView(1);
			return messageRepo.save(message);
		}else {
			return null;
		}
		
		
	}
	
	
		
		
	}
	
	
	


