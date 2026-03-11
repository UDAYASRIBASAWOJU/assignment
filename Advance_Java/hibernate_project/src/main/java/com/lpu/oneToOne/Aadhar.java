package com.lpu.oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aadhar {
	
	@Id
	private long id;
	
	private String location;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
}
