package com.lpu.annotation;

import jakarta.persistence.Embeddable;

@Embeddable
public class Addresss {
	private String city;
	private int pin;
	private String state;
	
	public Addresss() {
		
	}

	public Addresss(String city, int pin, String state) {
		this.city = city;
		this.pin = pin;
		this.state = state;
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
