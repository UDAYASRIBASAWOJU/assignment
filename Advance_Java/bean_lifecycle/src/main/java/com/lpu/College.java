package com.lpu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class College {
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String location;
	
	public College() {

	}

	public College(int id, String name, String location) {
		this.id = id;
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
}
