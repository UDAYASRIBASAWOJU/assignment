package com.lpu.security2.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.security2.entity.Customer;
import com.lpu.security2.repository.CustomerRepo;

@Service
public class CustomerService {

	private final CustomerRepo repo;
	
	private final PasswordEncoder passEncoder;
	
	public CustomerService(CustomerRepo repo, PasswordEncoder passEncoder) {
		this.repo = repo;
		this.passEncoder = passEncoder;
	}

	public Customer registerCustomer(Customer customer) {
		
		String encodedPass =  passEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPass);
		
		return repo.save(customer);
	}
	
	@PostAuthorize("returnObject.name == authentication.name")
	public Customer findCustomerById(int id) {
		return repo.findById(id).get();
	}
	
	
	public void deleteCustomer(int id) {
		repo.deleteById(id);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}
}
