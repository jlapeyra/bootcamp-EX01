package com.crud.h2.dto;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Message  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	public Long id;
	public String text;
	public Timestamp timestamp;
	
	@ManyToOne
    @JoinColumn(name="sender")
    public User sender;

	@ManyToOne
    @JoinColumn(name="party")
    public Party party;
	
	public Message() {}
	public Message(Long id) {
		this.id = id;
	}
	
}
