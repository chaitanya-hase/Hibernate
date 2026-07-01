package controller;

import java.io.IOException;
import java.util.List;

import DAO.FoodDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Food;


@WebServlet("/ViewMenuServlet")
public class ViewMenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        FoodDAO dao = new FoodDAO();

        List<Food> list = dao.getAllFoods();

        request.setAttribute("foods", list);

        RequestDispatcher rd =
                request.getRequestDispatcher("menu.jsp");

        rd.forward(request, response);
    }
}


