package com.lpu;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myEmployee")
public class Employee {
	//@Value("19")
	private int id;
	
	//@Value("Udaya")
	private String name;
	
	//@Value("Robotics")
	private String dept;
	
	public Employee() {

	}

	public Employee(int id, String name, String dept) { //Employee(@Value("8")int id,@Value("udaya") String name, String dept)
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	//@Value("30")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	//@Value("Tom")
	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	//@Value("Cartoon")
	public void setDept(String dept) {
		this.dept = dept;
	}
}
