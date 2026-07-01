package controller;

import java.io.IOException;

import DAO.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Order;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();

        Customer customer=
        (Customer)session.getAttribute("customer");

        int quantity=
        Integer.parseInt(request.getParameter("quantity"));

        double price=
        Double.parseDouble(request.getParameter("price"));

        double total=quantity*price;

        Order order=new Order();

        order.setCustomerId(customer.getId());

        order.setTotalAmount(total);

        OrderDAO dao=new OrderDAO();

        boolean status=dao.placeOrder(order);

        if(status){

            response.getWriter()
            .println("Order Placed Successfully");

        }

        else{

            response.getWriter()
            .println("Order Failed");

        }

    }

}