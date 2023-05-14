package com.upscale.learn.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.upscale.learn.springdatajpa.ResourceNotFoundException;
import com.upscale.learn.springdatajpa.entity.User;
import com.upscale.learn.springdatajpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User get(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public Optional<User> findByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	@Override
	public Optional<User> findByLastName(String lastName) {
		return userRepository.findUsingLastName(lastName);
	}

	@Override
	public Page<User> get(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);

		return userRepository.findAll(pageRequest);
	}

	@Override
	public List<User> save(List<User> users) {
		return userRepository.saveAll(users);
	}
	
	@Override
	public void insertUser(User user) {
		Optional<User> fetchedUser = userRepository.findById(1L);
		fetchedUser.get().setFirstName("Rahul");
		userRepository.insertUser(user.getFirstName(), user.getLastName());
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void deleteAllInBatch(List<User> users) {
		userRepository.deleteAllInBatch(users);
	}

}
