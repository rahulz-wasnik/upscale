package com.upscale.learn.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.upscale.learn.springdatajpa.entity.User;


public interface UserService {

	User registerUser(User user);
	
	User get(Long id);
	
	Page<User> get(int page, int size);
	
	Optional<User> findByFirstName(String firstName);
	
	Optional<User> findByLastName(String lastName);
	
	List<User> save(List<User> users);
	
	void deleteAll();

	void deleteAllInBatch(List<User> users);
	
	void insertUser(User user);
}
