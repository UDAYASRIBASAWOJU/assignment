package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.CustomerDAO;
import com.lpu.entity.Customer;
import com.lpu.entity.Orders;

@Component
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	public Customer addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}
	
	public Customer getCustomerById(int id) {
		Customer cus = customerDAO.getCustomerById(id);
		
		if(cus == null) {
			throw new IllegalArgumentException("Customer not found");
		}
		
		return cus;
	}
	
	public void deleteCustomerbyId(int id) {
		customerDAO.deleteCustomer(id);
	}
	
	public Customer checkLogin(String email, long phone) {
		return customerDAO.checkLogin(email, phone);
	}
	
	public void assignOrderToCustomer(int id, Orders order) {
		customerDAO.assignOrderToCustomer(id, order);
	}
	
	public List<Orders> viewOrdersByCustomer(int id){
		return customerDAO.viewOrdersByCustomer(id);
	}
}
