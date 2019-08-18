package ru.servlets;

import ru.repositories.PasswordHashingImpl;
import ru.repositories.WorkWithUserBase;
import ru.repositories.WorkWithUserBaseImpl;
import ru.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(name,password);

        WorkWithUserBase userBase = WorkWithUserBaseImpl.storage;
        if(userBase.checkUserNameAndPassword(user)){
            System.out.println("Пользователь "+ name+ "   удачно залогинился");
            HttpSession session = req.getSession();
            session.setAttribute("user", name);
            req.getServletContext().getRequestDispatcher("/home").forward(req,resp);
        }else {
            System.out.println("ошибка авторизации");
            resp.sendRedirect(req.getContextPath()+"/login");
        }

    }
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
