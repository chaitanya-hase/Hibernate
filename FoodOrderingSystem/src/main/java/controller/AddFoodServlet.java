package controller;

import java.io.IOException;

import DAO.FoodDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Food;


@WebServlet("/AddFoodServlet")
public class AddFoodServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Food food = new Food();
        food.setName(name);
        food.setPrice(price);

        FoodDAO dao = new FoodDAO();
        dao.insertFood(food);

        response.sendRedirect("ViewFoodServlet");
    }
}