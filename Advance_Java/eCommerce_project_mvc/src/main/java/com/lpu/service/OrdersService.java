package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.OrdersDAO;
import com.lpu.entity.Customer;
import com.lpu.entity.Delivery;
import com.lpu.entity.Orders;
import com.lpu.entity.Products;

@Component
public class OrdersService {
	@Autowired
	private OrdersDAO ordersDAO;
	
	public Orders addOrder(int order_id, String order_date) {
		Orders order = new Orders(order_id, order_date);
		
		return ordersDAO.addOrder(order);
	}
	
	public Orders getOrderById(int order_id) {
		Orders order = ordersDAO.getOrderById(order_id);
		
		if(order == null) {
			throw new IllegalArgumentException("Order not found");
		}
		
		return order;
	}
	
	public void deleteOrderbyId(int order_id) {
		ordersDAO.deleteOrder(order_id);
	}
	
	public void assignDeliveryToOrder(int order_id, Delivery del) {
		ordersDAO.assignDeliveryToOrder(order_id, del);
	}
	
	public void assignCustomerToOrder(int order_id, Customer cus) {
		ordersDAO.assignCustomerToOrder(order_id, cus);
	}
	
	public void assignProductToOrder(int order_id, Products product) {
		ordersDAO.assignProductToOrder(order_id, product);
	}
	
	public Delivery viewDeliveryByOrder(int order_id){
		return ordersDAO.viewDeliveryByOrder(order_id);
	}
	
	public Customer viewCustomerByOrder(int order_id){
		return ordersDAO.viewCustomerByOrder(order_id);
	}
	
	public List<Products> viewProductsByOrder(int order_id){
		return ordersDAO.viewProductsByOrder(order_id);
	}
}
