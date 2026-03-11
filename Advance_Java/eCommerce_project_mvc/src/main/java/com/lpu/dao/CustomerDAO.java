package com.lpu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Customer;
import com.lpu.entity.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Component
public class CustomerDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public Customer addCustomer(Customer cus) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(cus);
		et.commit();
		em.close();
		
		return cus;
	}

	public Customer getCustomerById(int id) {
		EntityManager em = emf.createEntityManager();
		
		Customer cus = em.find(Customer.class, id);
		
		em.close();
		
		return cus;
	}

	public void deleteCustomer(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer cus = em.find(Customer.class, id);
		
		et.begin();
		if(cus != null) {
			em.remove(cus);
		}
		et.commit();
		em.close();
	}
	
	public Customer checkLogin(String email, long phone) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
	        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.email=:email and c.phone=:phone", Customer.class);

	        query.setParameter("email", email);
	        query.setParameter("phone", phone);

	        return query.getSingleResult();

	    } catch (NoResultException e) {
	        return null; // login failed
	    } finally {
	        em.close();
	    }
	}

	public void assignOrderToCustomer(int id, Orders order) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer cus = em.find(Customer.class, id);
	
		et.begin();
		
		if (cus == null) 
			return;
		
		order.setCustomer(cus);;
		cus.getOrders().add(order);
		
		em.persist(order);
		
		et.commit();
		em.close(); 
	}

	public List<Orders> viewOrdersByCustomer(int id) {
		EntityManager em = emf.createEntityManager();
		
		Customer cus = em.find(Customer.class, id);
		
		return cus.getOrders();
	}
}
