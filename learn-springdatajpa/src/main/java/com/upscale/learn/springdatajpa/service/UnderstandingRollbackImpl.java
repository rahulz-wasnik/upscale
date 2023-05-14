package com.upscale.learn.springdatajpa.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.upscale.learn.springdatajpa.entity.ContactNumbers;
import com.upscale.learn.springdatajpa.entity.User;
import com.upscale.learn.springdatajpa.repository.ContactNumberRepository;
import com.upscale.learn.springdatajpa.repository.UserRepository;

@Service
public class UnderstandingRollbackImpl {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactNumberRepository contactNumberRepository;
	
	@Autowired
	private Faker faker;
	
	/**
	 * Saves the user to the database
	 * @param user
	 */
	public void normalSave(User user) {
		userRepository.save(user);
	}
	
	/**
	 * Saves the user to the database when a runtime exception occurs
	 * @param user
	 */
	public void saveWithoutTransactionAndRuntimeException(User user) {
		userRepository.save(user);
		throw new RuntimeException();
	}
	
	/**
	 * Rolls-back and does not save the user to the database when a runtime exception occurs
	 * @param user
	 */
	@Transactional
	public void saveWithRuntimeException(User user) {
		userRepository.save(user);
		throw new RuntimeException();
	}
	
	/**
	 * Saves the user to the database when a checked exception occurs
	 * @param user
	 * @throws SQLException 
	 */
	@Transactional
	public void saveWithCheckedExceptionButNoRollback(User user) throws SQLException {
		userRepository.save(user);
		throw new SQLException();
	}
	
	/**
	 * Roll'sback and does not save the user in the database when a checked exception occurs
	 * @param user
	 * @throws SQLException 
	 */
	@Transactional(rollbackFor = SQLException.class)
	public void saveWithCheckedExceptionAndRollback(User user) throws SQLException {
		userRepository.save(user);
		throw new SQLException();
	}
	
	/**
	 * Saves the user in the database when a exception occurs
	 * @param user
	 */
	@Transactional
	public void saveWithTryCatch(User user) {
		try {
			userRepository.save(user);
			throw new SQLException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves both user and contact to the db
	 * @param user 
	 */
	@Transactional
	public void nestedSave(User user) {
		userRepository.save(user);
		saveContactInformation();
	}
	
	@Transactional
	private void saveContactInformation() {
		ContactNumbers contactNumbers = new ContactNumbers(faker.phoneNumber().cellPhone());
		contactNumberRepository.save(contactNumbers);
	}
	
	/**
	 * Saves both user and contact to the db
	 * @param user 
	 */
	@Transactional
	public void nestedSaveWithPropagtionLevelAsNested(User user) {
		userRepository.save(user);
		saveContactInformationWithPropagtionLevelAsNested();
	}
	
	@Transactional(propagation=Propagation.NESTED)
	private void saveContactInformationWithPropagtionLevelAsNested() {
		ContactNumbers contactNumbers = new ContactNumbers(faker.phoneNumber().cellPhone());
		contactNumberRepository.save(contactNumbers);
	}
	
	/**
	 * Rolls back both transaction and saves nothing to db
	 * @param user 
	 */
	@Transactional
	public void nestedSaveWithPropagationAsRequiredNew(User user) {
		userRepository.save(user);
		saveContactInformationWithPropagationAsRequiredNew();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveContactInformationWithPropagationAsRequiredNew() {
		ContactNumbers contactNumbers = new ContactNumbers(faker.phoneNumber().cellPhone());
		contactNumberRepository.save(contactNumbers);
	}
	
	/**
	 * Rolls back both transaction and saves nothing to db
	 * @param user 
	 */
	@Transactional
	public void nestedSaveWithPropagationAsSupported(User user) {
		userRepository.save(user);
		saveContactInformationWithPropagationAsSupported();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void saveContactInformationWithPropagationAsSupported() {
		ContactNumbers contactNumbers = new ContactNumbers(faker.phoneNumber().cellPhone());
		contactNumberRepository.save(contactNumbers);
	}
	
	/**
	 * Rolls back both transaction and saves nothing to db
	 * @param user 
	 */
	@Transactional
	public void nestedSaveAndRuntimeException(User user) {
		User savedUser = userRepository.save(user);
		ContactNumbers contactNumbers = new ContactNumbers(faker.phoneNumber().cellPhone(), savedUser);
		saveContactInformationAndRuntimeException(contactNumbers);
	}
	
	@Transactional
	private void saveContactInformationAndRuntimeException(ContactNumbers contactNumbers) {
		contactNumberRepository.save(contactNumbers);
		throw new RuntimeException();
	}
	
	
}
