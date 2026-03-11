package com.lpu.autoWiredAnnotation.personAadhar;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Mango implements Fruit{
	
	@Override
	public void eat() {
		System.out.println("Eat Apple");
	}

}
