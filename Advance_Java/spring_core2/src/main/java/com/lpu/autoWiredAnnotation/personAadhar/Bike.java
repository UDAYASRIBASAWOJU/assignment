package com.lpu.autoWiredAnnotation.personAadhar;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Bike implements Vehicle{

	public void start() {
		System.out.println("Bike Started");
	}
}
