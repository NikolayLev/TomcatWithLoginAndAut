package ru.repositories;

import ru.users.User;

import java.sql.*;
import java.util.*;

public class WorkWithUserBaseImpl implements WorkWithUserBase {

    private String dbUser;

    @Override
    public boolean checkUser(String userName) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT name FROM project_user WHERE name ='" + userName + "'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private String dbPassword;
    private String connectionUrl;
    private Connection connection;
    private Statement statement;

    public static WorkWithUserBaseImpl storage;

    static {
        try {
            storage = new WorkWithUserBaseImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addNewUser(User user1) {
        String name1 = user1.getName();
        String password1 = user1.getPassword();
        user1.getName();

        if (!checkUser(user1.getName())) {
            System.out.println("Добавили нового пользователя");
            try {
                statement.execute("INSERT INTO project_user(name, password) VALUES ('" + name1 + "','" + password1 + "')");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return true;
        } else {
            System.out.println("Пользователь " + user1.getName() + " уже есть в базе");
            return false;

        }
    }
    public boolean checkUserNameAndPassword(User user){
       boolean checkUser=false;
       String name = user.getName();
       String password = user.getPassword();
       String hashPassword;
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT name, password FROM project_user WHERE name ='" + name + "'");

            if (resultSet.next()) {
                resultSet.getString("name");
                hashPassword = resultSet.getString("password");
            }else{
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        if (PasswordHashingImpl.getPasswordHashing.checkPassHash(password, hashPassword)){
            checkUser=true;
        }else {
            return false;
        }

       return checkUser;
    }


    private WorkWithUserBaseImpl(){
    dbUser="postgres";
    dbPassword ="a5a884ec5";
    connectionUrl="jdbc:postgresql://localhost:5432/UsersForProject";
        try {
            connection=DriverManager.getConnection(connectionUrl,dbUser,dbPassword);
            statement =connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


}
}
