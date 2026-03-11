package com.lpu;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Component
public class BeanLifeCycle2 {
	
	private EntityManagerFactory emf;
	
	public BeanLifeCycle2() {
		System.out.println("Instantiation");
	}
	
	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory("dev");
		System.out.println("Initialization");
	}
	
	public void fetchData() {
		EntityManager em = emf.createEntityManager();
		
		College c = em.find(College.class, 111);
		
		System.out.println(c.getName());
		System.out.println("use bean object");
	}
	
	@PreDestroy
	public void closeEMF() {
		emf.close();
		System.out.println("Pre Destroy");
	}
	
}
