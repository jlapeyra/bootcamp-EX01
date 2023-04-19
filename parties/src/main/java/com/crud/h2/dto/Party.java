package com.crud.h2.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Party  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	public Long id;
	public String name;

	@ManyToOne
	@JoinColumn(name="game")
	public Game game;
	
	@JsonIgnore
	@OneToMany
    @JoinColumn(name="current_party")
    public List<User> current_users;

	@JsonIgnore
	@OneToMany
    @JoinColumn(name="party")
    public List<Message> messages;

	public Party() {}
	public Party(Long id) {
		this.id = id;
	}
	
}
