package com.lpu.autoWiredAnnotation.studentId;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.autoWiredAnnotation.MyConfig;

public class StudentDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		Student s = context.getBean("student", Student.class);
		
		System.out.println(s.getId() + " " + s.getName());
		
		IdCard idCard = s.getIdCard();
		
		System.out.println(idCard.getIdNo() + " " + idCard.getCollegeName());
		
		idCard.idInfo();
		
		Student s2 = context.getBean("student", Student.class);
		Student s3 = context.getBean("student", Student.class);
		
		System.out.println(s);
		System.out.println(s2);
		System.out.println(s3);
	}

}
