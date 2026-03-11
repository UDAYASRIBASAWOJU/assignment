package com.lpu.student;

public interface StudentCRUD {
	
	public void saveStudent(Student s);
	
	public void updateStudentName(int id, String name);
	
	public void updateStudentPhone(int id, long phone);
	
	public void deleteStudent(int id);

	public void findStudent(int id);
}