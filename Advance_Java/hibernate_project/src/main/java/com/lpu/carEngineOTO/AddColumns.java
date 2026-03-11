package com.lpu.carEngineOTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddColumns {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
		e.setId(12);
		e.setCc(2000);
				
		Car c = new Car();
		c.setId(34);
		c.setBrand("Thar");
		c.setEngine(e);
		
		et.begin();
		em.persist(c);
		em.persist(e);
		et.commit();
	}
}
