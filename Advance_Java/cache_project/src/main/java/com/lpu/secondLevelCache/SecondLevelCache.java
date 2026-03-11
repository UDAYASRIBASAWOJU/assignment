package com.lpu.secondLevelCache;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SecondLevelCache {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		Student s1 = new Student(11, "kaju");
		transaction.begin();
		em.persist(s1);
		transaction.commit();

		Student s2 = em.find(Student.class, 10); // DB hit , so only Here, Hibernate creates Query
		System.out.println(s2);
		Student s3 = em.find(Student.class, 10); // first level cache
		System.out.println(s3);
		s3.setName("kuti");

		transaction.begin();
		em.merge(s3);
		transaction.commit();

		EntityManager em1 = emf.createEntityManager();

		Student s4 = em1.find(Student.class, 10); // second level cache
		System.out.println(s4);

		s4.setName("roti");

		transaction.begin();
		em.merge(s4);
		transaction.commit();

		Student s5 = em1.find(Student.class, 10); // second level cache
		System.out.println(s5);

	}
}