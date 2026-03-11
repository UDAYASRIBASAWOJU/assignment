package com.lpu.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveStudent {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager(); //crud
		EntityTransaction et = em.getTransaction();   //DML
		
		Student s1 = new Student();
		s1.setStudentId(12);
		s1.setName("Def");
		s1.setPhone(98765);
		
		Student s2 = new Student();
		s2.setStudentId(14);
		s2.setName("Bcd");
		s2.setPhone(878654);
		
		et.begin();      //it will start the transaction
		em.persist(s1);  //methods call - save method
		em.persist(s2);
		et.commit();     //it will save the transaction
	}
}