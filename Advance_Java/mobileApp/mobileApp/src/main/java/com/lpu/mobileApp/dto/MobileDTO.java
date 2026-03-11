package com.lpu.mobileApp.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Schema(description = "Mobile Entity")
public class MobileDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Schema(description = "Brand name", example = "iPhone")
	@NotBlank
	private String brandName;
	
	@Schema(description = "Model name", example = "16 pro")
	@NotBlank
	private String modelName;
	
	@Schema(description = "Price", example = "89999")
	@Positive
	private double price;
	
	@Schema(description = "RAM", example = "16")
	@Positive
	private int ram;
	
	@Schema(description = "Storage", example = "128")
	@Positive
	private int storage;
	
	@Schema(description = "Color", example = "Black")
	@NotBlank
	private String color;
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getRam() {
		return ram;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public int getStorage() {
		return storage;
	}
	
	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
