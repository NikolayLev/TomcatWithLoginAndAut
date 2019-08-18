package ru.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
