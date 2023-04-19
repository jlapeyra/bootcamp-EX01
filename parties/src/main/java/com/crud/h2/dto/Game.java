package com.crud.h2.dto;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Game  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	public Long id;
	public String name;
	public String details;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name="game")
	public List<Party> parties;
	
	public Game() {}
	public Game(Long id) {
		this.id = id;
	}
}
