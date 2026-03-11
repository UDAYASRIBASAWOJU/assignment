package com.lpu.oneToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {

	@Id
	private int id;
	
	private String name;
	private String location;
	
	@OneToMany(mappedBy = "bank")
	private List<Account> acounts;
	
	public Bank() {

	}

	public Bank(int id, String name, String location, List<Account> acounts) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.acounts = acounts;
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

	public List<Account> getAcounts() {
		return acounts;
	}

	public void setAcounts(List<Account> acounts) {
		this.acounts = acounts;
	}
}
