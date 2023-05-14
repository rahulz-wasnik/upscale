package com.upscale.learn.springdatajpa.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.upscale.learn.springdatajpa.entity.Address;
import com.upscale.learn.springdatajpa.entity.ContactNumbers;
import com.upscale.learn.springdatajpa.entity.User;
import com.upscale.learn.springdatajpa.service.UnderstandingRollbackImpl;

@RestController
@RequestMapping(path = "/rollback")
public class UnderstandingRollbackController {

	@Autowired
	private UnderstandingRollbackImpl service;
	
	@Autowired
	private Faker faker;
	
	@PostMapping(path = "/normalSave")
    public void normalSave() throws SQLException {
		System.out.println("\n");
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.normalSave(user);
    }
	

	@PostMapping(path = "/saveWithCheckedExceptionAndRollback")
    public void saveWithCheckedExceptionAndRollback() throws SQLException {
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.saveWithCheckedExceptionAndRollback(user);
    }
	
	@PostMapping(path = "/saveWithTryCatch")
    public void saveWithTryCatch() {
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.saveWithTryCatch(user);
    }
	
	@PostMapping(path = "/nestedSave")
    public void nestedSave() {
		System.out.println("\n");
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.nestedSaveWithPropagtionLevelAsNested(user);
    }
	
	@PostMapping(path = "/nestedSaveWithPropagtionLevelAsNested")
    public void nestedSaveWithPropagtionLevelAsNested() {
		System.out.println("\n");
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.nestedSaveWithPropagtionLevelAsNested(user);
    }
	
	@PostMapping(path = "/nestedSaveWithPropagationAsRequiredNew")
    public void nestedSaveWithPropagationAsRequiredNew() {
		System.out.println("\n");
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.nestedSaveWithPropagationAsRequiredNew(user);
    }
	
	@PostMapping(path = "/nestedSaveWithPropagationAsSupported")
	public void nestedSaveWithPropagationAsSupported() {
		System.out.println("\n");
		
		User user = new User(
				faker.name().firstName(), 
				faker.name().lastName(),
				null,
				null);
		
		service.nestedSaveWithPropagationAsSupported(user);
	}
}
