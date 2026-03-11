package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class UpdateOperation {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/lpu";
		String user = "postgres";
		String password = "root";
		
		try {
			//step - 1
			Class.forName("org.postgresql.Driver");
			
			//step - 2
			Connection con = DriverManager.getConnection(url, user, password);
			
			//step - 3
			Statement stm = con.createStatement();
			
			//step - 4
			stm.execute("UPDATE student SET name = 'Lally' WHERE id = 5");
			System.out.println("Updated");
			
			//step - 5
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
