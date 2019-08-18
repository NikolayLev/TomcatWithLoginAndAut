package ru.servlets;

import ru.repositories.PasswordHashingImpl;
import ru.repositories.WorkWithUserBaseImpl;
import ru.users.HashUser;
import ru.users.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
    WorkWithUserBaseImpl dateBase;
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dateBase = WorkWithUserBaseImpl.storage;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = PasswordHashingImpl.getPasswordHashing.createHashFromPass(req.getParameter("password"));
        //важно! если имя пользователя есть в базе вернет true
        if (!dateBase.checkUser(name)){
            System.out.println("Добавили пользователя с ником: "+ name);
            User user = new HashUser(name,password);
            dateBase.addNewUser(user);
            req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }else{
            System.out.println("Пользователь уже есть в базе "+ name);

        }
        doGet(req,resp);

    }
}