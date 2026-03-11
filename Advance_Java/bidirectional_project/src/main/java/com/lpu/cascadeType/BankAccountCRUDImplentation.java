package com.lpu.cascadeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class BankAccountCRUDImplentation implements BankksAccountCRUD{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public static void main(String[] args) {
		BankAccountCRUDImplentation bankAccounCRUD = new BankAccountCRUDImplentation();
		
		Accounts a1 = new Accounts(1, "A", 87654);
		Accounts a2 = new Accounts(2, "B", 765434);
//		
		List<Accounts> accounts1 = new ArrayList<>(Arrays.asList(a1, a2));
//		
//		Accounts a3 = new Accounts(5, "C", 4567);
//		Accounts a4 = new Accounts(6, "D", 76545.0);
//		Accounts a5 = new Accounts(7, "E", 345665.9);
//		
//		List<Accounts> accounts2 = new ArrayList<>(Arrays.asList(a3, a4, a5));
//		
		Bankks bank1 = new Bankks(101, "SBI", "DEL", accounts1);
//		Bankks bank2 = new Bankks(102, "HDFC", "NGKL", accounts2);
//		
//		a1.setBank(bank1);
//		a2.setBank(bank1);
//		a3.setBank(bank2);
//		a4.setBank(bank2);
//		a5.setBank(bank2);
//		
//		bankAccounCRUD.saveBank(bank1);
//		bankAccounCRUD.saveBank(bank2);
		
		
	//	bankAccounCRUD.updateBank(102);
	//	bankAccounCRUD.findByBankId(101);
	//	bankAccounCRUD.findBankByName("SBI");
		
	//	bankAccounCRUD.findAllAccountsInBank(101);
		Accounts a = new Accounts(12, "E", 6545);
		bankAccounCRUD.assignAccountToBank(101, a);
	}
	
	@Override
	public void saveBank(Bankks bank) {
		et.begin();
		em.persist(bank);
		et.commit();
		
		System.out.println("Banks and Accounts Saved");
		
	}
	
	@Override
	public void updateBank(int id) {
		Bankks bank = em.find(Bankks.class, id);
		bank.setName("ABC");
		bank.setLocation("Hyd");
		
		et.begin();
		em.merge(bank);
		et.commit();
		
		System.out.println(bank.getId() + " updated");
	}
	
	@Override
	public Bankks findByBankId(int id) {
		Bankks bank = em.find(Bankks.class, id);
		
		System.out.println(bank);
		
		return bank;
	}
	
	@Override
	public Bankks findBankByName(String name) {
		Query query = em.createQuery("select b from Bankks b where b.name = :bName");

		query.setParameter("bName", name);

		return (Bankks) query.getSingleResult();
	}
	
	@Override
	public void assignAccountToBank(int bankId, Accounts newAccount) {
		Bankks bank = em.find(Bankks.class, bankId);
		newAccount.setBank(bank);  
		
	    et.begin();
	    em.persist(newAccount);
	    et.commit();

	    System.out.println("Account assigned to bank");
		
	}
	@Override
	public void assignAccountToBank(int bankId, List<Accounts> accounts) {
	    Bankks bank = em.find(Bankks.class, bankId);

	    et.begin();
	    for (Accounts acc : accounts) {
	        acc.setBank(bank);     
	        em.persist(acc);
	    }
	    et.commit();

	    System.out.println("Accounts assigned");
		
	}
	@Override
	public List<Accounts> findAllAccountsInBank(int bankId) {
		Bankks bank = em.find(Bankks.class, bankId);
		
		System.out.println(bank.getAccounts());
		
	    return bank.getAccounts();
	}
}
