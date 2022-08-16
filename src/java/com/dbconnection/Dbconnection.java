package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	public static Connection getConnection() throws SQLException{ 
		Connection con=null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbabane","root","");
						
		} catch (Exception e) {
			con.close();
			System.out.println(e);
		}	
		return con; 
	}		
}
