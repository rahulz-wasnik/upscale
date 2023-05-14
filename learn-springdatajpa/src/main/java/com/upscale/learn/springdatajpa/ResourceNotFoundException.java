package com.upscale.learn.springdatajpa;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Resource Not Found");
	}

}
