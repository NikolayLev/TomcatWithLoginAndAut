package ru.repositories;

import ru.users.User;

public interface WorkWithUserBase {

    public boolean addNewUser(User user);

    public boolean checkUser(String userName);

    public boolean checkUserNameAndPassword(User user);
}

