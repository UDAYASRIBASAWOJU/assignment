package com.lpu.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonAadharDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person person = new Person();
		person.setId(10);
		person.setName("A");
		
		Aadhar aadhar = new Aadhar();
		aadhar.setId(101);
		aadhar.setLocation("India");
		
		person.setAadhar(aadhar);
		aadhar.setPerson(person);
		
		et.begin();
		em.persist(aadhar);
		em.persist(person);
		et.commit();
	}

}
