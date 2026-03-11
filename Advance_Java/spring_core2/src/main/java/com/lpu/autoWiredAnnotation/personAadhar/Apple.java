package com.lpu.autoWiredAnnotation.personAadhar;

import org.springframework.stereotype.Component;

@Component
public class Apple implements Fruit{
	
	@Override
	public void eat() {
		System.out.println("Eat Apple");
	}
}
