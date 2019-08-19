package ru.users;

import java.util.ArrayList;
import java.util.List;

public class UserProduct {
    private String productName;
    private int price;
    private UserProduct(){}
    public UserProduct(String productName,int price){
        this.productName=productName;
        this.price=price;
    }
    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
