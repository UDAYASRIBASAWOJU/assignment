package com.lpu.annotation;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentId {
	private long phone;
	private String email;
	
	public StudentId(long phone, String email) {
		this.phone = phone;
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
