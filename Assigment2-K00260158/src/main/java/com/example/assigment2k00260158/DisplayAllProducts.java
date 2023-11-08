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

@WebServlet(name = "GetProductByID_Servlet", value = "/DisplayAllProducts")
public class DisplayAllProducts extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nextPage = "";

        response.setContentType("text/html");

        List<Product> allProducts = ProductDB.getAllProducts();

        if(allProducts ==null || allProducts.isEmpty()) {
            nextPage= "error.jsp";
            request.setAttribute("message", "There are no Products in the database");
        }
        else {
            request.setAttribute("products", allProducts);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllProducts.jsp");
        dispatcher.forward(request, response);
    }

}