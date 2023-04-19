package com.crud.h2.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class User  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	public Long id;
	public String username;
	public String email;
	public String password_hash;
	
	@ManyToOne
    @JoinColumn(name="current_party")
    public Party current_party;

	public User() {}
	public User(Long id) {
		this.id = id;
	}
	
}
