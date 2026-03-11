package com.lpu.autoWiredAnnotation.personAadhar;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	
	@Override
	public void start() {
		System.out.println("Car started");
	}
}
