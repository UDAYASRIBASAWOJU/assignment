package com.lpu.security2.controller;

import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.security2.entity.Customer;
import com.lpu.security2.service.CustomerService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return service.registerCustomer(customer);
	}
	
	@GetMapping("/csrf")
	public CsrfToken csrfToken(CsrfToken token) {
		return token;
	}
	
	@GetMapping("/public")
	public String homePage() {
		return "Public Page";
	}
	
	@GetMapping("/account")
	public String accountPage() {
		return "Account Page";
	}
	
	@GetMapping("/delete") //only accessed for admin from config
	public String deletePage() {
		return "Delete Page";
	}
	
	@GetMapping("/update") //only accessed for admin from config
	public String updatePage() {
		return "Update Page";
	}
	
	@GetMapping("/find/{id}")
	public Customer findById(@PathVariable int id) {
		return service.findCustomerById(id);
	}
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers() {
		return service.findAllCustomers();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteCustomer(id);
		return id + " deleted";
	}
	
}
