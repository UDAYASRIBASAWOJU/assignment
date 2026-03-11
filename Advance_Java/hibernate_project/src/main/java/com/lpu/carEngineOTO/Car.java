package com.lpu.carEngineOTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Car {

	@Id
	private int id;
	
	private String brand;
	
	@OneToOne
	private Engine engine;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public Engine getEngine() {
		return engine;
	}
}
