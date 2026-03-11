package com.lpu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		Student s = context.getBean("myStudent", Student.class);
		s.study();
		System.out.println(s.getId());
		System.out.println(s.getName());
	}

}
