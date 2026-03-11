package com.lpu.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateStudent {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		
		Student s = em.find(Student.class, 12);
		s.setName("hgfnbvc");
		
		et.begin();
		em.merge(s);
		et.commit();
		
		System.out.println("Updated");
	}

}
