package com.lpu.boot2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot2.entity.Product;
import com.lpu.boot2.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/saveAll")
	public List<Product> saveAllProducta(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	@GetMapping("/page/{pageNumber}/{size}/{field}")
	public List<Product> productPage(@PathVariable int pageNumber, @PathVariable int size, @PathVariable String field) {
		return service.productPagination(pageNumber, size, field);
	}
	
	@GetMapping("/page/{field}")
	public List<Product> SortByFieldAsc(@PathVariable String field) {
		return service.sortProductByFieldInAsc(field);
	}
	
	@GetMapping("/pages/{field}")
	public List<Product> SortByFieldDsc(@PathVariable String field) {
		return service.sortProductByFieldInDsc(field);
	}
}
