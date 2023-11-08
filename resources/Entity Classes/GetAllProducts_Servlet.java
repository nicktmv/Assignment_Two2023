package com.example.assigment2k00260158;

import java.io.*;
import java.util.List;
import model.Product;
import model.ProductDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetAllProducts_Servlet", value = "/GetAllProducts")
public class GetAllProducts_Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nextPage = "";

        response.setContentType("text/html");

        List<Product> allProducts = ProductDB.getAll();

        if(allProducts ==null || allProducts.isEmpty()) {
            nextPage= "error.jsp";
            request.setAttribute("message", "There are no products in the database");
        }
        else {
            request.setAttribute("products", allProducts);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}