package com.lpu.cascadeType;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bankks {

	@Id
	private int id;
	
	private String name;
	
	private String location;
	
	@OneToMany(mappedBy = "bank", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Accounts> accounts;

	public Bankks() {

	}

	public Bankks(int id, String name, String location, List<Accounts> accounts) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.accounts = accounts;
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

	public List<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + location;
	}
}
