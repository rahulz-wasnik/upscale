package com.upscale.learn.springdatajpa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.upscale.learn.springdatajpa.entity.Address;
import com.upscale.learn.springdatajpa.entity.ContactNumbers;
import com.upscale.learn.springdatajpa.entity.User;
import com.upscale.learn.springdatajpa.service.UserService;


@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Faker faker;
	
	@GetMapping(path = "/{id}")
	public User get(@PathVariable Long id) {
		return userService.get(id);
	}
	
	@GetMapping(path = "/name/first/{firstName}")
	public Optional<User> findByFirstName(@PathVariable String firstName) {
		return userService.findByFirstName(firstName);
	}
	
	@GetMapping(path = "/name/last/{lastName}")
	public Optional<User> findByLastName(@PathVariable String lastName) {
		return userService.findByLastName(lastName);
	}
	
	@GetMapping
	public Page<User> get(@RequestParam int page, @RequestParam int size) {
		return userService.get(page, size);
	}

	@PostMapping
    public void createUsers() {
		
		List<User> users = IntStream.range(0, 2).mapToObj(i -> new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				List.of(new Address(faker.address().city()), new Address(faker.address().city())),
				List.of(new ContactNumbers(faker.phoneNumber().cellPhone()), new ContactNumbers(faker.phoneNumber().cellPhone()))
			)).toList();
		
    	users = userService.save(users);
    }
	
	@PostMapping(path = "/insert")
	public void insertUser() {
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				List.of(),
				List.of()
				);
		
		userService.insertUser(user);
	}


	@DeleteMapping(path = "/all")
	public void deleteAll() {
		userService.deleteAll();
	}
}
