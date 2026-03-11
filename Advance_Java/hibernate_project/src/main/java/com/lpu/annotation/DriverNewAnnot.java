package com.lpu.annotation;

import java.util.ArrayList;
import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DriverNewAnnot {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Studentt s1 = new Studentt();
		s1.setName("iuytres");
		s1.setAge(76);
		s1.setSubjects(new ArrayList<String>(Arrays.asList("SQL", "Java", "Adv_Java")));
		s1.setAddress(new Addresss("Hyd", 500034, "TS"));
		s1.setStudentId(new StudentId(56787654, "ufdfghjk@gmail.com"));
		
		et.begin();
		em.persist(s1);
		et.commit();
		em.close();
	}
}
