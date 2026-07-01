package util;

import java.sql.*;
public class DBConnection {
		
		private static Connection con;
		
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/FoodOrderSystem";
		String user="root";
		String password="root123";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con=DriverManager.getConnection( url,user,password);
			 
			 
		}
		catch(Exception e) {
			
		}
		return con;
	}

	

}
