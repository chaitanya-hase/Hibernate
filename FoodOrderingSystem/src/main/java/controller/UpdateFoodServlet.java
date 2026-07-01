package controller;

import java.io.IOException;

import DAO.FoodDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Food;



@WebServlet("/UpdateFoodServlet")
public class UpdateFoodServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        double price = Double.parseDouble(request.getParameter("price"));

	        Food food = new Food();
	        food.setId(id);
	        food.setName(name);
	        food.setPrice(price);

	        FoodDAO dao = new FoodDAO();
	        dao.updateFood(food);

	        response.sendRedirect("ViewFoodServlet");
    }
}


