package com.lpu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BeanLifeCycle {
	
	public BeanLifeCycle() {
		System.out.println("Instantiation");
	}
	
	private Connection connection;
	
	@PostConstruct                         //executes after DI phase
	public void init() {
		System.out.println("Initialisation");
		
		try {
			String url  = "jdbc:postgresql://localhost:5432/lpu";
		    String user = "postgres";
		    String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Database Connected Successfully");
            }

        } catch (SQLException e) {
            System.out.println("DB Connection Failed");
            e.printStackTrace();
        }
	}
	
	public void useBean() {
		System.out.println("Using bean");
	}
	
	@PreDestroy                          //executes before bean destruction
	public void destroy() {
		System.out.println("Destroy");
		
		try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database Connection Closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
