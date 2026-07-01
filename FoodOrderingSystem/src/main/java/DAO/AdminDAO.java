package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

import util.DBConnection;

public class AdminDAO {

	public Admin login(String username, String password) {
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Admin WHERE username=? AND password=?";
		Admin ad=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				 ad = new Admin();

				ad.setId(rs.getInt("id"));
				ad.setEmail(rs.getString("email"));
				ad.setPassword(rs.getString("password"));
			 }
			
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ad;
		
	}
}
