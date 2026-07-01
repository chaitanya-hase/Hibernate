package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;
import util.DBConnection;

public class CustomerDAO {
	public boolean register(Customer customer) {
		boolean status=false;
		try {
			Connection con=DBConnection.getConnection();
			String sql="insert into Customer(name ,email,password) values(?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPassword());
			
			int row=ps.executeUpdate();
			
			if(row>0) {
				status=true;
			}
			
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}
	
	public Customer login(String email, String password) {
		Customer customer = null;
		
		try {
		Connection con=DBConnection.getConnection();
		String sql="select * from Customer where email=? and password=?";
		
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,email);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			customer = new Customer();

			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
		 }
		rs.close();
		ps.close();
		con.close();
		}catch (Exception e) {
		        e.printStackTrace();
		 }

		
		return customer;
		
	}
}