package com.lpu.carEngineOTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engine {

	@Id
	private int id;
	
	private int cc;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	public int getCc() {
		return cc;
	}
}
