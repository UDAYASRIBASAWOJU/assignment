package com.lpu.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdatePerson {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p = em.find(Person.class, 10);
		p.setName("Semya");
		
		Aadhar a = p.getAadhar();
		a.setLocation("India");
		

		et.begin();
		em.merge(p);
		em.merge(a);
		et.commit();
	}
}