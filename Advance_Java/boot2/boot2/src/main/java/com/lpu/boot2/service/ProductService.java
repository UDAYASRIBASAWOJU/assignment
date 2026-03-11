package com.lpu.boot2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lpu.boot2.entity.Product;
import com.lpu.boot2.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> productPagination(int pageNumber, int size, String field) {
		Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(field).descending());
		
		return repository.findAll(pageable).getContent();
	}
	
	public List<Product> sortProductByFieldInAsc(String field) {
		return repository.findAll(Sort.by(field).ascending());
	}
	
	public List<Product> sortProductByFieldInDsc(String field) {
		return repository.findAll(Sort.by(field).descending());
	}
}
