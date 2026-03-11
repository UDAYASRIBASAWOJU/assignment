package com.lpu.jdbc;

// Hibernet internally uses these 5 steps
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveOperation {

	public static void main(String[] args) {
		String url  = "jdbc:postgresql://localhost:5432/lpu";
		String user = "postgres"; //default user name
		String password = "root";
		
		
		try {  
			// Step - 1 : Load Driver               // org.postgresql is package
			Class.forName("org.postgresql.Driver"); //Here, Driver is Class. Now, Driver loads in Heap Area
			System.out.println("Loaded");
			
			// Step - 2 : Create Connection
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			// Step - 3 : Create Statement
			Statement stm = con.createStatement();
			
			// Step - 4 : Execute Query
			stm.execute("INSERT INTO student values(8, 'Veda', 9876543234, 96.4)");
			System.out.println("Inserted");
			
			// Step - 5 : Close Connection
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}