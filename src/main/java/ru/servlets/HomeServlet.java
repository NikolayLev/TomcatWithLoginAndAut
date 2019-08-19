package ru.servlets;

import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.repositories.UserProductsBaseImpl;
import ru.users.User;
import ru.users.UserProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    UserProductsBaseImpl userProductsBase;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");
        String userName = (String) session.getAttribute("user");
        userProductsBase = new UserProductsBaseImpl(userName);
        List<UserProduct> productList = userProductsBase.getProductFromServer();
        request.setAttribute("userName", userName);
        request.setAttribute("productList", productList);
        request.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        String userName = (String) session.getAttribute("user");
        System.out.println(req.getCharacterEncoding());
        req.setAttribute("userName", userName);

        String id1 = req.getParameter("id1");
        String id2 = req.getParameter("id2");
        String id3 = req.getParameter("id3");
        String id4 = req.getParameter("id4");
        String id5 = req.getParameter("id5");
        System.out.println(id1+id2+id3+id4+id5);
        String[] ids = {id1, id2, id3, id4, id5};
        String price1 = req.getParameter("price1");
        String price2 = req.getParameter("price2");
        String price3 = req.getParameter("price3");
        String price4 = req.getParameter("price4");
        String price5 = req.getParameter("price5");
        String[] prices = {price1, price2, price3, price4, price5};
        for (int i = 0; i < 5; i++) {
            int z;
            if (ids[i] !="") {
                try {
                    z = Integer.parseInt(prices[i]);
                } catch (NumberFormatException ex) {
                    z = 0;
                }
                userProductsBase.userProductList().add(new UserProduct(ids[i], z));
            }

        }
        userProductsBase.addNewProducts(userProductsBase.userProductList());
        resp.sendRedirect(req.getContextPath() + "/home");


    }
}
