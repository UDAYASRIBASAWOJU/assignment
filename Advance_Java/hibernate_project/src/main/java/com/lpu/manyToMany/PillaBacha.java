package com.lpu.manyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class PillaBacha {

	@Id
	private int id;
	
	private String name;
	private long phone;
	
	@ManyToMany
	private List<Subject> subjects;

	public PillaBacha() {

	}

	public PillaBacha(int id, String name, long phone, List<Subject> subjects) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.subjects = subjects;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}	
	
}