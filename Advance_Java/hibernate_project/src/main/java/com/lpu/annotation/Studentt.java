package com.lpu.annotation;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Studentt {
	
	@EmbeddedId
	private StudentId studentId;
	
	private String name;
	private int age;
	
	@ElementCollection            //it creates table
	private List<String> subjects;
	
	@Embedded     
	private Addresss address;
	
	public StudentId getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}

	public Addresss getAddress() {
		return address;
	}

	public void setAddress(Addresss address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
}
