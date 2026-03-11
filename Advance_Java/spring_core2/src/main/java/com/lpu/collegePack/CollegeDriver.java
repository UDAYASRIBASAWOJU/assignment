package com.lpu.collegePack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
		
		College c = context.getBean("college", College.class);
		
		System.out.println(c.getId() + " " + c.getName() + " " + c.getLocation() + " " + c.getDept());

	}

}
