package com.lpu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jakarta.persistence.EntityManagerFactory;

public class EmployeeDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfiguration.class);
		
//		Employee emp = context.getBean("myEmployee", Employee.class);
//		System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDept());
		
		
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		System.out.println(emf);

	}

}
