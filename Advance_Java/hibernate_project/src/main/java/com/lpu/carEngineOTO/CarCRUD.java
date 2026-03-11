package com.lpu.carEngineOTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CarCRUD {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void  saveCar(Car c) {
		et.begin();
		em.persist(c);
		et.commit();
		
		System.out.println("Car Saved");
	}
	
	public void updateCar(int id) {
		Car c = em.find(Car.class, id);
		c.setBrand("Kia");
		
		et.begin();
		em.merge(c);
		et.commit();
		
		System.out.println("Car Updated");
	}
	
	public void deleteCar(int id) {
		Car c = em.find(Car.class, id);
		
		et.begin();
		em.remove(c);
		et.commit();
		
		System.out.println("Car Deleted");
	}
	
	public void findCar(int id) {
		Car c = em.find(Car.class, id);
		
		System.out.println("Car Found : " +c.getId() + " " + c.getBrand());
	}
	
	public void findByBrand(String brand) {
		Query query = em.createQuery("select c from Car c where c.brand =: cBrand");
		query.setParameter("cBrand", brand);
		
		System.out.println(query.getResultList());
	}
	
//	public void findAll() {
//		
//	}
}
