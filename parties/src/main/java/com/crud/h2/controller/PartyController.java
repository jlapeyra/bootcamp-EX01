package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dao.IPartyDAO;
import com.crud.h2.dto.Game;
import com.crud.h2.dto.Message;
import com.crud.h2.dto.Party;

@RestController
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	IPartyDAO partyDAO;
	
	@GetMapping("/list")
	public List<Party> findAll(){
		return partyDAO.findAll();
	}

	@PostMapping("/new")
	public Party newParty(@RequestParam String partyName, @RequestParam Long gameId) {
		Party party = new Party();
		party.name = partyName;
		party.game = new Game(gameId);
		return partyDAO.save(party);
	}

	@GetMapping("/getMessages")
	public List<Message> getMessages(@RequestParam Long partyId) {
		return partyDAO.findById(partyId).get().messages;
	}
}
