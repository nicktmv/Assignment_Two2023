package com.example.assigment2k00260158;

import java.io.*;
import java.util.Optional;


import model.Product;
import model.ProductDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetProductByID", value = "/GetProductByID")
public class GetProductByID extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String nextPage = "";

        int productID = Integer.parseInt(request.getParameter("id"));

        Optional<Product> optProd = ProductDB.getProductByID(productID);

        if (optProd.isPresent()) {
            request.setAttribute("product", optProd.get());
            nextPage = "displayOne.jsp";
        }
        else {
            nextPage = "error.jsp";
            request.setAttribute("message", "Product " + productID + " not found");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

}