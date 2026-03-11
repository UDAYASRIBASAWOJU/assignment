package com.lpu.oneToMany;

//import java.util.ArrayList;
//import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankAccountDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		
//		Account a1 = new Account(10, "A", 130.00);
//		Account a2 = new Account(11, "B", 1600.0);
//		
//		List<Account> listAccount = new ArrayList<>();
//		
//		listAccount.add(a1);
//		listAccount.add(a2);
//		
//		Bank b = new Bank(101, "SBI", "Mohali");
//		b.setAccount(listAccount);	
		
//		et.begin();
//		em.persist(a1);
//		em.persist(a2);
//		em.persist(b);
//		et.commit();
		
//		Bank b = em.find(Bank.class, 101);
		//System.out.println(b);
//		System.out.println(b.getId() + " " + b.getName() + " " + b.getLocation());
//		for(Account a : b.getAccount()) {
//			System.out.println(a.getId() + " " + a.getName() + " " + a.getBalance());
//		}
		
		Account a = em.find(Account.class, 10);
		
		et.begin();
		em.remove(a);
		et.commit();
	}

}
