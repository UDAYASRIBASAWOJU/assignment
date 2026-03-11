package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.DeliveryDAO;
import com.lpu.entity.Delivery;
import com.lpu.entity.Orders;

@Component
public class DeliveryService {
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	public Delivery addDelivery(int delivery_id, String type, String status) {
		Delivery del = new Delivery(delivery_id, type, status);
		
		return deliveryDAO.addCustomer(del);
	}
	
	public Delivery getDeliveryById(int delivery_id) {
		Delivery del = deliveryDAO.getDeliveryById(delivery_id);
		
		if(del == null) {
			throw new IllegalArgumentException("Delivery not found");
		}
		
		return del;
	}
	
	public void deleteDeliverybyId(int delivery_id) {
		deliveryDAO.deleteDelivery(delivery_id);
	}
	
	public void assignOrderToDelivery(int delivery_id, Orders order) {
		deliveryDAO.assignOrderToDelivery(delivery_id, order);
	}
	
	public List<Orders> viewOrdersByDelivery(int delivery_id){
		return deliveryDAO.viewOrdersByDelivery(delivery_id);
	}
}
