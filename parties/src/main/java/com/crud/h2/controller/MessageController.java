package com.crud.h2.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dao.IMessageDAO;
import com.crud.h2.dto.*;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	IMessageDAO messageDAO;
	
	@GetMapping("/list")
	public List<Message> findAll(){
		return messageDAO.findAll();
	}

	@PostMapping("/new")
	public Message newMessage(@RequestParam Long userId, @RequestParam Long partyId, @RequestParam String text) {
		User user = new User(userId);
		Party party = new Party(partyId);
		Message message = new Message();
		message.text = text;
		message.party = party;
		message.sender = user;
		message.timestamp = Timestamp.from(Instant.now());
		return messageDAO.save(message);
	}

	@PostMapping("/edit")
	public Message editMessage(@RequestParam Long userId, @RequestParam Long messageId, @RequestParam String text) throws Exception {
		Message message = messageDAO.findById(messageId).get();
		if (message.sender.id != userId) throw new Exception("User "+userId+" can't edit message "+messageId+" because it was sended by user "+message.sender.id);
		message.text = text;
		return messageDAO.save(message);
	}

	@DeleteMapping("/delete")
	public void deleteMessage(@RequestParam Long userId, @RequestParam Long messageId) throws Exception {
		Message message = messageDAO.findById(messageId).get();
		if (message.sender.id != userId) throw new Exception("User "+userId+" can't delete message "+messageId+" because it was sended by user "+message.sender.id);
		messageDAO.deleteById(messageId);
	}
	
	
}
