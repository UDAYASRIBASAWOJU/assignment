package com.lpu.manyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DriverEmpCom {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		Company company = new Company(101, "Capg", "Hyd");
//		
//		Employeee e1 = new Employeee(10, "A", 1209.00, company);
//		Employeee e2 = new Employeee(11, "B", 7654.8, company);
//		
//		et.begin();
//		em.persist(e1);
//		em.persist(e2);
//		em.persist(company);
//		et.commit();
		
		Employeee e1 = em.find(Employeee.class, 10);
		System.out.println(e1.getId() + " " + e1.getName() + " " + e1.getCompany().getName());
	}

}