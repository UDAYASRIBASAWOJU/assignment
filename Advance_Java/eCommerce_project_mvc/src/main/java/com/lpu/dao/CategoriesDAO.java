package com.lpu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Categories;
import com.lpu.entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CategoriesDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public Categories addCategory(Categories catg) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(catg);
		et.commit();
		em.close();
		
		return catg;
	}

	public Categories getCateoryById(int category_id) {
		EntityManager em = emf.createEntityManager();
		
		Categories catg = em.find(Categories.class, category_id);
		
		em.close();
		
		return catg;
	}

	public void deleteCategory(int category_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Categories catg = em.find(Categories.class, category_id);
		
		et.begin();
		if(catg != null) {
			em.remove(catg);
		}
		et.commit();
		em.close();
	}

	public void assignProductToCategory(int category_id, Products product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Categories catg = em.find(Categories.class, category_id);
	
		et.begin();
		
		if (catg == null) 
			return;
		product.setCategories(catg);;
		catg.getProducts().add(product);
		
		em.persist(product);
		
		et.commit();
		em.close(); 
	}

	public List<Products> viewProductsByCategory(int category_id) {
		EntityManager em = emf.createEntityManager();
		
		Categories catg = em.find(Categories.class, category_id);
		
		return catg.getProducts();
	}
}
