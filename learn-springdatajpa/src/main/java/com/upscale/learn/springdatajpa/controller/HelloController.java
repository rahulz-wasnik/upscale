package com.upscale.learn.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upscale.learn.springdatajpa.entity.Airport;
import com.upscale.learn.springdatajpa.entity.Random;
import com.upscale.learn.springdatajpa.repository.AirportRepository;
import com.upscale.learn.springdatajpa.repository.RandomRepository;


@RestController
public class HelloController {
	
	@Autowired
	private RandomRepository randomRepository;
	
	@Autowired
	private AirportRepository airportRepository;

    @GetMapping(path = "/hello", produces = "text/plain")
    public String hello() {
        return "Hello, Welcome to expirimenting with spring data jpa!!";
    }

 
    @PostMapping(path = "/random")
    public void random() {
        randomRepository.save(new Random("Red", "java_only_trainsent_field", "persistent_only_field"));
    }
    
    @PostMapping(path = "/airport")
    public void airport() {
    	airportRepository.save(new Airport("Mumbai"));
    }
}
