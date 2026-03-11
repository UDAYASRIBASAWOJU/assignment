package com.lpu.eCommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {

	@Id
	private int product_id;
	
	private String product_name;
	
	@ManyToMany
	private List<Orders> orders;
	
	@ManyToOne
	private Categories categories;

	public Products() {

	}

	public Products(int product_id, String product_name, List<Orders> orders, Categories categories) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.orders = orders;
		this.categories = categories;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public List<Orders> getOrder() {
		return orders;
	}

	public void setOrder(List<Orders> orders) {
		this.orders = orders;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
}
