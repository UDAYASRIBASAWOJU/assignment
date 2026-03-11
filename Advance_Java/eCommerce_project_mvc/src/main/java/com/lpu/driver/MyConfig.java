package com.lpu.driver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ComponentScan(basePackages = "com.lpu")
@Configuration
public class MyConfig {
	
	@Bean
	public ViewResolver resolve() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("dev");
	}

}
