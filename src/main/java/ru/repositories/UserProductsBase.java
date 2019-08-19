package ru.repositories;

import ru.users.UserProduct;

import java.util.List;

public interface UserProductsBase {
    public List<UserProduct> userProductList();
    public List<UserProduct> getProductFromServer();
    public void addNewProducts(List<UserProduct> list);
}
