package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.CategoriesDAO;
import com.lpu.entity.Categories;
import com.lpu.entity.Products;

@Component
public class CategoriesService {
	@Autowired
	private CategoriesDAO categoriesDAO;
	
	public Categories addCategory(int category_id, String category_name, String category_type) {
		Categories cat = new Categories(category_id, category_name, category_type);
		
		return categoriesDAO.addCategory(cat);
	}
	
	public Categories getCategoryById(int category_id) {
		Categories cat = categoriesDAO.getCateoryById(category_id);
		
		if(cat == null) {
			throw new IllegalArgumentException("Category not found");
		}
		
		return cat;
	}
	
	public void deleteCategorybyId(int category_id) {
		categoriesDAO.deleteCategory(category_id);
	}
	
	public void assignProductToCategory(int category_id, Products product) {
		categoriesDAO.assignProductToCategory(category_id, product);
	}
	
	public List<Products> viewProductsByCategory(int category_id){
		return categoriesDAO.viewProductsByCategory(category_id);
	}
}