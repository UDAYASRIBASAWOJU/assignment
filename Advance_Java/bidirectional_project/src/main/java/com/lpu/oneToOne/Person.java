package com.lpu.oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	private int id;
	
	private String name;
	
	@JoinColumn
	@OneToOne
	private Aadhar aadhar;
	
	public Person() {

	}

	public Person(int id, String name, Aadhar aadhar) {
		this.id = id;
		this.name = name;
		this.aadhar = aadhar;
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

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	
	
}
