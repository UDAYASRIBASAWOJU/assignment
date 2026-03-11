package com.lpu.manyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	private int id;
	
	private String name;
	private String trainer;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;

	public Subject() {

	}

	public Subject(int id, String name, String trainer, List<Student> students) {

		this.id = id;
		this.name = name;
		this.trainer = trainer;
		this.students = students;
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

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
