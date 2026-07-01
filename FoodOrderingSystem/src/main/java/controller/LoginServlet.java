package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;


@jakarta.servlet.annotation.WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
       
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		CustomerDAO dao=new CustomerDAO();
		
		Customer customer = dao.login(email, password);

		if(customer != null) {

		    HttpSession session = request.getSession();
		    session.setAttribute("customer", customer);

		    response.sendRedirect("customerHome.jsp");

		} else {

		    response.getWriter().println("Invalid Email or Password");

		}
		
		
	}

}
