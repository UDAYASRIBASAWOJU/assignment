package com.lpu.manyToMany;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentSubjectDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Student student1 = new Student();
//		student1.setId(10);
//		student1.setName("SA");
//		student1.setPhone(98765432);
//		
//		Student student2 = new Student();
//		student2.setId(11);
//		student2.setName("SB");
//		student2.setPhone(765432345);
//		
//		Student student3 = new Student();
//		student3.setId(12);
//		student3.setName("SC");
//		student3.setPhone(7654456);
//		
//		Subject subject1 = new Subject();
//		subject1.setId(101);
//		subject1.setName("Java");
//		subject1.setTrainer("TA");
//		
//		Subject subject2 = new Subject();
//		subject2.setId(102);
//		subject2.setName("SQL");
//		subject2.setTrainer("TB");
//		
//		Subject subject3 = new Subject();
//		subject3.setId(103);
//		subject3.setName("Adv_Java");
//		subject3.setTrainer("TC");
//		
//		student1.setSubjects(Arrays.asList(subject1, subject2, subject3));
//		student2.setSubjects(Arrays.asList(subject1, subject3));
//		student3.setSubjects(Arrays.asList(subject2, subject3));
//		
//		subject1.setStudents(Arrays.asList(student1, student2));
//		subject2.setStudents(Arrays.asList(student1, student3));
//		subject3.setStudents(Arrays.asList(student1, student2, student3));
//		
//		et.begin();
//		em.persist(student1);
//		em.persist(student2);
//		em.persist(student3);
//		em.persist(subject1);
//		em.persist(subject2);
//		em.persist(subject3);
//		et.commit();
		
		Student student = em.find(Student.class, 10);
		
		//Subject subject = new Subject();
		
//		System.out.println(student.getId() + " " + student.getName());
//		for(Subject sub : student.getSubjects()) {
//			System.out.println(sub.getId() + " " + sub.getName() + " " + sub.getTrainer());
//		}
		
//		List<Subject> subjects = student.getSubjects();
//		Subject sub = subjects.get(0); // get first subject
//		sub.setTrainer("Sandeep");
		
		et.begin();
		for(Subject sub : student.getSubjects()) {
			if(sub.getName().equalsIgnoreCase("Java")) {
				sub.setTrainer("Sandy");
				em.merge(sub);
				System.out.println(sub.getId() + " " + sub.getName() + " " + sub.getTrainer());
			}
		}
		
		et.commit();
		
		System.out.println(student.getId() + " " + student.getName());
	}
}
