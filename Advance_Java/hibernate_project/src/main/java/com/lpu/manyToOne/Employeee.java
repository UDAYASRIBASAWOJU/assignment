package com.lpu.manyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employeee {
	
	@Id
	private int id;
	
	private String name;
	private double sal;
	
	@ManyToOne
	private Company company;
	
	public Employeee() {
		
	}

	public Employeee(int id, String name, double sal, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.company = company;
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

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
