package ru.repositories;

public interface PasswordHashing {
    //интерфейс необходимый для вызова новых хешей и чек старых
    public boolean checkPassHash(String pass, String ourHash);

    public String createHashFromPass(String pass);

}

