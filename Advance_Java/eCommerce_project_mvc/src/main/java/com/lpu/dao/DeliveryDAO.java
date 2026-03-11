package com.lpu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Delivery;
import com.lpu.entity.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class DeliveryDAO {
	@Autowired
	private EntityManagerFactory emf;
	
	public Delivery addCustomer(Delivery del) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(del);
		et.commit();
		em.close();
		
		return del;
	}

	public Delivery getDeliveryById(int delivery_id) {
		EntityManager em = emf.createEntityManager();
		
		Delivery del = em.find(Delivery.class, delivery_id);
		
		em.close();
		
		return del;
	}

	public void deleteDelivery(int delivery_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Delivery del = em.find(Delivery.class, delivery_id);
		
		et.begin();
		if(del != null) {
			em.remove(del);
		}
		et.commit();
		em.close();
	}

	public void assignOrderToDelivery(int delivery_id, Orders order) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Delivery del = em.find(Delivery.class, delivery_id);
	
		et.begin();
		
		if (del == null) 
			return;
		
		order.setDelivery(del);
		del.getOrders().add(order);
		
		em.persist(order);
		
		et.commit();
		em.close(); 
	}

	public List<Orders> viewOrdersByDelivery(int delivery_id) {
		EntityManager em = emf.createEntityManager();
		
		Delivery del = em.find(Delivery.class, delivery_id);
		
		return del.getOrders();
	}
}
