package com.upscale.learn.springdatajpa.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UnderstandingCommandLiner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.err.println("hey i am the command liner");
	}

}
