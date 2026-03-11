package com.lpu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ComponentScan(basePackages = "com.lpu")
@Configuration
public class MyBeanConfiguration {
	
	@Bean
	public EntityManagerFactory getEMF() {
		return Persistence.createEntityManagerFactory("dev");
	}
}