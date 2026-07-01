package DAO;

import java.sql.*;
import java.util.*;

import model.Food;
import util.DBConnection;

public class FoodDAO {
	public boolean addFood(Food food){
		boolean status=false;
	
		try {
			Connection con=DBConnection.getConnection();
			String sql="INSERT INTO Food(food_name, price, description) VALUES(?,?,?)";			
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1,food.getName());
				ps.setDouble(2, food.getPrice());
				ps.setString(3, food.getCategory());
				
				int row=ps.executeUpdate();
				
				if(row>0) {
					status=true;
				}
				
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return status;
			
	}
	
	public List<Food> getAllFoods(){
		List<Food> list=new ArrayList<>();
		
		try {
			Connection con=DBConnection.getConnection();
			String sql="select * from Food";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
			    Food food = new Food();

			    food.setId(rs.getInt("food_id"));
			    food.setName(rs.getString("food_name"));
			    food.setPrice(rs.getDouble("price"));
			    food.setCategory(rs.getString("description"));

			    list.add(food);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public void insertFood(Food food) {

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "INSERT INTO food(food_name, price) VALUES(?,?)"
	        );

	        ps.setString(1, food.getName());
	        ps.setDouble(2, food.getPrice());

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteFood(int id) {

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "DELETE FROM food WHERE food_id=?"
	        );

	        ps.setInt(1, id);

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public Food getFoodById(int id) {

	    Food food = null;

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "SELECT * FROM food WHERE food_id=?"
	        );

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            food = new Food();
	            food.setId(rs.getInt("food_id"));
	            food.setName(rs.getString("food_name"));
	            food.setPrice(rs.getDouble("price"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return food;
	}
	
	public void updateFood(Food food) {

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "UPDATE food SET food_name=?, price=? WHERE food_id=?"
	        );

	        ps.setString(1, food.getName());
	        ps.setDouble(2, food.getPrice());
	        ps.setInt(3, food.getId());

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
