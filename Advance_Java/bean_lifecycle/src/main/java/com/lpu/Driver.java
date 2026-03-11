package com.lpu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		BeanLifeCycle2 bean= context.getBean(BeanLifeCycle2.class);
		
		bean.fetchData();
		context.close();
	}

}
