package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/lpu";
		String user = "postgres";
		String password = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stm = con.createStatement();
			
			stm.execute("DELETE FROM student WHERE id = 6");
			System.out.println("Deleted");
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
