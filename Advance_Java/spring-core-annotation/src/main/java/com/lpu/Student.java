package com.lpu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")    //if we doesn't provide value, it gives default name as class name with start letter small(here student)
public class Student {
	@Value("101")
	private int id;
	
	@Value("XYZ")
	private String name;
	
	public void study() {
		System.out.println("Sleeping");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}