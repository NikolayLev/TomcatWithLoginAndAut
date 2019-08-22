package ru.repositories;

import org.springframework.security.access.method.P;
import ru.users.UserProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserProductsBaseImpl implements UserProductsBase {
    private String userName;
    private String dbUser;
    private String dbPassword;
    private String connectionUrl;
    private Connection connection;


    private List<UserProduct> listfromServer = new ArrayList<>();

    @Override
    public List<UserProduct> userProductList() {
        return listfromServer;
    }

    private UserProductsBaseImpl() {

    }

    public UserProductsBaseImpl(String userName) {
        this.userName = userName;
        dbUser = "postgres";
        dbPassword = "a5a884ec5";
        connectionUrl = "jdbc:postgresql://localhost:5432/UsersForProject";
        try {
            connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addNewProducts(List<UserProduct> list) {
        Iterator<UserProduct> iterator = list.iterator();
        while (iterator.hasNext()) {
            UserProduct userProduct = iterator.next();
            String product = userProduct.getProductName();
            int price = userProduct.getPrice();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userproducts(name, product, price) VALUES (?,?,?)");
                preparedStatement.setString(1,userName);
                preparedStatement.setString(2,product);
                preparedStatement.setInt(3,price);
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public List<UserProduct> getProductFromServer() {
        List<UserProduct> innerList = new ArrayList<>();
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT product, price FROM userproducts WHERE name = ?");
            preparedStatement.setString(1,userName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String product = resultSet.getString("product");
                int price = resultSet.getInt("price");
                innerList.add(new UserProduct(product, price));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return innerList;
    }
}
