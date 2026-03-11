package com.lpu.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Bank {
	
	@Id
	private int id;
	
	private String name;
	private String location;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Account> accounts;
	
	public Bank(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
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

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}
	
	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Account> getAccount() {
		return accounts;
	}
	public Bank() {
		
	}
}