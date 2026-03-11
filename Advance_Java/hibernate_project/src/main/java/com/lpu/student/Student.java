package com.lpu.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int studentId;
	
	private String name;
	private long phone;
	
	public Student() {
		
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public long getPhone() {
		return phone;
	}

}