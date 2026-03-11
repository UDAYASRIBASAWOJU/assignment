package com.lpu.carEngineOTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EngineCRUD {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveEngine(Engine e) {
		et.begin();
		em.persist(e);
		et.commit();
		
		System.out.println("Engine Saved");
	}

	public void deleteEngine(int id) {
		Engine e = em.find(Engine.class, id);
		
		et.begin();
		em.remove(e);
		et.commit();
		
		System.out.println("Car Deleted");
	}
	
	public void findEngine(int id) {
		Engine e = em.find(Engine.class, id);
		
		System.out.println("Car Found : " +e.getId() + " " + e.getCc());
	}
}
