package com.lpu.autoWiredAnnotation.studentId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
public class Student {
	
	@Value("19")
	private int id;
	
	@Value("Abc")
	private String name;
	
	private IdCard idCard;

	public Student() {

	}

	@Autowired
	public Student(IdCard idCard) {
		this.idCard = idCard;
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

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
}
