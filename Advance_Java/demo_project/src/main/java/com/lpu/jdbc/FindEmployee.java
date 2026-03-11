package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindEmployee {
	private static String url = "jdbc:postgresql://localhost:5432/lpu";
	private static String user = "postgres";
	private static String password = "root";
	private static Connection con;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void fetchData() throws SQLException {
		Statement stm = con.createStatement();
		
		stm.execute("select * from employee");
				
		ResultSet rs = stm.getResultSet();
		
		while (rs.next()) {
			System.out.print(rs.getInt("id") + " ");
			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getInt("sal") + " ");
			System.out.println();
		}
		
		System.out.println("Data fetched");
	}
	
	public static void closeConnection() throws SQLException {
		con.close();
	}

	public static void main(String[] args) throws SQLException {
		fetchData();
		closeConnection();
	}
}
