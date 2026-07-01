package controller;

import java.io.IOException;

import DAO.FoodDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Food;


@WebServlet("/EditFoodServlet")
public class EditFoodServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("id"));

	        FoodDAO dao = new FoodDAO();
	        Food food = dao.getFoodById(id);

	        request.setAttribute("food", food);

	        RequestDispatcher rd = request.getRequestDispatcher("editFood.jsp");
	        rd.forward(request, response);
	    
	}

}
