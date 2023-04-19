package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crud.h2.dao.IUserDAO;
import com.crud.h2.dto.Party;
import com.crud.h2.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserDAO userDAO;
	
	@GetMapping("/list")
	public List<User> findAll(){
		return userDAO.findAll();
	}

	@PostMapping("/enterParty")
	public User enterParty(@RequestParam Long userId, @RequestParam Long partyId) {
		User user = userDAO.findById(userId).get();
		user.current_party = new Party(partyId);
		return userDAO.save(user);
	}

	@PostMapping("/exitParty")
	public User exitParty(@RequestParam Long userId) {
		User user = userDAO.findById(userId).get();
		user.current_party = null;
		return userDAO.save(user);
	}

	@PostMapping("/editEmail")
	public User editEmail(@RequestParam Long userId, @RequestParam String email) {
		User user = userDAO.findById(userId).get();
		user.email = email;
		return userDAO.save(user);
	}

	@PostMapping("/editUsername")
	public User editUserame(@RequestParam Long userId, @RequestParam String username) {
		User user = userDAO.findById(userId).get();
		user.username = username;
		return userDAO.save(user);
	}

	@PostMapping("/editPassword")
	public User editPassword(@RequestParam Long userId, @RequestParam String hash) {
		User user = userDAO.findById(userId).get();
		user.password_hash = hash;
		return userDAO.save(user);
	}
	
}
