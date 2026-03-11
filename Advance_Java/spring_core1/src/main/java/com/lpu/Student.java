package com.lpu;

import java.util.List;

public class Student {
	private int id;
	private String name;
	private Laptop laptop;
	private List<String> subjects;
	
	public void study() {
		System.out.println("Studying");
	}
	
	public Student() {

	}

	public Student(int id, String name, Laptop laptop) {
		this.id = id;
		this.name = name;
		this.laptop = laptop;
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

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
}
