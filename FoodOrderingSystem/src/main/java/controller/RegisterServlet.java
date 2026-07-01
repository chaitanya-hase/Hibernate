package controller;

import java.io.IOException;

import DAO.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Customer cs=new Customer();
		cs.setName(name);
		cs.setEmail(email);
		cs.setPassword(password);
		
		CustomerDAO doa=new CustomerDAO();
		boolean status=doa.register(cs);
		
		if(status) {
		    response.getWriter().println("Registration Successful");
		}
		else {
		    response.getWriter().println("Registration Failed");
		}
		
		//doGet(request, response);
	}

}
