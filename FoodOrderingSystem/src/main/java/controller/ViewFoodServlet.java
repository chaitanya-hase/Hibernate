package controller;

import java.io.IOException;
import java.util.List;

import DAO.FoodDAO;
import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Food;

@WebServlet("/ViewFoodServlet")
public class ViewFoodServlet extends HttpServlet {
	
    public ViewFoodServlet() {
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodDAO dao = new FoodDAO();
		List<Food> list = dao.getAllFoods();

		System.out.println("Food Count = " + list.size());

		request.setAttribute("foods", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewFood.jsp");
		rd.forward(request, response);
	}

	

}
