package com.lpu;

//import java.util.List;

import com.lpu.student.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Driver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		//EntityTransaction transaction = em.getTransaction();
		
		Query query = em.createQuery("select s from Student s where s.phone = 87654");
		Student s = (Student)query.getSingleResult();	
     	System.out.println(s.getName());
   	
//		List<Student> students = query.getResultList();
//		
//		for(Student s : students) {
//			System.out.println(s.getStudentId() + " " + s.getName() + " " + s.getPhone());
		}
}