package com.lpu.oneToMany;

import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankAccountDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank bank = new Bank();
		bank.setId(101);
		bank.setName("SBI");
		bank.setLocation("Hyd");
		
		Account account1 = new Account();
		account1.setId(10);
		account1.setName("A");
		account1.setBalance(500);
		
		Account account2 = new Account();
		account2.setId(11);
		account2.setName("B");
		account2.setBalance(1500);
		
		bank.setAcounts(Arrays.asList(account1, account2));
		
		account1.setBank(bank);
		account2.setBank(bank);
		 
		et.begin();
		em.persist(account1);
		em.persist(account2);
		em.persist(bank);
		et.commit();
	}
}
