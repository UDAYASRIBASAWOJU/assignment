package com.lpu;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		//Creating container
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		
		
		System.out.println("Main Started");
//		Student student = new Student();
		Student student = context.getBean("myStudent", Student.class); //IOC
		System.out.println(student.getId());
		System.out.println(student.getName());
		student.getLaptop().start();
		student.study();
		
		College college = context.getBean("myCollege", College.class);
		college.teach();
		
		System.out.println("Main ended");

	}

}
