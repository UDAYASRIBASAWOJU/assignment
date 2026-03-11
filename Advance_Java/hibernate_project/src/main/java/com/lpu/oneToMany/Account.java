package com.lpu.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	private int id;
	
	private String name;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
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
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
}
