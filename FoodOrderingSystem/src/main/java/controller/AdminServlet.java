package controller;

import java.io.IOException;

import DAO.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		AdminDAO dao=new AdminDAO();
		
		Admin admin=dao.login(username, password);
		if(admin != null) {

		    HttpSession session = request.getSession();
		    session.setAttribute("admin", admin);

		    response.sendRedirect("adminDashboard.jsp");

		} else {

		    response.getWriter().println("Invalid Email or Password");

		}
		
	}

}
