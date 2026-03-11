package com.lpu.oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Aadhar {
	
	@Id
	private int id;
	
	private String location;
	
	@OneToOne(mappedBy = "aadhar")
	private Person person;

	public Aadhar() {
		
	}

	public Aadhar(int id, String location, Person person) {
		this.id = id;
		this.location = location;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
