package com.lpu.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentCRUDImplentation implements StudentCRUD{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public static void main(String[] args) {
		StudentCRUDImplentation si = new StudentCRUDImplentation();
		
		Student s = new Student();
		s.setStudentId(18);
		s.setName("fdfhj");
		s.setPhone(8765434);
		si.saveStudent(s);
		
		si.updateStudentName(12, "Keer");
		
		si.updateStudentPhone(13, 234567);
		
		si.deleteStudent(16);
		
		si.findStudent(10);
	}

	@Override
	public void saveStudent(Student s) {
		et.begin();
		em.persist(s);
		et.commit();
		
		System.out.println("Saved");
	}

	@Override
	public void updateStudentName(int id, String name) {
		Student s = em.find(Student.class, id);
		s.setName(name);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		System.out.println("Updated name");
		
	}

	@Override
	public void updateStudentPhone(int id, long phone) {
		Student s = em.find(Student.class, id);
		s.setPhone(phone);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		System.out.println("Updated phone");
		
	}

	@Override
	public void deleteStudent(int id) {
		Student s = em.find(Student.class, id);
		
		et.begin();
		
		if (s != null) {
            em.remove(s);
            System.out.println("Deleted");
        } else {
            System.out.println("Student not found");
        }
		
		et.commit();
	}

	@Override
	public void findStudent(int id) {
		Student s = em.find(Student.class, id);
		
		System.out.println("Found : " + s.getStudentId() + " " + s.getName() + " " + s.getPhone());
	}

}