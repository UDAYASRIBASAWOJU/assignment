package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeController {
	
	@Autowired
	private EmployeeService empser;
	
	public Employee call() {
		return empser.SaveEmployee(1, "udaya", "java");
	}

}
