package com.lpu.autoWiredAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Component(value = "carr")
@Entity
public class Carr {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String brand;

	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	private Engine engine;

	@Autowired
	public Carr(@Value("AUDI") String brand, Engine engine) {
		this.brand = brand;
		this.engine = engine;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", engine=" + engine + "]";
	}
}
