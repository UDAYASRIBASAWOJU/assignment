package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeDAO empdao ;
	
	public Employee SaveEmployee(int id, String name, String dept) {
		Employee emp = new Employee(id, name, dept);
		
		return empdao.SaveEmployee(emp);
	}

}
