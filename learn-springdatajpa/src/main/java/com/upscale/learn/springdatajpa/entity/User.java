package com.upscale.learn.springdatajpa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@NamedQuery(name = "User.findUsingLastName", query = "select u from User u join Address where u.lastName=?1")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ContactNumbers> contactNumbers;

	public User(String firstName, String lastName, List<Address> addresses, List<ContactNumbers> contactNumbers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresses = addresses;
		this.contactNumbers = contactNumbers;
	}
}
