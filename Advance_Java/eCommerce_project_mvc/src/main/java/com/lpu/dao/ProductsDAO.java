package com.lpu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Categories;
import com.lpu.entity.Orders;
import com.lpu.entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class ProductsDAO {
	@Autowired
	private EntityManagerFactory emf;
	
	public Products addProduct(Products prod) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(prod);
		et.commit();
		em.close();
		
		return prod;
	}

	public Products getProductById(int product_id) {
		EntityManager em = emf.createEntityManager();
		
		Products prod = em.find(Products.class, product_id);
		
		em.close();
		
		return prod;
	}

	public void deleteProduct(int product_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Products prod = em.find(Products.class, product_id);
		
		et.begin();
		if(prod != null) {
			em.remove(prod);
		}
		et.commit();
		em.close();
	}
	
	public void assignCategoryToProduct(int product_id, Categories category) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Products prod = em.find(Products.class, product_id);
	
		et.begin();
		
		if (prod == null) 
			return;
		
		category.getProducts().add(prod);
		prod.setCategories(category);
		
		em.persist(category);
		
		et.commit();
		em.close(); 
	}

	public void assignOrderToProduct(int product_id, Orders order) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Products prod = em.find(Products.class, product_id);
	
		et.begin();
		
		if (prod == null) 
			return;
		
		order.getProducts().add(prod);
		prod.getOrders().add(order);
		
		em.persist(order);
		
		et.commit();
		em.close(); 
	}
	
	public Categories viewCategoryByProduct(int product_id) {
		EntityManager em = emf.createEntityManager();
		
		Products prod = em.find(Products.class, product_id);
		
		return prod.getCategories();
	}

	public List<Orders> viewOrdersByProduct(int product_id) {
		EntityManager em = emf.createEntityManager();
		
		Products prod = em.find(Products.class, product_id);
		
		return prod.getOrders();
	}
}
