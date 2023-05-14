package com.upscale.learn.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upscale.learn.springdatajpa.entity.ContactNumbers;
import com.upscale.learn.springdatajpa.repository.ContactNumberRepository;

@Service
public class ContactNumberServiceImpl {

	@Autowired
	private ContactNumberRepository contactNumberRepository;
	
	public ContactNumbers save(ContactNumbers contactNumbers) {
		return contactNumberRepository.save(contactNumbers);
	}
}
