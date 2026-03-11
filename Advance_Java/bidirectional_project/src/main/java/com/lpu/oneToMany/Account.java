package com.lpu.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	
	@Id
	private int id;
	
	private String name;
	private double balance;
	
	@JoinColumn
	@ManyToOne
	private Bank bank;

	public Account() {

	}

	public Account(int id, String name, double balance, Bank bank) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.bank = bank;
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

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
