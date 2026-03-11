package com.lpu.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindStudent {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		
		Student s = em.find(Student.class, 14);
		System.out.println(s.getStudentId() + " " + s.getName() + " " + s.getPhone());
	}

}
