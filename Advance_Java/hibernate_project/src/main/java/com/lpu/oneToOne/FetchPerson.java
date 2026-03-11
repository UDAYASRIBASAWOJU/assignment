package com.lpu.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchPerson {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Person p = em.find(Person.class, 10);
		
		System.out.println(p + " " + p.getId() + " " + p.getName());
		
//		Aadhar a = p.getAadhar();
//	
//		System.out.println(a.getId() + " " + a.getLocation());
	}
}
