package com.lpu.cascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Accounts {

	@Id
	private int id;
	
	private String name;
	private double balance;
	
	@JoinColumn
	@ManyToOne
	private Bankks bank;
	
	
	public Accounts() {

	}

	public Accounts(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
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
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bankks getBank() {
		return bank;
	}

	public void setBank(Bankks bank) {
		this.bank = bank;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + balance;
	}
}
