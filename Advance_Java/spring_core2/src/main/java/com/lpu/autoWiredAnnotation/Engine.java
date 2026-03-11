package com.lpu.autoWiredAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Component(value="engine")
@Entity
public class Engine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	@OneToOne(mappedBy="engine",fetch=FetchType.LAZY)
	private Carr car;
	
	
	public Engine() {
		super();
	}
	
	@Autowired
	public Engine(@Value("KARO") String type) {
		super();
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "Engine [id=" + id + ", type=" + type + "]";
	}

}