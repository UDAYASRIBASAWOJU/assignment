package com.lpu.eCommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Delivery {
	
	@Id
	private int delivery_id;
	
	private String type;
	
	private String status;
	
	@OneToMany(mappedBy = "delivery")
	private List<Orders> orders;

	public Delivery() {

	}

	public Delivery(int delivery_id, String type, String status) {
		this.delivery_id = delivery_id;
		this.type = type;
		this.status = status;
	}

	public int getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
