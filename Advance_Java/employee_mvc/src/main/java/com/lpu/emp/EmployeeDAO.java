package com.lpu.emp;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Repository
public class EmployeeDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

    public void saveEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(employee);
        et.commit();
        em.close();
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        
        List<Employee> list = em.createQuery("from Employee", Employee.class).getResultList();
        
        em.close();
        
        return list;
    }

    public Employee getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        
        Employee emp = em.find(Employee.class, id);
        
        em.close();
        
        return emp;
    }

    public void updateEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.merge(emp);
        et.commit();
        em.close();
    }

    public void deleteEmployee(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Employee emp = em.find(Employee.class, id);
        
        et.begin();
        em.remove(emp);
        et.commit();
        em.close();
    }
}
