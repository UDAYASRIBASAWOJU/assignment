package com.lpu.eCommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	private int order_id;
	
	private int order_date;
	
	@ManyToOne
	private Delivery delivery;
	
	@JoinColumn
	@ManyToOne
	private Customer customer;
	
	@ManyToMany(mappedBy = "orders")
	private List<Products> products;

	public Orders() {

	}

	public Orders(int order_id, int order_date, Delivery delivery, Customer customer) {
		this.order_id = order_id;
		this.order_date = order_date;
		this.delivery = delivery;
		this.customer = customer;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_date() {
		return order_date;
	}

	public void setOrder_date(int order_date) {
		this.order_date = order_date;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
