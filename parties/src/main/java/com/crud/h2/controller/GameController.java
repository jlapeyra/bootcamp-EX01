package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dao.IGameDAO;
import com.crud.h2.dto.Game;
import com.crud.h2.dto.Party;

@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	IGameDAO gameDAO;
	
	@GetMapping("/list")
	public List<Game> findAll(){
		return gameDAO.findAll();
	}

	@GetMapping("/getParties")
	public List<Party> getParties(@RequestParam Long gameId) {
		return gameDAO.findById(gameId).get().parties;
	}
	
	
	
}
