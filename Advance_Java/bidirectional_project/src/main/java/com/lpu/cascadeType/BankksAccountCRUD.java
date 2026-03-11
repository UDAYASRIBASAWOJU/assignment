package com.lpu.cascadeType;

import java.util.List;

public interface BankksAccountCRUD {
	void saveBank(Bankks bank);
	
	void updateBank(int id);
	
	Bankks findByBankId(int id);
	
	Bankks findBankByName(String name);
	
	void assignAccountToBank(int bankId, Accounts newAccount);
	
	void assignAccountToBank(int bankId, List<Accounts> accounts);
	
	List<Accounts> findAllAccountsInBank(int bankId);
}
