package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.ProductsDAO;
import com.lpu.entity.Categories;
import com.lpu.entity.Orders;
import com.lpu.entity.Products;

@Component
public class ProductsService {
	@Autowired
	private ProductsDAO productsDAO;
	
	public Products addProduct(int product_id, String product_name) {
		Products product = new Products(product_id, product_name);
		
		return productsDAO.addProduct(product);
	}
	
	public Products getProductById(int product_id) {
		Products product = productsDAO.getProductById(product_id);
		
		if(product == null) {
			throw new IllegalArgumentException("Order not found");
		}
		
		return product;
	}
	
	public void deleteProductbyId(int product_id) {
		productsDAO.deleteProduct(product_id);
	}
	
	public void assignOrderToProduct(int product_id, Orders order) {
		productsDAO.assignOrderToProduct(product_id, order);
	}
	
	public void assignCategoryToProduct(int product_id, Categories category) {
		productsDAO.assignCategoryToProduct(product_id, category);
	}
	
	public List<Orders> viewOrdersByProduct(int product_id){
		return productsDAO.viewOrdersByProduct(product_id);
	}
	
	public Categories viewCategoryByProduct(int product_id){
		return productsDAO.viewCategoryByProduct(product_id);
	}
}
