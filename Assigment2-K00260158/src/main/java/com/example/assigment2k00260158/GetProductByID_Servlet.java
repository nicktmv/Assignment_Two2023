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

@WebServlet(name = "GetProductByID_Servlet", value = "/GetProductByID")
public class GetProductByID_Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String nextPage = "";

        response.setContentType("text/html");

        int productID = Integer.parseInt(request.getParameter("id"));

        Optional<Product> optProduct = ProductDB.getProductByID(productID);

        if(optProduct.isPresent()) {
            request.setAttribute("product", optProduct.get());
            nextPage = "displayOne.jsp";
        }
        else {
            nextPage = "error.jsp";
            request.setAttribute("message", "Product " + productID + " not found");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}