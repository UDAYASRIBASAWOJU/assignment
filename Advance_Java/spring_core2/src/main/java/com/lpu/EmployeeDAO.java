package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class EmployeeDAO {
	@Autowired
	private EntityManagerFactory emf; 
	
	public Employee SaveEmployee(Employee e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(e);
		et.commit();
		em.close();
		
		return e;
	}

}
