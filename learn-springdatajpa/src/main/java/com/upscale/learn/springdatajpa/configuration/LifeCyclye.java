package com.upscale.learn.springdatajpa.configuration;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class LifeCyclye implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("Lifecycle start");

	}

	@Override
	public void stop() {
		System.out.println("Lifecycle end");

	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

}
