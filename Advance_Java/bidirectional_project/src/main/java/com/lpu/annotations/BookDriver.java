package com.lpu.annotations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BookDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Book book = new Book();
		//Book book = em.find(Book.class, 1);
		//book.setName("Na Life");
		//book.setAuthor("Udaya");
		book.setName("Mundhu ni subjects sadhuko");
		
		et.begin();
		em.merge(book);
		et.commit();
	}

}
