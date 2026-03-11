package com.lpu.jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class EmployeeUserInput {
	private static String url = "jdbc:postgresql://localhost:5432/lpu";
	private static String user = "postgres";
	private static String password = "root";
	private static Connection con;
	
	private static Scanner sc = new Scanner(System.in);
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addData() throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into employee values(?, ?, ?, ?, ?)");
		
		System.out.print("Enter id: ");
		ps.setInt(1, sc.nextInt());
		
		System.out.print("Enter name: ");
		ps.setString(2, sc.nextLine());
		
		System.out.print("Enter sal: ");
		ps.setInt(3, sc.nextInt());
		
		System.out.print("Enter email: ");
		ps.setString(4, sc.nextLine());
		
		System.out.print("Enter phone: ");
		ps.setLong(5, sc.nextLong());
		
		ps.execute();
		System.out.println("Inserted");
	}
	
	
	public static void update() throws SQLException {
		PreparedStatement ps = con.prepareStatement("update employee set phone = ? where id = ?");
		
		System.out.print("Enter id: ");
		ps.setInt(2, sc.nextInt());
		
		System.out.print("Enter phone: ");
		ps.setLong(1, sc.nextLong());
		
		
		ps.execute();
		System.out.println("Updated");
	}
	
	public static void closeConnection() throws SQLException {
    	con.close();
    }
    
	public static void main(String[] args) throws SQLException{
		
//		addData();
		
		update();
		closeConnection();
		
	}
}