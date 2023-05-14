package com.upscale.learn.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.upscale.learn.springdatajpa.entity.ContactNumbers;
import com.upscale.learn.springdatajpa.entity.User;
import com.upscale.learn.springdatajpa.service.ContactNumberServiceImpl;

@RestController
@RequestMapping(path = "/contact-numbers")
public class ContactNumberController {

	@Autowired
	private Faker faker;
	
	@Autowired
	private ContactNumberServiceImpl service;
	
	@PostMapping
	public ContactNumbers manyToOne() {
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				List.of(),
				List.of()				
				);
		ContactNumbers contactNumbers = new ContactNumbers(faker.phoneNumber().cellPhone(), user);
		
		return service.save(contactNumbers);
	}
}
