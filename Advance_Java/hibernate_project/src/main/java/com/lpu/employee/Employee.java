package com.lpu.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int id;
	private String name;
	private double sal;
	private long phone;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public double getSal() {
		return sal;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public long getPhone() {
		return phone;
	}
}
