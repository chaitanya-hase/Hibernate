package controller;

import java.io.IOException;

import DAO.FoodDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteFoodServlet")
public class DeleteFoodServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("id"));

	        FoodDAO dao = new FoodDAO();
	        dao.deleteFood(id);

	        response.sendRedirect("ViewFoodServlet");
	   }
}
