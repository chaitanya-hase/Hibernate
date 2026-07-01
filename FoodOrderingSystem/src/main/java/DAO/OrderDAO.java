package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import util.DBConnection;

public class OrderDAO {
	public boolean placeOrder(Order order){

	    boolean status=false;

	    try{

	        Connection con=DBConnection.getConnection();

	        String sql=
	        "insert into Orders(customer_id,total_amount) values(?,?)";

	        PreparedStatement ps=con.prepareStatement(sql);

	        ps.setInt(1,order.getCustomerId());

	        ps.setDouble(2,order.getTotalAmount());

	        int row=ps.executeUpdate();

	        if(row>0){

	            status=true;

	        }

	        ps.close();

	        con.close();

	    }

	    catch(Exception e){

	        e.printStackTrace();

	    }

	    return status;

	}

	public List<Order> getOrdersByCustomer(int customerId) {

    List<Order> list = new ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM Orders WHERE customer_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, customerId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Order order = new Order();

            order.setOrderId(rs.getInt("order_id"));
            order.setCustomerId(rs.getInt("customer_id"));
            order.setTotalAmount(rs.getDouble("total_amount"));

            list.add(order);
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

}
