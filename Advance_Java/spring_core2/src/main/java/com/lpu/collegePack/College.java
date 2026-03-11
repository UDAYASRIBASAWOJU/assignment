package com.lpu.collegePack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {
	@Value("102")
	private int id;
	
	private String name;
	private String location;
	private String dept;

//	public College() {
//
//	}
	
	public College(@Value("Elsa")String name, @Value("Hyd")String location) {
		this.name = name;
		this.location = location;
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
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDept() {
		return dept;
	}
	
	@Value("CSE")
	public void setDept(String dept) {
		this.dept = dept;
	}
}
