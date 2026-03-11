package com.lpu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Customer;
import com.lpu.entity.Delivery;
import com.lpu.entity.Orders;
import com.lpu.entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class OrdersDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public Orders addOrder(Orders ord) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(ord);
		et.commit();
		em.close();
		
		return ord;
	}

	public Orders getOrderById(int order_id) {
		EntityManager em = emf.createEntityManager();
		
		Orders ord = em.find(Orders.class, order_id);
		
		em.close();
		
		return ord;
	}

	public void deleteOrder(int order_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders ord = em.find(Orders.class, order_id);
		
		et.begin();
		if(ord != null) {
			em.remove(ord);
		}
		et.commit();
		em.close();
	}

	public void assignDeliveryToOrder(int order_id, Delivery del) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders ord = em.find(Orders.class, order_id);
	
		et.begin();
		
		if (ord == null) 
			return;
		
		del.getOrders().add(ord);
		ord.setDelivery(del);
		
		em.persist(del);
		
		et.commit();
		em.close(); 
	}
	
	public void assignCustomerToOrder(int order_id, Customer cus) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders ord = em.find(Orders.class, order_id);
	
		et.begin();
		
		if (ord == null) 
			return;
		
		cus.getOrders().add(ord);
		ord.setCustomer(cus);
		
		em.persist(cus);
		
		et.commit();
		em.close(); 
	}
	
	public void assignProductToOrder(int order_id, Products product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders ord = em.find(Orders.class, order_id);
	
		et.begin();
		
		if (ord == null) 
			return;
		
		product.getOrder().add(ord);
		ord.getProducts().add(product);
		
		em.persist(product);
		
		et.commit();
		em.close(); 
	}
	
	public Delivery viewDeliveryByOrder(int order_id) {
		EntityManager em = emf.createEntityManager();
		
		Orders ord = em.find(Orders.class, order_id);
		
		return ord.getDelivery();
	}
	
	public Customer viewCustomerByOrder(int order_id) {
		EntityManager em = emf.createEntityManager();
		
		Orders ord = em.find(Orders.class, order_id);
		
		return ord.getCustomer();
	}

	public List<Products> viewProductsByOrder(int order_id) {
		EntityManager em = emf.createEntityManager();
		
		Orders ord = em.find(Orders.class, order_id);
		
		return ord.getProducts();
	}
}
