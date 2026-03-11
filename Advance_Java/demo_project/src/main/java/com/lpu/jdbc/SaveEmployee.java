package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class SaveEmployee {

    private static String url  = "jdbc:postgresql://localhost:5432/lpu";
    private static String user = "postgres";
    private static String password = "root";
    private static Connection con;
    
    static {
        try {
        	// Step 1: Load Driver
			Class.forName("org.postgresql.Driver");
			
			// Step 2: Create Connection
		    con = DriverManager.getConnection(url, user, password);
		       
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }

    public static void saveEmployee() throws SQLException{
        // Step 3: Create Statement
    	//Statement stm = con.createStatement();
            
        //Step 4: Execute Query
//        stm.execute("DELETE FROM employee WHERE id = 6");
//        stm.execute("INSERT INTO employee VALUES (6, 'Lally', 12000, 'lallyb@gmail.com', 8765434567)");

    	PreparedStatement ps = con.prepareStatement("insert into employee values(?, ?, ?, ?, ?)");

    	ps.setInt(1, 18);
    	ps.setString(2, "Abc");
    	ps.setInt(3, 13000);
    	ps.setString(4,"kjhgf@gmail.com");
    	ps.setLong(5, 67889843L);
    	
    	ps.execute(); 
        System.out.println("Inserted Successfully\n");
    }
    
	public static void fetchData() throws SQLException {
		Statement stm = con.createStatement();
		
		stm.execute("select * from employee");
				
		ResultSet rs = stm.getResultSet();
		
		while (rs.next()) {
			System.out.print(rs.getInt("id") + " ");
			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getInt("sal") + " ");
			System.out.print(rs.getString("email") + " ");
			System.out.print(rs.getBigDecimal("phone") + " ");
			System.out.println("\n");
		}
		
		System.out.println("Data fetched");
	}
    
    public static void closeConnection() throws SQLException {
    	con.close();
    }
    
    public static void main(String[] args) throws SQLException {
        saveEmployee();
        fetchData();
        closeConnection();
    }
}