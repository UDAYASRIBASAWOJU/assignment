package prac;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
	int id;
	String name;
	String department;
	double salary;

	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "{id = " + id + ", name = " + name + ", dept = " + department + ", salary =" + salary + " } \n";
	}

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(1, "udaya", "eee", 56789));
		empList.add(new Employee(2, "varun", "bba", 23445));
		empList.add(new Employee(3, "akshaya", "cse", 45654));
		empList.add(new Employee(4, "veda", "cse", 12345));
		empList.add(new Employee(5, "lally", "eee", 45673));
		
		Map<String, List<Employee>> byDepart = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(byDepart);
		
		double highSal =  empList.stream().mapToDouble(Employee::getSalary).max().orElse(0);
		System.out.print("High paid Employee : ");
		empList.stream().filter(n -> n.getSalary() == highSal).map(Employee::getName).forEach(System.out::print);
		
		System.err.println("\n");
		empList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
			.forEach((dept, avg) -> System.out.println(dept + " - " + avg));
	}
}
