package com.lpu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long phone;
	private String email;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
