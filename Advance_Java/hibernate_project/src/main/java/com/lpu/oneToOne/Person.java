package com.lpu.oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	private long id;
	
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Aadhar aadhar;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	
	public Aadhar getAadhar() {
		return aadhar;
	}
}