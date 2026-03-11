package com.lpu.autoWiredAnnotation.personAadhar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	@Value("13")
	private int id;
	
	@Value("Mr.Bean")
	private String name;
	
	@Autowired   //field injection
	private Aadhar aadhar;
	
	//@Qualifier(value = "carr")    //@Qualifer(value = "bike")
	@Autowired
	private Vehicle v;
	
	@Autowired
	private Fruit fruit;
	
	public Person(){
		
	}
	
	//@Autowired    // - even though if you did not mention Autowired, it will automatically mark Autowired internally
	public Person(Aadhar aadhar, Vehicle v) {    //if you another constructor, then it is mandatory to use Autowired annotation
		this.aadhar = aadhar;
		this.v = v;
	}

	//@Autowired    // - Setter injection
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
		
	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public Vehicle getV() {
		return v;
	}

	public void setV(Vehicle v) {
		this.v = v;
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

	public Aadhar getAadhar() {
		return aadhar;
	}
}
