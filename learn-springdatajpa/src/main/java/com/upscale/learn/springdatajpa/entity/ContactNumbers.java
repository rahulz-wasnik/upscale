package com.upscale.learn.springdatajpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ContactNumbers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactId;
	
	private String number;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
	private User user;
	
	public ContactNumbers(String number) {
		this.number = number;
	}
	
	public ContactNumbers(String number, User user) {
		this.number = number;
		this.user = user;
	}
}
