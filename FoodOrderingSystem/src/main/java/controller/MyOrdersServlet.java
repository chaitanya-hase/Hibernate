package controller;

import java.io.IOException;
import java.util.List;

import DAO.OrderDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Order;

@WebServlet("/MyOrdersServlet")
public class MyOrdersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            response.sendRedirect("login.html");
            return;
        }

        OrderDAO dao = new OrderDAO();

        List<Order> orders = dao.getOrdersByCustomer(customer.getId());

        request.setAttribute("orders", orders);

        RequestDispatcher rd = request.getRequestDispatcher("myOrders.jsp");
        rd.forward(request, response);
    }
}