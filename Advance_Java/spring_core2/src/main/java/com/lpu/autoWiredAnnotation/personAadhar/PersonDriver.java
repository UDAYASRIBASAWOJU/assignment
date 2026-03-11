package com.lpu.autoWiredAnnotation.personAadhar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.autoWiredAnnotation.MyConfig;

public class PersonDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		Person p = context.getBean("person", Person.class);
		
		System.out.println(p.getId());
		System.out.println(p.getName());
		
		Aadhar a = p.getAadhar();
		a.info();
		
		Vehicle v = p.getV();
		v.start();
		
		Fruit f = p.getFruit();
		f.eat();
	}
}
