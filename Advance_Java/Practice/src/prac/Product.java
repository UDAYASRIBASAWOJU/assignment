package prac;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int productId;
	private String name;
	private double price;
	private int quantity;
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	List<Product> list = new ArrayList<Product>();
	
	public void addProduct(Product p) {
		list.add(p);
	}
	
	public void removeProduct(int productId) {
		 list.stream().filter(n -> n.getProductId() == productId).forEach(list::remove);
	}
	
	public double calculateTotal() {
		 return list.stream().mapToDouble(Product::getPrice).sum();
	}
	
	
}
