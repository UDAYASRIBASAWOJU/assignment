package com.lpu.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeletePerson {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p = em.find(Person.class, 10);
		
		Aadhar a = p.getAadhar();
		

		et.begin();
		em.remove(p);
		em.remove(a);
		et.commit();
	}
}
